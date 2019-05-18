/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author 16715817
 */
@Entity
@Table(name = "news_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsTags.findAll", query = "SELECT n FROM NewsTags n")
    , @NamedQuery(name = "NewsTags.findByNid", query = "SELECT n FROM NewsTags n WHERE n.newsTagsPK.nid = :nid")
    , @NamedQuery(name = "NewsTags.findByTid", query = "SELECT n FROM NewsTags n WHERE n.newsTagsPK.tid = :tid")})
public class NewsTags implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NewsTagsPK newsTagsPK;

    public NewsTags() {
    }

    public NewsTags(NewsTagsPK newsTagsPK) {
        this.newsTagsPK = newsTagsPK;
    }

    public NewsTags(int nid, int tid) {
        this.newsTagsPK = new NewsTagsPK(nid, tid);
    }

    public NewsTagsPK getNewsTagsPK() {
        return newsTagsPK;
    }

    public void setNewsTagsPK(NewsTagsPK newsTagsPK) {
        this.newsTagsPK = newsTagsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsTagsPK != null ? newsTagsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsTags)) {
            return false;
        }
        NewsTags other = (NewsTags) object;
        if ((this.newsTagsPK == null && other.newsTagsPK != null) || (this.newsTagsPK != null && !this.newsTagsPK.equals(other.newsTagsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.NewsTags[ newsTagsPK=" + newsTagsPK + " ]";
    }
    
}
