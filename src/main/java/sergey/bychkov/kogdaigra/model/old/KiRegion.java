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
@Table(name = "ki_regions")
@XmlRootElement
public class KiRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_id")
    private Integer regionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "region_name")
    private String regionName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "region_code")
    private String regionCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_experimental")
    private short regionExperimental;

    public KiRegion() {
    }

    public KiRegion(Integer regionId) {
        this.regionId = regionId;
    }

    public KiRegion(Integer regionId, String regionName, String regionCode, short regionExperimental) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionCode = regionCode;
        this.regionExperimental = regionExperimental;
    }

    public @NotNull Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public short getRegionExperimental() {
        return regionExperimental;
    }

    public void setRegionExperimental(short regionExperimental) {
        this.regionExperimental = regionExperimental;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiRegion)) {
            return false;
        }
        KiRegion other = (KiRegion) object;
        if ((this.regionId == null && other.regionId != null) || (this.regionId != null && !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiRegions[ regionId=" + regionId + " ]";
    }
    
}
