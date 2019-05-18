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
@Table(name = "ki_game_types")
@XmlRootElement
public class KiGameType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_type_id")
    private Integer gameTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "game_type_name")
    private String gameTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_all_regions")
    private short showAllRegions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "game_type_style")
    private String gameTypeStyle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_type_real_game")
    private short gameTypeRealGame;

    public KiGameType() {
    }

    public KiGameType(Integer gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public KiGameType(Integer gameTypeId, String gameTypeName, short showAllRegions, String gameTypeStyle, short gameTypeRealGame) {
        this.gameTypeId = gameTypeId;
        this.gameTypeName = gameTypeName;
        this.showAllRegions = showAllRegions;
        this.gameTypeStyle = gameTypeStyle;
        this.gameTypeRealGame = gameTypeRealGame;
    }

    public Integer getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Integer gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }

    public short getShowAllRegions() {
        return showAllRegions;
    }

    public void setShowAllRegions(short showAllRegions) {
        this.showAllRegions = showAllRegions;
    }

    public String getGameTypeStyle() {
        return gameTypeStyle;
    }

    public void setGameTypeStyle(String gameTypeStyle) {
        this.gameTypeStyle = gameTypeStyle;
    }

    public short getGameTypeRealGame() {
        return gameTypeRealGame;
    }

    public void setGameTypeRealGame(short gameTypeRealGame) {
        this.gameTypeRealGame = gameTypeRealGame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameTypeId != null ? gameTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiGameType)) {
            return false;
        }
        KiGameType other = (KiGameType) object;
        if ((this.gameTypeId == null && other.gameTypeId != null) || (this.gameTypeId != null && !this.gameTypeId.equals(other.gameTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiGameTypes[ gameTypeId=" + gameTypeId + " ]";
    }
    
}
