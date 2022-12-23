package ro.digitalnation.bookslibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.bookslibrary.model.Book;
import ro.digitalnation.bookslibrary.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).get();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(int id, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
