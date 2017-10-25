package org.spring.springboot.controller;

import org.spring.springboot.domain.QcsVDjygcMaster;
import org.spring.springboot.domain.User;
import org.spring.springboot.domain.VDjygcCluster;
import org.spring.springboot.service.QcsVDjygcMasterService;
import org.spring.springboot.service.UserService;
import org.spring.springboot.service.VDjygcClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private QcsVDjygcMasterService qcsVDjygcMasterService;
    @Autowired
    private VDjygcClusterService vDjygcClusterService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }


    @RequestMapping(value = "/api/qcsvdjygc", method = RequestMethod.GET)
    public long findByMaxClxxbh() {
        return qcsVDjygcMasterService.findByMaxClxxbh();
    }

    @RequestMapping(value = "/api/vdjygc", method = RequestMethod.GET)
    public long findByMaxClxxbh1() {
        return vDjygcClusterService.findByMaxClxxbh();
    }

    @RequestMapping(value = "/api/qcsvdjygcL", method = RequestMethod.GET)
    public List<QcsVDjygcMaster> findByMaxClxxbh(@RequestParam(value = "clxxbh", required = true) Long clxxbh) {
        return qcsVDjygcMasterService.findByGreaterClxxbh(clxxbh);
    }

    @RequestMapping(value = "/api/vdjygcL", method = RequestMethod.GET)
    public List<QcsVDjygcMaster> findByMaxClxxbh1(@RequestParam(value = "clxxbh", required = true) Long clxxbh) {
        return vDjygcClusterService.findByGreaterClxxbhForMaster(clxxbh);
    }

}
