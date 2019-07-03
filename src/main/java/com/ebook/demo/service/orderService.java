package com.ebook.demo.service;
import com.ebook.demo.base.order;
import com.ebook.demo.Repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class orderService implements orderServieInter{
    @Autowired
    private orderRepository orderrepo;
    public List<order> findAll(){
        return orderrepo.findAll();
    }
    public order findById(String id){return orderrepo.getOne(id);}
    public List<order> findAll(String uid){
        return orderrepo.findByBuyerId(uid);
    }
    public List<order> findOneTime(Timestamp time1,Timestamp time2,String uid){
        // return orderrepo.findByTimeAndBuyerId(time,uid);
        return orderrepo.findByTimeBetweenAndBuyerId(time1,time2,uid);
    }
    public order insertByOrder(order order){
        return orderrepo.save(order);
    }
    public order update(order order){
        return orderrepo.save(order);
    }
    public void delete(String id){
        orderrepo.deleteById(id);
    }
}