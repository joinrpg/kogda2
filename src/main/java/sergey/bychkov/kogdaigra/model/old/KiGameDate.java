/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 16715817
 */
@Entity
@Table(name = "ki_game_date")
@XmlRootElement
public class KiGameDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_date_id")
    private Integer gameDateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private Integer gameId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "begin")
    @Temporal(TemporalType.DATE)
    private Date begin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private int time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hidden_flag")
    private short hiddenFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"order\"")
    private int order;

    public KiGameDate() {
    }

    public KiGameDate(Integer gameDateId) {
        this.gameDateId = gameDateId;
    }

    public KiGameDate(Integer gameDateId, int gameId, Date begin, int time, short hiddenFlag, int order) {
        this.gameDateId = gameDateId;
        this.gameId = gameId;
        this.begin = begin;
        this.time = time;
        this.hiddenFlag = hiddenFlag;
        this.order = order;
    }

    public Integer getGameDateId() {
        return gameDateId;
    }

    public void setGameDateId(Integer gameDateId) {
        this.gameDateId = gameDateId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public short getHiddenFlag() {
        return hiddenFlag;
    }

    public void setHiddenFlag(short hiddenFlag) {
        this.hiddenFlag = hiddenFlag;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameDateId != null ? gameDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiGameDate)) {
            return false;
        }
        KiGameDate other = (KiGameDate) object;
        if ((this.gameDateId == null && other.gameDateId != null) || (this.gameDateId != null && !this.gameDateId.equals(other.gameDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiGameDate[ gameDateId=" + gameDateId + " ]";
    }
    
}
