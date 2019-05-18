package sergey.bychkov.kogdaigra.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sergey.bychkov.kogdaigra.model.Audit;
import sergey.bychkov.kogdaigra.model.Game;

import java.util.List;

@Controller
public class Api {

    @Autowired
    private IDataService data;

    @RequestMapping(value = "/api/game/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Game game(@PathVariable("id") String id) {
        return data.getGame(id);

    }

    @RequestMapping(value = "/api/allrpg-info/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AllRpgDTO allrpg(@PathVariable("id") String id) {
        Game game = data.getGame(id);
        return new AllRpgDTO(game.getId().toString(), game.getAllRpgId().toString(), "/game/" + game.getId());

    }

    @RequestMapping(value = "/api/changed/{timestamp}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Audit> changed(@PathVariable("timestamp") Long timestamp) {
        return data.getChanged(timestamp);

    }

    class AllRpgDTO {
        String id;
        String allrpg_info_id;
        String profile_uri;

        public AllRpgDTO(String id, String allrpg_info_id, String profile_uri) {
            this.id = id;
            this.allrpg_info_id = allrpg_info_id;
            this.profile_uri = profile_uri;
        }
    }
}
