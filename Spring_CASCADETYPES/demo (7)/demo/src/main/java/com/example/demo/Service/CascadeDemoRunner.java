package com.example.demo.Service;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.Repositories.AuthorRepository;
import com.example.demo.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CascadeDemoRunner implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public CascadeDemoRunner(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Cascade Test Start ===");

        // Create Author and Books
        Author author = new Author("J.K. Rowling");
        Book b1 = new Book("Harry Potter 1");
        Book b2 = new Book("Harry Potter 2");

        author.addBook(b1);
        author.addBook(b2);

        // Save Author only
        authorRepo.save(author);  // cascade will decide if books are saved too


