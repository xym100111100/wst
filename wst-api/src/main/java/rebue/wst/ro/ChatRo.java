package rebue.wst.ro;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 查询消息Ro
 * 
 * @author xym
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class ChatRo {
	
	/**
	 * 未读消息数量
	 */
	private int notReadCount;

	/**
	 * 接受用户的微信头像路径
	 */
	private String toUserWxfacePath;

	private String toUserName;

	/**
	 * 消息ID 数据库字段: WST_CHAT.ID
	 */
	private Long id;

	/**
	 * 发送者用户ID 数据库字段: WST_CHAT.FROM_USER_ID
	 */
	private Long fromUserId;

	/**
	 * 接收者用户ID 数据库字段: WST_CHAT.TO_USER_ID
	 */
	private Long toUserId;

	/**
	 * 消息类型1：文本2：图片 数据库字段: WST_CHAT.MESSAGES_TYPE
	 */
	private Byte messagesType;

	/**
	 * 是否已读 数据库字段: WST_CHAT.ALREADY_READ
	 */
	private Boolean alreadyRead;

	/**
	 * 聊天内容(可能是文本，也可能是图片路径) 数据库字段: WST_CHAT.CONTENT
	 */
	private String content;

	/**
	 * 发送时间 数据库字段: WST_CHAT.FROM_TIME
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fromTime;
}
