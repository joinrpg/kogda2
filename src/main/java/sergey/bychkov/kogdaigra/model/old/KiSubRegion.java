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
@Table(name = "ki_sub_regions")
@XmlRootElement
public class KiSubRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_region_id")
    private Integer subRegionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sub_region_name")
    private String subRegionName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sub_region_disp_name")
    private String subRegionDispName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_id")
    private Integer regionId;

    public KiSubRegion() {
    }

    public KiSubRegion(Integer subRegionId) {
        this.subRegionId = subRegionId;
    }

    public KiSubRegion(Integer subRegionId, String subRegionName, String subRegionDispName, int regionId) {
        this.subRegionId = subRegionId;
        this.subRegionName = subRegionName;
        this.subRegionDispName = subRegionDispName;
        this.regionId = regionId;
    }

    public Integer getSubRegionId() {
        return subRegionId;
    }

    public void setSubRegionId(Integer subRegionId) {
        this.subRegionId = subRegionId;
    }

    public String getSubRegionName() {
        return subRegionName;
    }

    public void setSubRegionName(String subRegionName) {
        this.subRegionName = subRegionName;
    }

    public String getSubRegionDispName() {
        return subRegionDispName;
    }

    public void setSubRegionDispName(String subRegionDispName) {
        this.subRegionDispName = subRegionDispName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subRegionId != null ? subRegionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiSubRegion)) {
            return false;
        }
        KiSubRegion other = (KiSubRegion) object;
        if ((this.subRegionId == null && other.subRegionId != null) || (this.subRegionId != null && !this.subRegionId.equals(other.subRegionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiSubRegions[ subRegionId=" + subRegionId + " ]";
    }
    
}
