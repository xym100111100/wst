package rebue.wst.svc;

import java.util.List;

import com.github.pagehelper.PageInfo;

import rebue.robotech.svc.BaseSvc;
import rebue.wst.jo.WstChatJo;
import rebue.wst.mo.WstChatMo;
import rebue.wst.ro.ChatRo;

/**
 * 用户聊天记录
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface WstChatSvc extends BaseSvc<java.lang.Long, WstChatMo, WstChatJo> {

	List<ChatRo> getChatByUserId(final java.lang.Long userId);

	PageInfo<WstChatMo> listChat(WstChatMo mo, Integer pageNum, Integer pageSize);
}
