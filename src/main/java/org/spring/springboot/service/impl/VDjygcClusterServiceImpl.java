package org.spring.springboot.service.impl;

import org.spring.springboot.dao.znjt.VDjygcClusterDao;
import org.spring.springboot.domain.QcsVDjygcMaster;
import org.spring.springboot.domain.VDjygcCluster;
import org.spring.springboot.service.VDjygcClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务接口层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class VDjygcClusterServiceImpl implements VDjygcClusterService{
    @Autowired
    private VDjygcClusterDao vDjygcMasterDao; // 主数据源

    /**
     * 根据序号最大值
     *
     * @return
     */
    @Override
    public long findByMaxClxxbh(){
        return vDjygcMasterDao.findByMaxClxxbh();
    }

    /**
     * 选择大于当前序号的值
     * @return
     */
    public List<VDjygcCluster> findByGreaterClxxbh(long clxxbh){
        return vDjygcMasterDao.findByGreaterClxxbh(clxxbh);
    }

    /**
     * 选择大于当前序号的值
     * @return
     */
    public List<QcsVDjygcMaster> findByGreaterClxxbhForMaster(long clxxbh){
        return vDjygcMasterDao.findByGreaterClxxbhForMaster(clxxbh);
    }
}
