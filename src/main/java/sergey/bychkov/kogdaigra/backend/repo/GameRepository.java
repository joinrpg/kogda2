/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sergey.bychkov.kogdaigra.model.Game;

import java.util.List;

/**
 *
 * @author serge
 */
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = "select distinct year(g.start) from Game g")
    public List<Integer> getYears();

    @Query(value = "select distinct month(g.start) from Game g where year(g.start) = :year")
    public List<Integer> getMonthes(@Param("year") Integer year);

    @Query(value = "select g from Game g where year(g.start) = :year order by g.start")
    public List<Game> findByStartYearAll(@Param("year") Integer year);

    @Query(value = "select g from Game g where year(g.start) = :year and month(g.start) = :month order by g.start")
    public List<Game> findByStartYearAndMonthAll(@Param("year") Integer year, @Param("month") Integer month);

    @Query(value = "select g from Game g where year(g.start) = :year and g.deleted = 0 order by g.start")
    public List<Game> findByStartYear(@Param("year") Integer year);

    @Query(value = "select g from Game g where year(g.start) = :year and month(g.start) = :month and g.deleted = 0 order by g.start")
    public List<Game> findByStartYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);

    public List<Game> findByNameContainingIgnoreCase(String name);

    @Query(value = "select g from Game g where approved = 0")
    public List<Game> findUnApproved();

}
