package com.ebook.demo.Repository;
import com.ebook.demo.base.order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface orderRepository extends JpaRepository<order, String> {
    List<order> findByBuyerId(String uid);
    List<order> findByTimeAndBuyerId(Timestamp time,String uid);
    List<order> findByTimeBetweenAndBuyerId(Timestamp time1,Timestamp time2,String uid);
}
