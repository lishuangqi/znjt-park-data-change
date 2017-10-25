package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.zhddpark.TParkInfoClusterDao;
import org.spring.springboot.dao.master.QcsParkinglogMasterDao;
import org.spring.springboot.domain.TParkInfoCluster;
import org.spring.springboot.service.TParkInfoClusterService;
import org.spring.springboot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务接口层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class TParkInfoClusterServiceImpl implements TParkInfoClusterService{
    private static final Logger LOGGER = LoggerFactory.getLogger(TParkInfoClusterServiceImpl.class);
    @Autowired
    private QcsParkinglogMasterDao qcsParkinglogMasterDao; // 主数据源
    @Autowired
    private TParkInfoClusterDao tParkInfoClusterDao; // 第三方数据源

    /**
     * 更新停车场数据
     *
     * @return
     */
    @Override
    public int updateLatestTParkInfo() {
        //1.主数据源查询数据
        TParkInfoCluster data = new TParkInfoCluster();
        data.setStartDateStr(DateUtil.getCrrDayStart(0));
        data.setEndDateStr(DateUtil.getCrrDayEnd(0));
        List<TParkInfoCluster> list = qcsParkinglogMasterDao.findByLastest(data);
        LOGGER.info("TParkInfoClusterServiceImpl.String() : master获取数据 >> " + list);
        //2.更新第三方数据源
        int i =0;
        for(TParkInfoCluster temp: list){
            try {
                i = tParkInfoClusterDao.updateParkData(temp);
                LOGGER.info("ScheduleJobs.cronJob() : master获取最新数据 >> " + temp.getParkid() + " -- " + temp.getOccupiednumber());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return i;
    }
}
