package com.epharma.blogservice.intercomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("log-service")
public interface LogClient{

    @RequestMapping(value="/service/popular",consumes = "application/json", method=RequestMethod.GET)
    List<Long> getPopularArticles();
    
}