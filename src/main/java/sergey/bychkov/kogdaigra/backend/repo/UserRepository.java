/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.old.User;

/**
 *
 * @author 16715817
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);
    
}
