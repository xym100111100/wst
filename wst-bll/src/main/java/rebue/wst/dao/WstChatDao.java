package rebue.wst.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rebue.wst.jo.WstChatJo;

public interface WstChatDao extends JpaRepository<WstChatJo, java.lang.Long> {
}
