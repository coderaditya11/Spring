package com.example.demo.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.example.demo.models.Book;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Author(){}
    public Author(String name){
        this.name = name;
    }

    public void addBook(Book book){
        books.add(book);
        books.setAuthor(this);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

}
