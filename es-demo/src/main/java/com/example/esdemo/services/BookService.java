package com.example.esdemo.services;

import com.example.esdemo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * created by yanming on 2018/8/9
 */
public interface BookService {

    Book save(Book book);
    void delete(Book book);
    Book findOne(String id);
    Iterable<Book> findAll();
    Page<Book> findByTitleMatches(String title, PageRequest pageRequest);
    Page<Book> findByTitle(String title, PageRequest pageRequest);

}
