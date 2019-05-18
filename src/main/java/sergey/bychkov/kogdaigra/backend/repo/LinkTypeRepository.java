/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.LinkType;

import java.util.Optional;

/**
 *
 * @author bychkov-sy
 */
public interface LinkTypeRepository extends JpaRepository<LinkType, Long>,DictRepository<LinkType>{
 Optional<LinkType> findByName(String name);

    default LinkType saveIfNotExists(String name) {
        Optional<LinkType> result = findByName(name);
        return result.orElseGet(() -> save(new LinkType(name)));
    }   
}
