package com.example.tp.service;

import com.example.tp.entity.Book;

public interface BookService extends CrudService<Book, Long>{

    void test(String genreName);


}
