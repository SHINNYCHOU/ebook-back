package com.ebook.demo.Repository;
import com.ebook.demo.base.order_items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface order_itemRepository extends JpaRepository<order_items,Integer>{
    List<order_items> findByOrderId(String orderid);
}
