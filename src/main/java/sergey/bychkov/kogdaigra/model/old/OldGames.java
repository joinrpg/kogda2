/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author 16715817
 */
@Entity
@Table(name = "old_games")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OldGames.findAll", query = "SELECT o FROM OldGames o")
    , @NamedQuery(name = "OldGames.findByOldGameId", query = "SELECT o FROM OldGames o WHERE o.oldGameId = :oldGameId")
    , @NamedQuery(name = "OldGames.findByGameDate", query = "SELECT o FROM OldGames o WHERE o.gameDate = :gameDate")
    , @NamedQuery(name = "OldGames.findByGameName", query = "SELECT o FROM OldGames o WHERE o.gameName = :gameName")
    , @NamedQuery(name = "OldGames.findByGameRegion", query = "SELECT o FROM OldGames o WHERE o.gameRegion = :gameRegion")
    , @NamedQuery(name = "OldGames.findByGameUri", query = "SELECT o FROM OldGames o WHERE o.gameUri = :gameUri")})
public class OldGames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "old_game_id")
    private Integer oldGameId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "game_date")
    private String gameDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "game_name")
    private String gameName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "game_region")
    private String gameRegion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "game_uri")
    private String gameUri;

    public OldGames() {
    }

    public OldGames(Integer oldGameId) {
        this.oldGameId = oldGameId;
    }

    public OldGames(Integer oldGameId, String gameDate, String gameName, String gameRegion, String gameUri) {
        this.oldGameId = oldGameId;
        this.gameDate = gameDate;
        this.gameName = gameName;
        this.gameRegion = gameRegion;
        this.gameUri = gameUri;
    }

    public Integer getOldGameId() {
        return oldGameId;
    }

    public void setOldGameId(Integer oldGameId) {
        this.oldGameId = oldGameId;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameRegion() {
        return gameRegion;
    }

    public void setGameRegion(String gameRegion) {
        this.gameRegion = gameRegion;
    }

    public String getGameUri() {
        return gameUri;
    }

    public void setGameUri(String gameUri) {
        this.gameUri = gameUri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oldGameId != null ? oldGameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OldGames)) {
            return false;
        }
        OldGames other = (OldGames) object;
        if ((this.oldGameId == null && other.oldGameId != null) || (this.oldGameId != null && !this.oldGameId.equals(other.oldGameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.OldGames[ oldGameId=" + oldGameId + " ]";
    }
    
}
