package com.ebook.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.ebook.demo.base.order_items;
import com.ebook.demo.service.order_itemService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = {"http://localhost:8081","null"},allowCredentials = "true")
@RestController
@RequestMapping(value="/orderDetail",method = {RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class Order_itemController {
    @Autowired
    private order_itemService order_itemService;

    private <T> List<T> getList(String lists,Integer spec)
    {
        // if (lists.length()==0)
        List<T> sth = new ArrayList<>();
        for (int i=0;i<lists.length();i++)
        {
            StringBuilder sb = new StringBuilder();
            while (i<lists.length()&&lists.charAt(i)!=',')
            {
                sb.append(lists.charAt(i));
                i++;
            }
            switch (spec)
            {
                case 1: sth.add((T)Integer.valueOf(sb.toString()));break;
                case 2: sth.add((T)sb.toString());break;
                case 3: sth.add((T)Double.valueOf(sb.toString()));break;
                default:
                    break;
            }
            sb.delete(0,sb.length()-1);
        }
        return sth;
    }
    @GetMapping(value = "/{oid}")
    public List<order_items> findOneOrder(@PathVariable(value = "oid" ) String oid){
        System.out.println(oid);
        //System.out.println(order_itemService.findByOrder(oid).size());
        return order_itemService.findByOrder(oid);
    }
    @GetMapping(value = "/all")
    public List<order_items> findAll(){
        //System.out.println(order_itemService.findByOrder(oid).size());
        return order_itemService.findAll();
    }
    @PostMapping(value = "/insert/{oid}")
    public order_items insertOrder(@PathVariable(value = "oid" ) String oid,
                            @RequestParam(value = "book_isbn") String book,
                            @RequestParam(value = "price") double price,
                            @RequestParam(value = "number") int number){
        System.out.println(book);
        System.out.println(price);
        //String id=oid+book;
        //System.out.println(id);
        order_items o=new order_items(oid,book,price,number);
        System.out.println(o);
        /*o.setBook_isbn(book);
        o.setNumber(number);
        o.setPrice(price);
        o.setOrderId(oid);*/
        return order_itemService.insert(o);
    }
    @PostMapping(value = "/insertList/{oid}")
    public int insertOrder(@PathVariable(value = "oid" ) String oid,
                            @RequestParam(value = "book_isbn") String bookList,
                            @RequestParam(value = "priceList") String priceList,
                            @RequestParam(value = "numberList") String numberList){
        List<String> books=getList(bookList,2);
        List<Double> prices=getList(priceList,3);
        List<Integer> numbers=getList(numberList,1);
        List<order_items> insertList=new ArrayList<>();
        for(int i = 0;i<books.size();i++){
            order_items orderitem=new order_items(oid,books.get(i),prices.get(i),numbers.get(i));
            insertList.add(orderitem);
            order_itemService.insert(orderitem);
        }
        //order_itemService.insert(insertList);
        return insertList.size();
    }
    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
//         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        return  machineId+ String.format("%015d", hashCodeV);
    }
}
