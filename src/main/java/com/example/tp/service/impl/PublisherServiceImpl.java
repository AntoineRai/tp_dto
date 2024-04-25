package com.example.tp.service.impl;

import com.example.tp.entity.Book;
import com.example.tp.entity.Publisher;
import com.example.tp.repository.BookRepository;
import com.example.tp.repository.PublisherRepository;
import com.example.tp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found with id " + id));
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher update(Long id, Publisher publisherDetails) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id " + id));
        publisher.setName(publisherDetails.getName());
        publisher.setBook(publisherDetails.getBook());
        return publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id " + id));
        if (publisher.getBook() != null) {
            Book book = bookRepository.findById(publisher.getBook().getId()).orElseThrow(()
                    -> new RuntimeException("Book not found with id " + publisher.getBook().getId()));
           book.setPublisher(null);
           bookRepository.save(book);
        }
        publisherRepository.delete(publisher);
    }
}
