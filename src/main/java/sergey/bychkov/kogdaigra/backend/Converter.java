package sergey.bychkov.kogdaigra.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sergey.bychkov.kogdaigra.backend.repo.*;
import sergey.bychkov.kogdaigra.model.*;
import sergey.bychkov.kogdaigra.model.old.*;
import sergey.bychkov.kogdaigra.model.old.repo.*;
import sergey.bychkov.kogdaigra.util.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Component
public class Converter {

    private static final Logger LOG = Logger.getLogger(Converter.class.getName());

    @Autowired
    private GameRepository         gameRepo;
    @Autowired
    private GameStatusRepository   statusRepo;
    @Autowired
    private GameTypeRepository     typeRepo;
    @Autowired
    private RegionRepository       regionRepo;
    @Autowired
    private PolygonRepository      polygonRepo;
    @Autowired
    private LinkTypeRepository     linkTypeRepo;
    @Autowired
    private LinkRepository         linkRepo;
    @Autowired
    private ProposalRepository     proposalRepo;
    @Autowired
    private AuditRepository        auditRepo;
    @Autowired
    private AuditTypeRepository    auditTypeRepo;
    ///////////// KI - old db
    @Autowired
    private KiGameTypeRepository   kiTypeRepo;
    @Autowired
    private KiStatusRepository     kiStatusRepo;
    @Autowired
    private KiSubRegionRepository  kiSubRegionRepo;
    @Autowired
    private KiRegionRepository     kiRegionRepo;
    @Autowired
    private KiPolygonRepository    kiPolygonRepo;
    @Autowired
    private KiGameRepository       kiGameRepo;
    @Autowired
    private KiGameDateRepository   kiGameDateRepo;
    @Autowired
    private KiPhotoRepository      kiPhotoRepo;
    @Autowired
    private KiReviewRepository     kiReviewRepo;
    @Autowired
    private KiAddUriRepository     kiAddUriRepo;
    @Autowired
    private KiUpdateRepository     kiUpdateRepo;
    @Autowired
    private KiUpdateTypeRepository kiUpdateTypeRepo;
    /////////////

