package ec.javiertap.courses.spring6webapp.services;

import ec.javiertap.courses.spring6webapp.domain.Book;

/**
 * Created by Javier Tapia on 5/6/2024
 */
public interface BookService {

    Iterable<Book> findAll();
}
