package pl.coderslab.dwarfs;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DwarfDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Dwarf dwarf){
        entityManager.persist(dwarf);
    }

    public Dwarf findById(Long id){
        return entityManager.find(Dwarf.class, id);
    }

    public void update(Dwarf dwarf){
        entityManager.merge(dwarf);
    }

    public void delete(Dwarf dwarf) {
        entityManager.remove(entityManager.contains(dwarf) ?
                dwarf : entityManager.merge(dwarf)); }
}