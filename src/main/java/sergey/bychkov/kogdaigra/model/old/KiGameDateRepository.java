package sergey.bychkov.kogdaigra.model.old;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KiGameDateRepository extends JpaRepository<KiGameDate,Integer> {
    List<KiGameDate> findByGameId(Integer gameId);
    //@Query
    List<KiGameDate> findTop1ByGameId(Integer gameId);
}
