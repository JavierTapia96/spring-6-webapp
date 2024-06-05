package ec.javiertap.courses.spring6webapp.services;

import ec.javiertap.courses.spring6webapp.domain.Author;
import ec.javiertap.courses.spring6webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Javier Tapia on 5/6/2024
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