    public void populate() {

        LinkType linkTypeVk = linkTypeRepo.saveIfNotExists("VK");
        LinkType linkTypeFB = linkTypeRepo.saveIfNotExists("FaceBook");
        LinkType linkTypeLJ = linkTypeRepo.saveIfNotExists("LJ");
        LinkType linkTypeMail = linkTypeRepo.saveIfNotExists("e-mail");
        LinkType linkTypeUrl = linkTypeRepo.saveIfNotExists("url");
        //LinkType linkTypePhoto=linkTypeRepo.saveIfNotExists("photo");

        LOG.info("preload data");
        // cache data
        HashMap<Integer, GameStatus> oldStatus = new HashMap<>();
        HashMap<Integer, GameType> oldType = new HashMap<>();
        HashMap<Integer, Region> oldRegion = new HashMap<>();
        HashMap<Integer, Polygon> oldPolygon = new HashMap<>();
        //
        LOG.info("Old types " + kiTypeRepo.count());
        kiTypeRepo.findAll().forEach(type -> oldType.put(type.getGameTypeId(), typeRepo.saveIfNotExists(type.getGameTypeName().trim())));
        LOG.info("Old statuses " + kiStatusRepo.count());
        kiStatusRepo.findAll().forEach(status -> {
            GameStatus gameStatus = statusRepo.saveIfNotExists(status.getStatusName().trim());
            gameStatus.setStyle(status.getStatusStyle());
            statusRepo.save(gameStatus);
            oldStatus.put(status.getStatusId(), statusRepo.saveIfNotExists(status.getStatusName().trim()));
        });
        LOG.info("Old regions processing " + kiSubRegionRepo.count());
        kiRegionRepo.findAll().forEach(region -> {
            Region reg = regionRepo.saveIfNotExists(region.getRegionName());
            kiSubRegionRepo.findByRegionId(region.getRegionId()).forEach(subRegion -> {
                Region subReg = regionRepo.saveIfNotExists(subRegion.getSubRegionName());
                subReg.setParent(reg);
                subReg.setShortName(subRegion.getSubRegionDispName());
                oldRegion.put(subRegion.getSubRegionId(), regionRepo.save(subReg));
            });
            reg.setShortName(region.getRegionCode());
            regionRepo.save(reg);
        });
        LOG.info("Old polygons processing " + kiPolygonRepo.count());
        kiPolygonRepo.findAll().forEach(polygon -> {
            Polygon pol = polygonRepo.saveIfNotExists(polygon.getPolygonName());
            kiSubRegionRepo.findById(polygon.getSubRegionId()).ifPresent(reg -> regionRepo.findByName(reg.getSubRegionName()).ifPresent(pol::setRegion));
            oldPolygon.put(polygon.getPolygonId(), polygonRepo.save(pol));
        });
        LOG.info("Old games processing " + kiGameRepo.count());
        kiGameRepo.findAll().forEach(kiGame -> {
            List<KiGameDate> gameDateList = kiGameDateRepo.findTop1ByGameId(kiGame.getId());
                        Date start = new Date();
            Date end = new Date();
            if (gameDateList.size() > 0) {
                start = gameDateList.get(0).getBegin();
                end = endDate(start, gameDateList.get(0).getTime());
            }
            Game game = new Game(kiGame.getId().longValue(),
                    kiGame.getName(),
                    oldStatus.get(kiGame.getStatus()),
                    oldRegion.get(kiGame.getSubRegionId()),
                    start,
                    end,
                    oldType.get(kiGame.getType()),
                    oldPolygon.get(kiGame.getPolygon()),
                    kiGame.getPlayersCount(),
                    kiGame.getMg());
            game.setAllRpgId(kiGame.getAllrpgInfoId() == null ? null : kiGame.getAllrpgInfoId().longValue());
            game.setEmail(kiGame.getEmail());
            game.setDeleted(kiGame.getDeletedFlag() > 0);
            if (kiGame.getFbComm() != null && !kiGame.getFbComm().isEmpty()) {
                game.addLink(linkRepo.save(new Link(kiGame.getFbComm(), linkTypeFB)));
            }
            ;
            if (kiGame.getLjComm() != null && !kiGame.getLjComm().isEmpty()) {
                game.addLink(linkRepo.save(new Link(kiGame.getLjComm(), linkTypeLJ)));
            }
            ;
            if (kiGame.getVkClub() != null && !kiGame.getVkClub().isEmpty()) {
                game.addLink(linkRepo.save(new Link(kiGame.getVkClub(), linkTypeVk)));
            }
            ;
            if (kiGame.getUri() != null && !kiGame.getUri().isEmpty()) {
                game.addLink(linkRepo.save(new Link(kiGame.getUri(), linkTypeUrl)));
            }
            ;
            if (kiGame.getComment() != null && !kiGame.getComment().isEmpty()) {
                game.addComment(kiGame.getComment());
            }
            ;
            game.setApproved(true);
            gameRepo.save(game);
            //LOG.info(game.toString());

        });
        LOG.info("Old games advertisment processing " + kiAddUriRepo.count());
        kiAddUriRepo.findAll().forEach(addv -> {
            proposalRepo.save(new Proposal(addv.getUri(), addv.getAllrpgInfoId(), addv.isResolved()));
        });
        LOG.info("Old update types processing " + kiUpdateTypeRepo.count());
        kiUpdateTypeRepo.findAll().forEach(kiUpdateType -> {
            auditTypeRepo.saveIfNotExists(kiUpdateType.getKiUpdateTypeName());

        });
        LOG.info("Old update records processing " + kiUpdateRepo.count());
        kiUpdateRepo.findAll().forEach(kiUpdates -> {

            Audit audit = new Audit(null, kiUpdates.getMsg(), kiUpdates.getUpdateDate(), kiUpdates.getIpAddress(), null);
            if (kiUpdates.getAddUriId() != null) {
                audit.setObjectId(Long.valueOf(kiUpdates.getAddUriId()));
            } else if (kiUpdates.getGameId() != null) {
                audit.setObjectId(Long.valueOf(kiUpdates.getGameId()));
            } else if (kiUpdates.getPhotoId() != null) {
                audit.setObjectId(Long.valueOf(kiUpdates.getPhotoId()));
            } else if (kiUpdates.getPolygonId() != null) {
                audit.setObjectId(Long.valueOf(kiUpdates.getPolygonId()));
            } else if (kiUpdates.getReviewId() != null) {
                audit.setObjectId(Long.valueOf(kiUpdates.getReviewId()));
            } else if (kiUpdates.getUpdatedUserId() != null) {
                audit.setObjectId(Long.valueOf(kiUpdates.getUpdatedUserId()));
            }
            auditRepo.save(audit);
        });

    }

    public Date[] parseDate(String str) {
        Date[] result = new Date[]{new Date(), new Date()};
        String[] split = str.split("(?U)\\s+");
        String[] dates = split[0].split("–");
        try {
            result[0] = new SimpleDateFormat("ddMMMMyyyy").parse(dates[0] + split[1] + Util.getCurrentYear());
            if (dates.length > 1) {
                result[1] = new SimpleDateFormat("ddMMMMyyyy").parse(dates[1] + split[1] + Util.getCurrentYear());
            } else {
                result[1] = new SimpleDateFormat("ddMMMMyyyy").parse(dates[0] + split[1] + Util.getCurrentYear());
            }

        } catch (Exception ex) {
            System.out.println("Parse date error: " + str);
        }
        return result;
    }

    public Date endDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days - 1);
        return c.getTime();
    }
}
