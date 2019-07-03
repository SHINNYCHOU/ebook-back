package com.ebook.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ebook.demo.Repository.order_itemRepository;
import com.ebook.demo.base.order_items;
@Service
public class order_itemService implements order_itemServiceInter{
    @Autowired
    private order_itemRepository order_itemRepository;
    public List<order_items> findByOrder(String orderid){
        //System.out.println(order_itemRepository.findByOrderId(orderid));
        return order_itemRepository.findByOrderId(orderid);
    }
    public List<order_items> findAll(){
        return order_itemRepository.findAll();
    }
    public order_items insert(order_items order_item){
        System.out.println(order_item);
        order_itemRepository.save(order_item);
        return order_item;
    }
}
