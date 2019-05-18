/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.backend;

import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergey.bychkov.kogdaigra.backend.repo.*;
import sergey.bychkov.kogdaigra.model.*;
import sergey.bychkov.kogdaigra.util.Util;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import sergey.bychkov.kogdaigra.model.old.User;
import sergey.bychkov.kogdaigra.ui.ByRegionView;
import sergey.bychkov.kogdaigra.ui.ByYearView;
import sergey.bychkov.kogdaigra.ui.MainLayout;
import sergey.bychkov.kogdaigra.ui.MainView;

/**
 * @author bychkov-sy
 *
 */
@Service
public class DataService implements IDataService {

    private static final Logger LOG = Logger.getLogger(DataService.class.getName());

    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private GameStatusRepository statusRepo;
    @Autowired
    private GameTypeRepository typeRepo;
    @Autowired
    private RegionRepository regionRepo;
    @Autowired
    private PolygonRepository polygonRepo;
    @Autowired
    private LinkTypeRepository linkTypeRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Converter converter;
    @Autowired
    private AuditRepository auditRepo;
    @Autowired
    private ProposalRepository proposalRepo;

    @PostConstruct
    public void init() {
        if (gameRepo.count() == 0) {
            converter.populate();
        }
       
    }

    @Override
    public List<Integer> getYears() {
        return gameRepo.getYears();
    }

    @Override
    public List<String> getMonthes(Integer year) {
        return gameRepo.getMonthes(year).stream().map(Util::getMonth).collect(Collectors.toList());

    }

    @Override
    public List<Game> getGames(Integer year) {
        return gameRepo.findByStartYear(year);
    }

    @Override
    public List<Game> getGames(Integer year, Integer month) {
        return gameRepo.findByStartYearAndMonth(year, month);
    }

    @Override
    public Game getGame(String game) {
        Game[] result = new Game[]{null};
        try {
            gameRepo.findById(Long.parseLong(game)).ifPresent((item) -> result[0] = item);
        } catch (NumberFormatException ex) {
            System.err.println("Wrong id " + game);
        }
        return result[0];
    }

    @Override
    public void saveGame(Game bean) {
        if (bean != null) {
            gameRepo.save(bean);
        }
    }

    @Override
    public List<GameStatus> getStatuses() {
        return statusRepo.findAll();
    }

    @Override
    public List<GameType> getTypes() {

        return typeRepo.findAll();
    }

    @Override
    public List<Region> getRegions() {
        return regionRepo.findAll();
    }

    @Override
    public List<Region> getRegions(Region parent) {
        return regionRepo.findByParent(parent);
    }

    @Override
    public List<Polygon> getPolygons() {
        return polygonRepo.findAll();
    }

    @Override
    public List<Polygon> getPolygons(Region region) {
        return polygonRepo.findByRegion(region);
    }

    @Override
    public List<LinkType> getLinkTypes() {
        return linkTypeRepo.findAll();
    }

    @Override
    public List<Audit> getChanged(Long timestamp) {
        return auditRepo.findByTimestampAfter(new Date(timestamp));
    }

    @Override
    public List<Game> getGamesNameLike(String name) {

        return gameRepo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public List<Game> getUnApproved() {
        return gameRepo.findUnApproved();
    }

    @Override
    public void saveProposal(Proposal newGame) {
        proposalRepo.save(newGame);
    }

    @Override
    public List<Proposal> getProposals() {
        return proposalRepo.findAll();
    }

    
}
