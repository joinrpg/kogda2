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
@Table(name = "ki_polygons")
@XmlRootElement

public class KiPolygon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "polygon_id")
    private Integer polygonId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "polygon_name")
    private String polygonName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_region_id")
    private int subRegionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meta_polygon")
    private int metaPolygon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted_flag")
    private short deletedFlag;

    public KiPolygon() {
    }

    public KiPolygon(Integer polygonId) {
        this.polygonId = polygonId;
    }

    public KiPolygon(Integer polygonId, String polygonName, int subRegionId, int metaPolygon, short deletedFlag) {
        this.polygonId = polygonId;
        this.polygonName = polygonName;
        this.subRegionId = subRegionId;
        this.metaPolygon = metaPolygon;
        this.deletedFlag = deletedFlag;
    }

    public Integer getPolygonId() {
        return polygonId;
    }

    public void setPolygonId(Integer polygonId) {
        this.polygonId = polygonId;
    }

    public String getPolygonName() {
        return polygonName;
    }

    public void setPolygonName(String polygonName) {
        this.polygonName = polygonName;
    }

    public int getSubRegionId() {
        return subRegionId;
    }

    public void setSubRegionId(int subRegionId) {
        this.subRegionId = subRegionId;
    }

    public int getMetaPolygon() {
        return metaPolygon;
    }

    public void setMetaPolygon(int metaPolygon) {
        this.metaPolygon = metaPolygon;
    }

    public short getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(short deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polygonId != null ? polygonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiPolygon)) {
            return false;
        }
        KiPolygon other = (KiPolygon) object;
        if ((this.polygonId == null && other.polygonId != null) || (this.polygonId != null && !this.polygonId.equals(other.polygonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiPolygons[ polygonId=" + polygonId + " ]";
    }
    
}
