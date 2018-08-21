package com.sleuth.sleuthclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/rest")
public class Controller {

    public static Logger LOG = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/client")
    public String hello(){

        LOG.info("Before calling server");
        String respose = restTemplate.getForObject("http://localhost:8081/rest/server", String.class);
        LOG.info("After calling server");

        return respose;
    }
}
