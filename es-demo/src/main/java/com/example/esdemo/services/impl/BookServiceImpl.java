package com.example.esdemo.services.impl;

import com.example.esdemo.model.Book;
import com.example.esdemo.repository.BookRepository;
import com.example.esdemo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * created by yanming on 2018/8/9
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findOne(String id) {
        if ( bookRepository.findById(id).isPresent() )
            return bookRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findByTitleMatches(String title, PageRequest pageRequest) {
        return bookRepository.findByTitleMatches(title, pageRequest);
    }

    @Override
    public Page<Book> findByTitle(String title, PageRequest pageRequest) {
        return bookRepository.findByTitle(title, pageRequest);
    }
}
