package org.spring.springboot.dao.master;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.QcsVDjygcMaster;
import org.spring.springboot.domain.VDjygcCluster;

import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface QcsVDjygcMasterDao {

    /**
     * 根据序号最大值
     *
     * @return
     */
    long findByMaxClxxbh();

    /**
     * 选择大于当前序号的值
     * @return
     */
    List<QcsVDjygcMaster> findByGreaterClxxbh(long clxxbh);

    int insertSelective(VDjygcCluster data);

    int insertSelective(QcsVDjygcMaster data);
}
