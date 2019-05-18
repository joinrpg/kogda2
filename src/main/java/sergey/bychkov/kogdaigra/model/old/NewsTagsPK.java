/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author 16715817
 */
@Embeddable
public class NewsTagsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nid")
    private int nid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tid")
    private int tid;

    public NewsTagsPK() {
    }

    public NewsTagsPK(int nid, int tid) {
        this.nid = nid;
        this.tid = tid;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nid;
        hash += (int) tid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsTagsPK)) {
            return false;
        }
        NewsTagsPK other = (NewsTagsPK) object;
        if (this.nid != other.nid) {
            return false;
        }
        if (this.tid != other.tid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.NewsTagsPK[ nid=" + nid + ", tid=" + tid + " ]";
    }
    
}
