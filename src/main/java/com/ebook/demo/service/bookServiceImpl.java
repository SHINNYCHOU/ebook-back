package com.ebook.demo.service;

import com.ebook.demo.base.book_info;
import com.ebook.demo.Repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class bookServiceImpl implements bookService{
    @Autowired
    private bookRepository bookDao;

    @Override
    public List<book_info> findAll() {
        return bookDao.findAll();
    }

    @Override
    public book_info insertByBook(book_info book) {
        bookDao.save(book);
        return book;
    }

    @Override
    public book_info update(book_info book) {
        bookDao.save(book);
        return book;
    }

   @Override
    public void delete(String isbn) {
        System.out.println("ser:");
        System.out.println(isbn);
        bookDao.deleteById(isbn);
    }

    @Override
    public book_info findByIsbn(String id) {
        return bookDao.getOne(id);
    }


}
