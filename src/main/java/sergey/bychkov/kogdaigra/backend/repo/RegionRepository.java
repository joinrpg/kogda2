/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.Region;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author serge
 */
public interface RegionRepository extends JpaRepository<Region, Long>, DictRepository<Region> {

    Optional<Region> findByName(String name);

    default Region saveIfNotExists(String name) {
        Optional<Region> result = findByName(name);
        return result.orElseGet(() -> save(new Region(name)));
    }
    public List<Region> findByParent(Region parent);
}
