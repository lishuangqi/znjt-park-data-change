package org.spring.springboot.dao.znjt;

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
public interface VDjygcClusterDao {

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
    List<VDjygcCluster> findByGreaterClxxbh(long clxxbh);


    /**
     * 选择大于当前序号的值
     * @return
     */
    List<QcsVDjygcMaster> findByGreaterClxxbhForMaster(long clxxbh);
}
