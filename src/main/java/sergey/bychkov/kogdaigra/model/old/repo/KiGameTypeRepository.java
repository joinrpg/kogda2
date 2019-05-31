/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.old.KiGameType;

/**
 *
 * @author serge
 */
public interface KiGameTypeRepository extends JpaRepository<KiGameType, Integer> {
    
}
