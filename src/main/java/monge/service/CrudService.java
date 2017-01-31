package monge.service;

import es.flaviojmend.hsservice.persistence.entity.BaseEntity;
import es.flaviojmend.hsservice.persistence.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flaviojmendes on 30/01/17.
 */

@Service
public class CrudService<T extends BaseEntity> {

    @Autowired
    Repository repository;

    public void update(T entity) throws Exception {
        repository.save(entity);
    }

    public void add(T entity) {
        repository.save(entity);
    }

    public Iterable list(){
        return repository.findAll();
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

}
