/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import sergey.bychkov.kogdaigra.model.AuditType;

/**
 *
 * @author serge
 */
public interface AuditTypeRepository extends CrudRepository<AuditType, Long> {

    Optional<AuditType> findByName(String name);

    default AuditType saveIfNotExists(String name) {
        Optional<AuditType> result = findByName(name);
        return result.orElseGet(() -> save(new AuditType(name)));
    }
}
