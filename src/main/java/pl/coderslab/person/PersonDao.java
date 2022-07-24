package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.books.Author;
import pl.coderslab.dwarfs.Dwarf;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        Query query = entityManager.createQuery("select p from Person p");
        List resultList = query.getResultList();
        return resultList;
    }

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

}
