package monge.persistence.repo;

import es.flaviojmend.hsservice.persistence.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by flaviojmendes on 30/01/17.
 */
public interface Repository extends CrudRepository<BaseEntity, String> {



}
