package com.bookstore.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.services.BookService;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping
	public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
	}
	
	public ResponseEntity<List<BookModel>> getAllBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
	}

}
