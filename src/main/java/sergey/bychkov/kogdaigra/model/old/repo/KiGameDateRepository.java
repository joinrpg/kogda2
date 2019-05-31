package sergey.bychkov.kogdaigra.model.old.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.old.KiGameDate;

import java.util.List;

public interface KiGameDateRepository extends JpaRepository<KiGameDate,Integer> {
    List<KiGameDate> findByGameId(Integer gameId);
    //@Query
    List<KiGameDate> findTop1ByGameId(Integer gameId);
}
