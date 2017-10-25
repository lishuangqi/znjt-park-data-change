package org.spring.springboot.dao.master;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.TParkInfoCluster;

import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface QcsParkinglogMasterDao {


    /**
     * 更新停车场的值
     * @return
     */
    List<TParkInfoCluster> findByLastest(TParkInfoCluster data);
}
