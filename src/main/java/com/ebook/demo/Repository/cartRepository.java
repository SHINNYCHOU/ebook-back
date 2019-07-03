package com.ebook.demo.Repository;
import com.ebook.demo.base.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface cartRepository extends JpaRepository<cart,Integer>{
    List<cart> findByName(String name);
    cart findByNameAndBook(String name,String book);
    cart deleteByBookAndName(String book,String name);
}
