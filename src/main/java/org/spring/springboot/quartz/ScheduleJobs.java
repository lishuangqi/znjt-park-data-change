package org.spring.springboot.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.QcsVDjygcMaster;
import org.spring.springboot.service.QcsVDjygcMasterService;
import org.spring.springboot.service.TParkInfoClusterService;
import org.spring.springboot.service.VDjygcClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by michael on 2017/8/8.
 */
@Component
public class ScheduleJobs {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleJobs.class);
    public final static long SECOND = 1 * 1000;
    DateFormat fdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private QcsVDjygcMasterService qcsVDjygcMasterService;
    @Autowired
    private VDjygcClusterService vDjygcClusterService;

    @Autowired
    private TParkInfoClusterService tParkInfoClusterService;

    @Scheduled(cron = "0/30 * 6-23 * * ? ")
    public void cronZnjtJob() {
        try {
            LOGGER.info("ScheduleJobs.cronZnjtJob() : start " );
            long maxClxxbh = qcsVDjygcMasterService.findByMaxClxxbh();
            System.out.println(maxClxxbh);
            LOGGER.info("ScheduleJobs.cronZnjtJob() : master获取最大序号 >> " + maxClxxbh);
            List<QcsVDjygcMaster> list = vDjygcClusterService.findByGreaterClxxbhForMaster(maxClxxbh);
            LOGGER.info("ScheduleJobs.cronZnjtJob() : master获取最大序号 >> " + list.size());
            for (QcsVDjygcMaster temp : list) {
                temp.setId(UUID.randomUUID().toString());
                try {
                    qcsVDjygcMasterService.insertSelective(temp);
                    LOGGER.info("ScheduleJobs.cronZnjtJob() : 插入master值 >> " + temp.getId() + " -- " + temp.getClxxbh());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[cronZnjtJob Execute success]" + fdf.format(new Date()));
        }catch (Exception e){
            LOGGER.error("ScheduleJobs.cronZnjtJob() :"+e.getMessage());
        }
    }

    @Scheduled(cron = "12 0/2 7-20 * * ?")
    public void cronParkJob() {
        try {
            LOGGER.info("ScheduleJobs.cronParkJob() : start " );
            tParkInfoClusterService.updateLatestTParkInfo();
        }catch (Exception e){
            LOGGER.error("ScheduleJobs.cronParkJob() :"+e.getMessage());
        }
    }
}