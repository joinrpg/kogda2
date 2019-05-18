/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author bychkov-sy
 */
@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long allRpgId;
    private String name;
    @ManyToOne
    private GameStatus status;
    @ManyToOne
    private Region region;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date start;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date end;
    @ManyToOne
    private GameType type;
    @ManyToOne
    private Polygon polygon;
    private Integer quantity;
    private String mg;
    private Boolean deleted = false;
    private Boolean approved = false;
    private String email;
    @OneToMany()
    private List<Link> links;
    @ElementCollection
    private List<String> comments;

    public Game() {
    }

    public Game(Long id, String name, GameStatus status, Region region, Date start, Date end, GameType type, Polygon polygon, Integer quantity, String mg) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.region = region;
        this.start = start;
        this.end = end;
        this.type = type;
        this.polygon = polygon;
        this.quantity = quantity;
        this.mg = mg;
        links = new ArrayList<>();
        comments = new ArrayList<>();

    }

    public Game(String name, GameStatus status, Region region, Date start, Date end, GameType type, Polygon polygon, Integer quantity, String mg) {

        this.name = name;
        this.status = status;
        this.region = region;
        this.start = start;
        this.end = end;
        this.type = type;
        this.polygon = polygon;
        this.quantity = quantity;
        this.mg = mg;
        links = new ArrayList<>();
        comments = new ArrayList<>();

    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAllRpgId() {
        return allRpgId;
    }

    public void setAllRpgId(Long allRpgId) {
        this.allRpgId = allRpgId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getDates() {
        String result = "";
        if (start != null && end != null) {
            LocalDate startDate;
            LocalDate endDate;
            if (start instanceof java.sql.Date) {
                startDate = ((java.sql.Date) start).toLocalDate();
            } else {
                startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (end instanceof java.sql.Date) {
                endDate = ((java.sql.Date) end).toLocalDate();
            } else {
                endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (startDate.isEqual(endDate)) {
                result = new SimpleDateFormat("dd MMMM").format(start);
            } else if (startDate.getMonth().equals(endDate.getMonth())) {
                result = startDate.getDayOfMonth() + " - " + new SimpleDateFormat("dd MMMM").format(end);
            } else {
                result = new SimpleDateFormat("dd MMMM").format(start) + " - "
                        + new SimpleDateFormat("dd MMMM").format(end);
            }
        }
        return result;
    }

    public String getMonth() {
        String result = "";
        LocalDate startDate;
        if (start != null) {
            if (start instanceof java.sql.Date) {

                startDate = ((java.sql.Date) start).toLocalDate();
            } else {
                startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            result = startDate.getMonth().name();
        }
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.status);
        hash = 67 * hash + Objects.hashCode(this.region);
        hash = 67 * hash + Objects.hashCode(this.start);
        hash = 67 * hash + Objects.hashCode(this.end);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + Objects.hashCode(this.polygon);
        hash = 67 * hash + Objects.hashCode(this.quantity);
        hash = 67 * hash + Objects.hashCode(this.mg);
        hash = 67 * hash + Objects.hashCode(this.links);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.polygon, other.polygon)) {
            return false;
        }
        if (!Objects.equals(this.mg, other.mg)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.links, other.links)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", name=" + name + ", status=" + status + ", region=" + region + ", start=" + start + ", end=" + end + ", type=" + type + ", polygon=" + polygon + ", quantity=" + quantity + ", mg=" + mg + ", links=" + links + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void removeLink(Link link) {
        links.remove(link);
    }

    public void removeComment(String comment) {
        comments.remove(comment);
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
