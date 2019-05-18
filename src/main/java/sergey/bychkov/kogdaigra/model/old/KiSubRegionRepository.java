/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author serge
 */
public interface KiSubRegionRepository extends JpaRepository<KiSubRegion, Integer> {
   List<KiSubRegion> findByRegionId(Integer regionId);
    
}
