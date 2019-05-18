/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.GameType;

import java.util.Optional;

/**
 *
 * @author serge
 */
public interface GameTypeRepository extends JpaRepository<GameType, Long>, DictRepository<GameType> {

    Optional<GameType> findByName(String name);

    default GameType saveIfNotExists(String name) {
        Optional<GameType> result = findByName(name);
        return result.orElseGet(() -> save(new GameType(name)));
    }
}
