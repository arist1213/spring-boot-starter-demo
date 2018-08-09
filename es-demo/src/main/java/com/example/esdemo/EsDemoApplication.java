package com.example.esdemo;

import com.example.esdemo.model.Book;
import com.example.esdemo.services.BookService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;

@SpringBootApplication
public class EsDemoApplication implements CommandLineRunner {
	@Autowired
	ElasticsearchOperations es;

	@Autowired
	BookService bookService;


	public static void main(String[] args) {
		SpringApplication.run(EsDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Test Elasticsearch");

		printElasticSearchInfo();

		bookService.save(new Book("1001", "Spring Boot1.0的书籍", "Rambabu Posa", "23-FEB-2017"));
		bookService.save(new Book("1002", "Elastic Search1.0的书籍", "Rambabu Posa", "23-FEB-2017"));
		bookService.save(new Book("1003", "Elastic Search Plugin 1.0的书籍", "Rambabu Posa", "23-FEB-2017"));
		bookService.save(new Book("1004", "PHP7.0", "Rambabu Posa", "23-FEB-2017"));

		Page<Book> books = bookService.findByTitleMatches("书", new PageRequest(0, 2));

		books.forEach(x -> System.out.println(x));

	}

	//useful for debug
	private void printElasticSearchInfo() {

		System.out.println("--ElasticSearch-->");
		Client client = es.getClient();
		Map<String, String> asMap = client.settings().getAsMap();
		asMap.forEach((k, v) -> {
			System.out.println(k + " = " + v);
		});
		System.out.println("<--ElasticSearch--");
	}

}
