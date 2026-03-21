package com.klu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Book;

@RestController
public class LibraryController {
	 List<Book> bookList = new ArrayList<>();

	    // 2. Welcome message
	    @GetMapping("/welcome")
	    public String welcome() {
	        return "Welcome to Online Library System";
	    }

	    // 3. Total books count
	    @GetMapping("/count")
	    public int count() {
	        return 10;
	    }

	    // 4. Sample book price
	    @GetMapping("/price")
	    public double price() {
	        return 499.99;
	    }

	    // 5. List of book titles
	    @GetMapping("/books")
	    public List<String> getBooks() {
	        return Arrays.asList("Java Programming", "Spring Boot Guide", "Data Structures");
	    }

	    // 6. Book details using PathVariable
	    @GetMapping("/books/{id}")
	    public String getBookById(@PathVariable int id) {
	        return "Book details for ID: " + id;
	    }

	    // 7. Search book using request parameter
	    @GetMapping("/search")
	    public String searchBook(@RequestParam String title) {
	        return "Searching for book titled: " + title;
	    }

	    // 8. Author name using PathVariable
	    @GetMapping("/author/{name}")
	    public String getAuthor(@PathVariable String name) {
	        return "Books written by author: " + name;
	    }

	    // 9. Add book using POST
	    @PostMapping("/addbook")
	    public String addBook(@RequestBody Book book) {
	        bookList.add(book);
	        return "Book added successfully";
	    }

	    // 10. View all added books
	    @GetMapping("/viewbooks")
	    public List<Book> viewBooks() {
	        return bookList;
	    }

}
