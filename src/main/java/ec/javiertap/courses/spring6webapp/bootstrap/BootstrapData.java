package ec.javiertap.courses.spring6webapp.bootstrap;

import ec.javiertap.courses.spring6webapp.domain.Author;
import ec.javiertap.courses.spring6webapp.domain.Book;
import ec.javiertap.courses.spring6webapp.domain.Publisher;
import ec.javiertap.courses.spring6webapp.repositories.AuthorRepository;
import ec.javiertap.courses.spring6webapp.repositories.BookRepository;
import ec.javiertap.courses.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Javier Tapia on 4/6/2024
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author ericSaved = authorRepository.save(eric);

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123123");

        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Author rodSaved = authorRepository.save(rod);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("123124");

        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher sfg = new Publisher();
        sfg.setPublisherName("SFG Publishing");
        sfg.setAddress("1234 Street");
        sfg.setCity("St Petersburg");
        sfg.setState("FL");
        sfg.setZip("33701");

        Publisher sfgSaved = publisherRepository.save(sfg);

        dddSaved.setPublisher(sfgSaved);
        noEJBSaved.setPublisher(sfgSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
