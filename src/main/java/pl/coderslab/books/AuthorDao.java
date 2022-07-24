package pl.coderslab.books;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Author> findAll() {
        return entityManager.createQuery("select b from Author b")
                .getResultList();
    }

    public void save(Author author) {
        entityManager.persist(author);
    }


    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }


    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
}