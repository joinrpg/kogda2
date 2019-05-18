/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend;

import sergey.bychkov.kogdaigra.model.*;

import java.io.Serializable;
import java.util.List;
import sergey.bychkov.kogdaigra.model.old.User;

/**
 *
 * @author serge
 */
public interface IDataService extends Serializable {

    Game getGame(String game);

    List<Game> getGames(Integer year);

    List<Game> getGames(Integer year, Integer month);

    List<Game> getGamesNameLike(String name);

    List<Game> getUnApproved();

    List<String> getMonthes(Integer year);

    List<Integer> getYears();

    void saveGame(Game bean);

    List<Polygon> getPolygons();

    List<Polygon> getPolygons(Region region);

    List<Region> getRegions();

    List<Region> getRegions(Region parent);

    List<GameStatus> getStatuses();

    List<GameType> getTypes();

    List<LinkType> getLinkTypes();

    List<Audit> getChanged(Long timestamp);

    List<User> getUserByEmail(String email);

    User updateUser(User user);

    public void saveProposal(Proposal newGame);

    public List<Proposal> getProposals();
}
