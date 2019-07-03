package com.ebook.demo.service;
import java.util.List;

import com.ebook.demo.base.book_info;
public interface bookService {
    /**
     * 获取所有 Book
     */
    List<book_info> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link book_info}
     */
    book_info insertByBook(book_info book);

    /**
     * 更新 Book
     *
     * @param book {@link book_info}
     */
    book_info update(book_info book);

    /**
     * 删除 Book
     *
     * @param isbn 编号
     */
    void delete(String isbn);

    /**
     * 获取 Book
     *
     * @param isbn 编号
     */
    book_info findByIsbn(String isbn);
}
