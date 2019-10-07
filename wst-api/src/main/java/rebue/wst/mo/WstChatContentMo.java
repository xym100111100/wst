package rebue.wst.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
聊天内容

数据库表: WST_CHAT_CONTENT

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class WstChatContentMo implements Serializable {
    /**
    聊天内容ID
    
    数据库字段: WST_CHAT_CONTENT.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    消息ID
    
    数据库字段: WST_CHAT_CONTENT.CHAT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long chatId;

    /**
    内容(可能是文本或者是图片内容的路径)
    
    数据库字段: WST_CHAT_CONTENT.CONTENT
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String content;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    聊天内容ID
    
    数据库字段: WST_CHAT_CONTENT.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    聊天内容ID
    
    数据库字段: WST_CHAT_CONTENT.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    消息ID
    
    数据库字段: WST_CHAT_CONTENT.CHAT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getChatId() {
        return chatId;
    }

    /**
    消息ID
    
    数据库字段: WST_CHAT_CONTENT.CHAT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    /**
    内容(可能是文本或者是图片内容的路径)
    
    数据库字段: WST_CHAT_CONTENT.CONTENT
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getContent() {
        return content;
    }

    /**
    内容(可能是文本或者是图片内容的路径)
    
    数据库字段: WST_CHAT_CONTENT.CONTENT
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setContent(String content) {
        this.content = content;
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
        sb.append(", chatId=").append(chatId);
        sb.append(", content=").append(content);
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
        WstChatContentMo other = (WstChatContentMo) that;
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