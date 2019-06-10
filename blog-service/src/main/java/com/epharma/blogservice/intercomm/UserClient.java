package com.epharma.blogservice.intercomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("user-service")
public interface UserClient{


    public static final String APPLICATION_JSON = "application/json";

    @RequestMapping(value = "/service/names", method = RequestMethod.POST, consumes = APPLICATION_JSON)
    List<String> getUsers(@RequestBody List<Long> userIdList);
    
    @RequestMapping(value = "/service/userdetails/{name}", method = RequestMethod.GET, consumes = APPLICATION_JSON)
    ResponseEntity<?> getDetails(@PathVariable String name);
    
    @RequestMapping(value = "/service/hello/{name}", method = RequestMethod.GET, consumes = APPLICATION_JSON)
    String getUserHello(@PathVariable String name);
    
}