package rebue.wst.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.wst.mo.WstChatMo;

@Mapper
public interface WstChatMapper extends MybatisBaseMapper<WstChatMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(WstChatMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(WstChatMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    WstChatMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(WstChatMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(WstChatMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<WstChatMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<WstChatMo> selectSelective(WstChatMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(WstChatMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(WstChatMo record);
}