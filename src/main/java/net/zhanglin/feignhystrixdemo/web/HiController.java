package net.zhanglin.feignhystrixdemo.web;

import net.zhanglin.feignhystrixdemo.clients.SchedualServiceHi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {
	private Logger logger = LoggerFactory.getLogger(HiController.class);

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
    	logger.info("Calling service - feignhystrixdemo-provider");
        return schedualServiceHi.sayHiFromClientOne( name ) + "[Triggered in "+System.getenv("ENVIRONMENT_NAME_KEY")+"]";
    }
}