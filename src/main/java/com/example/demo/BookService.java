package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BookService {
	
	
	@Autowired
	private BookRepository repository;
	
	
	public Book addBook(Book book) {
		return repository.save(book);
	}
	
	public List<Book> getAllBooks(){
		return repository.findAll();
	}
public Book updateBook(Long id, Book book) {
Book b=repository.findById(id).orElseThrow();

b.setTitle(book.getTitle());
b.setAuthor(book.getAuthor());
b.setPrice(book.getPrice());
return repository.save(b);
}
public void deleteBook(Long id) {
	repository.deleteById(id);
}
}
