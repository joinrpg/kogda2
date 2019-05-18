/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.Link;

/**
 *
 * @author bychkov-sy
 */
public interface LinkRepository extends JpaRepository<Link, Long>, DictRepository<Link> {

}
