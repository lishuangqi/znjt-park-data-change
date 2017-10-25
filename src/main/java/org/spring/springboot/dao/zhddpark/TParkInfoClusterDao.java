package org.spring.springboot.dao.zhddpark;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.TParkInfoCluster;
import org.spring.springboot.domain.VDjygcCluster;

import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface TParkInfoClusterDao {


    /**
     * 更新停车场的值
     * @return
     */
    int updateParkData(TParkInfoCluster data);
}
