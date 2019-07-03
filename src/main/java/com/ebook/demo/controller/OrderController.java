package com.ebook.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.util.Random;

import com.ebook.demo.base.order;
import com.ebook.demo.service.orderService;

@CrossOrigin(origins = {"http://localhost:8081","null"},allowCredentials = "true")
@RestController
@RequestMapping(value="/order",method = {RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class OrderController {
    @Autowired
    private orderService orderservice;

    @GetMapping(value = "/alllist")
    public List<order> getAllList(){
        return orderservice.findAll();
    }
    @GetMapping(value = "/list/{uid}")
    public List<order> getAllList(@PathVariable(value = "uid") String uid){
        return orderservice.findAll(uid);
    }
    @GetMapping(value = "/list/time/{uid}")
    public List<order> getOnePeriod(@PathVariable(value = "uid") String uid,@RequestParam(value = "time1") String t1,@RequestParam(value = "time2") String t2){
        Timestamp time1 = Timestamp.valueOf(t1);
        Timestamp time2 = Timestamp.valueOf(t2);
        return orderservice.findOneTime(time1,time2,uid);
    }
    @PostMapping(value = "/add/{uid}")
    public order addByOrder(@PathVariable(value = "uid") String uid,
                            @RequestParam(value = "price") double price){
        String id=getOrderIdByTime();
        Timestamp time= new Timestamp(System.currentTimeMillis());
        order o=new order(id,uid,price,"unpay",time);
        return orderservice.insertByOrder(o);
    }
    @PutMapping(value = "/update/{id}")
    public order update(@PathVariable(value = "id") String id,
                            @RequestParam(value = "state") String state){
        order o=orderservice.findById(id);
        o.setState(state);
        return orderservice.update(o);
    }
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result=result+random.nextInt(10);
        }
        return newDate+result;
    }
}
