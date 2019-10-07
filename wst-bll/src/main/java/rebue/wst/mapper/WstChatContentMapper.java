package rebue.wst.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.wst.mo.WstChatContentMo;

@Mapper
public interface WstChatContentMapper extends MybatisBaseMapper<WstChatContentMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(WstChatContentMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(WstChatContentMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    WstChatContentMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(WstChatContentMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(WstChatContentMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<WstChatContentMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<WstChatContentMo> selectSelective(WstChatContentMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(WstChatContentMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(WstChatContentMo record);
}