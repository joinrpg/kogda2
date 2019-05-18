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
@Table(name = "ki_zayavka_allrpg")
@XmlRootElement

public class KiZayavkaAllrpg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "allrpg_zayvka_id")
    private Integer allrpgZayvkaId;
    @Column(name = "game_id")
    private Integer gameId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opened")
    private short opened;

    public KiZayavkaAllrpg() {
    }

    public KiZayavkaAllrpg(Integer allrpgZayvkaId) {
        this.allrpgZayvkaId = allrpgZayvkaId;
    }

    public KiZayavkaAllrpg(Integer allrpgZayvkaId, String name, short opened) {
        this.allrpgZayvkaId = allrpgZayvkaId;
        this.name = name;
        this.opened = opened;
    }

    public Integer getAllrpgZayvkaId() {
        return allrpgZayvkaId;
    }

    public void setAllrpgZayvkaId(Integer allrpgZayvkaId) {
        this.allrpgZayvkaId = allrpgZayvkaId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getOpened() {
        return opened;
    }

    public void setOpened(short opened) {
        this.opened = opened;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (allrpgZayvkaId != null ? allrpgZayvkaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiZayavkaAllrpg)) {
            return false;
        }
        KiZayavkaAllrpg other = (KiZayavkaAllrpg) object;
        if ((this.allrpgZayvkaId == null && other.allrpgZayvkaId != null) || (this.allrpgZayvkaId != null && !this.allrpgZayvkaId.equals(other.allrpgZayvkaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiZayavkaAllrpg[ allrpgZayvkaId=" + allrpgZayvkaId + " ]";
    }
    
}
