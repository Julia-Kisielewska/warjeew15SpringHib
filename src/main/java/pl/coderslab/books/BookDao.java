package pl.coderslab.books;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating=:score")
                .setParameter("score", rating)
                .getResultList();
    }

    public List<Book> findWithAnyPublisher() {
        return entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher").
                getResultList();
    }

    public List<Book> findByPublisher(String publisher) {
        return entityManager
                .createQuery("select b from Book b where b.publisher.name=:publisher")
                .setParameter("publisher", publisher)
                .getResultList();
    }

    public List<Book> findBooksWithAuthors(Author author){
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors " +
                        "WHERE :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

}
