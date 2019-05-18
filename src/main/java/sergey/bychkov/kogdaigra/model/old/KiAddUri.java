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
@Table(name = "ki_add_uri")
@XmlRootElement
public class KiAddUri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "add_uri_id")
    private Integer addUriId;
    @Size(max = 300)
    @Column(name = "uri")
    private String uri;
    @Column(name = "allrpg_info_id")
    private Integer allrpgInfoId;
    @Basic(optional = false)
    @Column(name = "resolved")
    private boolean resolved;

    public KiAddUri() {
    }

    public KiAddUri(Integer addUriId) {
        this.addUriId = addUriId;
    }

    public KiAddUri(Integer addUriId, boolean resolved) {
        this.addUriId = addUriId;
        this.resolved = resolved;
    }

    public Integer getAddUriId() {
        return addUriId;
    }

    public void setAddUriId(Integer addUriId) {
        this.addUriId = addUriId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getAllrpgInfoId() {
        return allrpgInfoId;
    }

    public void setAllrpgInfoId(Integer allrpgInfoId) {
        this.allrpgInfoId = allrpgInfoId;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addUriId != null ? addUriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiAddUri)) {
            return false;
        }
        KiAddUri other = (KiAddUri) object;
        if ((this.addUriId == null && other.addUriId != null) || (this.addUriId != null && !this.addUriId.equals(other.addUriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiAddUri[ addUriId=" + addUriId + " ]";
    }
    
}
