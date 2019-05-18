/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.Comment;

/**
 *
 * @author bychkov-sy
 */
public interface CommentRepository extends JpaRepository<Comment, Long>, DictRepository<Comment> {

}
