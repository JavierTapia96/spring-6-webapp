package ec.javiertap.courses.spring6webapp.services;

import ec.javiertap.courses.spring6webapp.domain.Book;
import ec.javiertap.courses.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Javier Tapia on 5/6/2024
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
