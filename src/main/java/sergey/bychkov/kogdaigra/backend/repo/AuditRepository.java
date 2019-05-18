package sergey.bychkov.kogdaigra.backend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.Audit;

import java.util.Date;
import java.util.List;

public interface AuditRepository extends JpaRepository<Audit,Long> {
    List<Audit> findByTimestampAfter(Date date);
}
