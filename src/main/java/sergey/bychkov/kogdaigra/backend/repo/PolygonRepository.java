/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.Polygon;
import sergey.bychkov.kogdaigra.model.Region;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author 16715817
 */
public interface PolygonRepository extends JpaRepository<Polygon, Long>, DictRepository<Polygon> {

    Optional<Polygon> findByName(String name);

    List<Polygon> findByRegion(Region region);
    List<Polygon> findByRegionIn(Region region);


    default Polygon saveIfNotExists(String name) {
        Optional<Polygon> result = findByName(name);
        return result.orElseGet(() -> save(new Polygon(name)));
    }
}
