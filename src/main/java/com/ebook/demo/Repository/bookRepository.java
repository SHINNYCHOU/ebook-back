package com.ebook.demo.Repository;

import com.ebook.demo.base.book_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<book_info, String>{

    //List<book_info> findAll();

    /*增加*/
    //book_info insertByBook(book_info book);

   // book_info update(book_info book);

    //void delete(String isbn);
    //book_info findByIsbn(String isbn);

}
