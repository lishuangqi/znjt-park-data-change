package org.spring.springboot.service.impl;

import org.spring.springboot.dao.master.QcsVDjygcMasterDao;
import org.spring.springboot.domain.QcsVDjygcMaster;
import org.spring.springboot.domain.VDjygcCluster;
import org.spring.springboot.service.QcsVDjygcMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务接口层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class QcsVDjygcMasterServiceImpl implements QcsVDjygcMasterService{
    @Autowired
    private QcsVDjygcMasterDao qcsVDjygcMasterDao; // 主数据源

    /**
     * 根据序号最大值
     *
     * @return
     */
    @Override
    public long findByMaxClxxbh(){
        return qcsVDjygcMasterDao.findByMaxClxxbh();
    }

    /**
     * 选择大于当前序号的值
     * @return
     */
    public List<QcsVDjygcMaster> findByGreaterClxxbh(long clxxbh){
        return qcsVDjygcMasterDao.findByGreaterClxxbh(clxxbh);
    }

    @Override
    public int insertSelective(VDjygcCluster data) {
        return qcsVDjygcMasterDao.insertSelective(data);
    }

    @Override
    public int insertSelective(QcsVDjygcMaster data) {
        System.out.println(data);
        return qcsVDjygcMasterDao.insertSelective(data);
    }
}
