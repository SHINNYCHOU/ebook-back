package com.ebook.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.ebook.demo.base.cart;
import com.ebook.demo.Repository.cartRepository;

@Service
@Transactional
public class cartService implements cartServiceInter{
    @Autowired
    private cartRepository cartRepository;
    public cart findByNameAndBook(String name,String book){return cartRepository.findByNameAndBook(name,book);}
    public List<cart> findByName(String name){return cartRepository.findByName(name);}
    public cart insert(cart cart){return cartRepository.save(cart);}
    @Modifying
    public cart delete(String name,String book){
       cart cart=cartRepository.findByNameAndBook(name,book);
        int id=cart.getId();
       cartRepository.deleteById(id);
       return cart;
    }

}
