/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.GameStatus;

import java.util.Optional;

/**
 *
 * @author serge
 */
public interface GameStatusRepository extends JpaRepository<GameStatus, Long>, DictRepository<GameStatus> {

    Optional<GameStatus> findByName(String name);

    default GameStatus saveIfNotExists(String name) {
        Optional<GameStatus> result = findByName(name);
        return result.orElseGet(() -> save(new GameStatus(name)));
    }
}
