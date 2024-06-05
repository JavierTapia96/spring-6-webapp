package ec.javiertap.courses.spring6webapp.repositories;

import ec.javiertap.courses.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Javier Tapia on 4/6/2024
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
