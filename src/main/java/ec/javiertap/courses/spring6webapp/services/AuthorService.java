package ec.javiertap.courses.spring6webapp.services;

import ec.javiertap.courses.spring6webapp.domain.Author;

/**
 * Created by Javier Tapia on 5/6/2024
 */
public interface AuthorService {

    Iterable<Author> findAll();
}
