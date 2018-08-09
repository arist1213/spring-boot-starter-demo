package com.example.esdemo.repository;

import com.example.esdemo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * created by yanming on 2018/8/9
 */
@Component
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByTitle(String title, Pageable pageable);
    Page<Book> findByTitleMatches(String title, Pageable pageable);

}
