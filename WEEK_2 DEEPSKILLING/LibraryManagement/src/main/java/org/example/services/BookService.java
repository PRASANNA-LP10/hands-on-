package org.example.services;

import org.example.repository.BookRepository;

public class BookService {
    private BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

//    public void setRepo(BookRepository repo){
//        this.repo=repo;
//    }

    public BookRepository getRepo() {
        return repo;
    }
}
