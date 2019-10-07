package rebue.wst.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
用户聊天记录

数据库表: WST_CHAT

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class WstChatMo implements Serializable {
    /**
    消息ID
    
    数据库字段: WST_CHAT.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    发送者用户ID
    
    数据库字段: WST_CHAT.FROM_USER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long fromUserId;

    /**
    接收者用户ID
    
    数据库字段: WST_CHAT.TO_USER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long toUserId;

    /**
    消息类型1：文本2：图片
    
    数据库字段: WST_CHAT.MESSAGES_TYPE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Byte messagesType;

    /**
    是否已读
    
    数据库字段: WST_CHAT.ALREADY_READ
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Boolean alreadyRead;

    /**
    发送时间
    
    数据库字段: WST_CHAT.FROM_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date fromTime;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    消息ID
    
    数据库字段: WST_CHAT.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    消息ID
    
    数据库字段: WST_CHAT.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    发送者用户ID
    
    数据库字段: WST_CHAT.FROM_USER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getFromUserId() {
        return fromUserId;
    }

    /**
    发送者用户ID
    
    数据库字段: WST_CHAT.FROM_USER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
    接收者用户ID
    
    数据库字段: WST_CHAT.TO_USER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getToUserId() {
        return toUserId;
    }

    /**
    接收者用户ID
    
    数据库字段: WST_CHAT.TO_USER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    /**
    消息类型1：文本2：图片
    
    数据库字段: WST_CHAT.MESSAGES_TYPE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Byte getMessagesType() {
        return messagesType;
    }

    /**
    消息类型1：文本2：图片
    
    数据库字段: WST_CHAT.MESSAGES_TYPE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setMessagesType(Byte messagesType) {
        this.messagesType = messagesType;
    }

    /**
    是否已读
    
    数据库字段: WST_CHAT.ALREADY_READ
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Boolean getAlreadyRead() {
        return alreadyRead;
    }

    /**
    是否已读
    
    数据库字段: WST_CHAT.ALREADY_READ
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setAlreadyRead(Boolean alreadyRead) {
        this.alreadyRead = alreadyRead;
    }

    /**
    发送时间
    
    数据库字段: WST_CHAT.FROM_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Date getFromTime() {
        return fromTime;
    }

    /**
    发送时间
    
    数据库字段: WST_CHAT.FROM_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", messagesType=").append(messagesType);
        sb.append(", alreadyRead=").append(alreadyRead);
        sb.append(", fromTime=").append(fromTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WstChatMo other = (WstChatMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}