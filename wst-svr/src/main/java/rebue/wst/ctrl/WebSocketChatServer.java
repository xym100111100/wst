package rebue.wst.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.yeauty.annotation.ServerEndpoint;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import rebue.wst.svc.WstChatSvc;

import org.springframework.stereotype.Component;
import org.yeauty.annotation.OnBinary;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnError;
import org.yeauty.annotation.OnEvent;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

@RestController
@ServerEndpoint(prefix = "netty-websocket")
public class WebSocketChatServer {

	private static Map<String, WebSocketChatServer> webSocketSet = new ConcurrentHashMap<>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	// 当前发消息的人员编号
	private String userId = "";

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
		System.out.println(session.id());
		String paramValue = parameterMap.getParameter("paramKey");
		this.session = session;
		webSocketSet.put(paramValue, this);// 加入map中
		System.out.println(paramValue);
	}

	@OnClose
	public void onClose(Session session) throws IOException {
		System.out.println(session.id());
		System.out.println("one connection closed");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		throwable.printStackTrace();
	}

	@OnMessage
	public void OnMessage(Session session, String message) {
		wstChatSvc.getById(1656546l);
		System.out.println(session.id());
		System.out.println(message);
		if (webSocketSet.get("123") != null) {
			webSocketSet.get("123").session.sendText(message);
		}
		System.out.println(webSocketSet.size());
		session.sendText(message);
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
