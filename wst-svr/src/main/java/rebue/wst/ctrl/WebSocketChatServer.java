package rebue.wst.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.yeauty.annotation.ServerEndpoint;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import rebue.wst.mo.WstChatMo;
import rebue.wst.svc.WstChatSvc;
import org.yeauty.annotation.OnBinary;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnError;
import org.yeauty.annotation.OnEvent;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@Slf4j
@ServerEndpoint(prefix = "netty-websocket")
public class WebSocketChatServer {

	private static Map<String, WebSocketChatServer> webSocketSet = new ConcurrentHashMap<>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	// 当前发消息的人员编号

	@Autowired
	private WstChatSvc wstChatSvc;


	/**
	 * 
	 * @param session
	 * @param headers
	 * @param parameterMap
	 *            可以在连接的时候传递参数过来
	 * @throws IOException
	 */
	@OnOpen
	public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
		System.out.println("new connection");
		log.info("new connection");
		log.info("sessionId-{}", session.id());

		String userId = parameterMap.getParameter("paramKey");
		this.session = session;
		log.info("userId-{}", userId);
		webSocketSet.put(userId, this);// 加入map中
	}

	@OnClose
	public void onClose(Session session) throws IOException {
		log.info("sessionId-{}", session.id());
		log.info("one connection closed");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		throwable.printStackTrace();
	}

	@OnMessage
	public void OnMessage(Session session, String message) {
		System.out.println(message);
		log.info("message-{}", message);
		JSONObject jsonObject = JSONObject.parseObject(message);
		WstChatMo chatMo = new WstChatMo();
		if (webSocketSet.get(jsonObject.get("toUserId")) != null) {
			log.info("在线");
			// 标记已读标示为true
			chatMo.setAlreadyRead(true);
			webSocketSet.get(jsonObject.get("toUserId")).session.sendText(message);
		} else {
			// 标记已读标示为false
			chatMo.setAlreadyRead(false);
			log.info("不在线");
		}
		// 添加聊天记录
		chatMo.setFromTime(new Date());
		chatMo.setFromUserId(Long.parseLong(String.valueOf(jsonObject.get("fromUserId"))));
		chatMo.setToUserId(Long.parseLong(String.valueOf(jsonObject.get("toUserId"))));
		chatMo.setMessagesType((byte) 1);
		chatMo.setContent(String.valueOf(jsonObject.get("msg")));
		log.info("添加聊天记录的参数为-{}", chatMo);
		int i = wstChatSvc.add(chatMo);
		log.info("添加聊天记录的结果为-{}", i);
		log.info("webSocketSet.size()-{}", webSocketSet.size());

	}

	@OnBinary
	public void onBinary(Session session, byte[] bytes) {
		for (byte b : bytes) {
			System.out.println("onbinary:" + b);
		}
		session.sendBinary(bytes);
	}

	@OnEvent
	public void onEvent(Session session, Object evt) {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
			switch (idleStateEvent.state()) {
			case READER_IDLE:
				System.out.println("read idle");
				break;
			case WRITER_IDLE:
				System.out.println("write idle");
				break;
			case ALL_IDLE:
				System.out.println("all idle");
				break;
			default:
				break;
			}
		}
	}

}
