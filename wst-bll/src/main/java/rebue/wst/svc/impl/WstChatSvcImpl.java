package rebue.wst.svc.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.suc.mo.SucUserMo;
import rebue.suc.svr.feign.SucUserSvc;
import rebue.wst.dao.WstChatDao;
import rebue.wst.jo.WstChatJo;
import rebue.wst.mapper.WstChatMapper;
import rebue.wst.mo.WstChatMo;
import rebue.wst.ro.ChatRo;
import rebue.wst.svc.WstChatSvc;

/**
 * 用户聊天记录
 *
 * 在单独使用不带任何参数的 @Transactional 注释时， propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED， 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意： 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
@Slf4j
public class WstChatSvcImpl extends BaseSvcImpl<java.lang.Long, WstChatJo, WstChatDao, WstChatMo, WstChatMapper>
		implements WstChatSvc {

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(WstChatMo mo) {
		log.info("wstChatSvc.add: 添加用户聊天记录 mo-", mo);
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		return super.add(mo);
	}

	@Resource
	private SucUserSvc sucUserSvc;

	/**
	 * 查询用户与最新用户聊天的记录
	 * 
	 * 1:获取到所有和自己有聊天的用户id 2:获取自己和该用户最新的聊天记录 3:获取toUserId是我FromUserId是他
	 * 且alreadyRead字段为false的记录数量
	 * 
	 */
	@Override
	public List<ChatRo> getChatByUserId(Long userId) {

		List<ChatRo> result = new ArrayList<ChatRo>();
		// 1:获取到所有和自己有聊天的用户id
		List<Long> otherUserIds = _mapper.getOtherUserId(userId);
		log.info("otherUserId", otherUserIds);
		// 2:获取自己和该用户最新的聊天记录
		// 拼接用户id去获取用户名称和头像
		String userIds = "";
		int i = 0;
		for (Long otherUserId : otherUserIds) {
			log.info("获取最新消息的参数为userId:{}otherUserId:{}", userId, otherUserId);
			ChatRo newestMsg = _mapper.getNewestMsg(userId, otherUserId);
			log.info("获取最新消息的结果为newestMsg:{}", newestMsg);
			// 3:获取toUserId是我FromUserId是他且alreadyRead字段为false的记录数量
			log.info("获取未读消息参数为userId:{}otherUserId:{}", userId, otherUserId);
			int notReadCount = _mapper.getNotReadCount(userId, otherUserId);
			log.info("获取未读消息结果为notReadCount:{}", notReadCount);
			newestMsg.setNotReadCount(notReadCount);
			result.add(newestMsg);

			// 判断并拼接该使用获取用户名称和头像
			i += 1;
			userIds += "'";
			userIds += otherUserId;
			userIds += "'";
			if (i < otherUserIds.size()) {
				userIds += ',';
			}
		}

		log.info("获取用户名称和头像的ids参数是:-{}", userIds);
		List<SucUserMo> userResult = sucUserSvc.getByIds(userIds);
		for (final ChatRo item : result) {
			// 如果userId等于查询回来的记录fromUserId,证明是我发给人家的前面是使用toUserId去查询的用户
			if (item.getFromUserId().equals(userId)) {
				for (SucUserMo sucUserMo : userResult) {
					if (item.getToUserId().equals(sucUserMo.getId())) {
						item.setToUserName(sucUserMo.getWxName());
						item.setToUserWxfacePath(sucUserMo.getWxFacePath());
					}
				}
			} else {
				for (SucUserMo sucUserMo : userResult) {
					if (item.getFromUserId().equals(sucUserMo.getId())) {
						item.setToUserName(sucUserMo.getWxName());
						item.setToUserWxfacePath(sucUserMo.getWxFacePath());
					}
				}
			}

		}
		return result;

	}

	@Override
	public PageInfo<WstChatMo> listChat(WstChatMo mo, Integer pageNum, Integer pageSize) {

		return PageHelper.startPage(pageNum, pageSize)
				.doSelectPageInfo(() -> _mapper.listChat(mo.getFromUserId(), mo.getToUserId()));
	}
	
	
	@Override
	public int getUnreadContentByToUserId(Long toUserId) {
		
		return _mapper.getUnreadContentByToUserId(toUserId);
	}

	@Override
	public int cleanUnreadContent(WstChatMo mo) {
		return _mapper.cleanUnreadContent(mo.getToUserId(), mo.getFromUserId());
	}
}
