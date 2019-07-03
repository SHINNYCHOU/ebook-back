package com.ebook.demo.Repository;

import java.util.List;
import com.ebook.demo.base.bookcomment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface commentRepository extends MongoRepository<bookcomment,String> {
    bookcomment findByIsbn(String id);
    bookcomment deleteByIsbn(String isbn);
}
