/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author 16715817
 */
@Entity
@Table(name = "ki_update_types")
public class KiUpdateType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ki_update_type_id")
    private Integer kiUpdateTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ki_update_type_name")
    private String kiUpdateTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_type_polygon_flag")
    private short updateTypePolygonFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_type_game_flag")
    private short updateTypeGameFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_type_photo_flag")
    private short updateTypePhotoFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_type_review_flag")
    private short updateTypeReviewFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "advertise_update_flag")
    private short advertiseUpdateFlag;
    @Size(max = 255)
    @Column(name = "update_type_user_text")
    private String updateTypeUserText;

    public KiUpdateType() {
    }

    public KiUpdateType(Integer kiUpdateTypeId) {
        this.kiUpdateTypeId = kiUpdateTypeId;
    }

    public KiUpdateType(Integer kiUpdateTypeId, String kiUpdateTypeName, short updateTypePolygonFlag, short updateTypeGameFlag, short updateTypePhotoFlag, short updateTypeReviewFlag, short advertiseUpdateFlag) {
        this.kiUpdateTypeId = kiUpdateTypeId;
        this.kiUpdateTypeName = kiUpdateTypeName;
        this.updateTypePolygonFlag = updateTypePolygonFlag;
        this.updateTypeGameFlag = updateTypeGameFlag;
        this.updateTypePhotoFlag = updateTypePhotoFlag;
        this.updateTypeReviewFlag = updateTypeReviewFlag;
        this.advertiseUpdateFlag = advertiseUpdateFlag;
    }

    public Integer getKiUpdateTypeId() {
        return kiUpdateTypeId;
    }

    public void setKiUpdateTypeId(Integer kiUpdateTypeId) {
        this.kiUpdateTypeId = kiUpdateTypeId;
    }

    public String getKiUpdateTypeName() {
        return kiUpdateTypeName;
    }

    public void setKiUpdateTypeName(String kiUpdateTypeName) {
        this.kiUpdateTypeName = kiUpdateTypeName;
    }

    public short getUpdateTypePolygonFlag() {
        return updateTypePolygonFlag;
    }

    public void setUpdateTypePolygonFlag(short updateTypePolygonFlag) {
        this.updateTypePolygonFlag = updateTypePolygonFlag;
    }

    public short getUpdateTypeGameFlag() {
        return updateTypeGameFlag;
    }

    public void setUpdateTypeGameFlag(short updateTypeGameFlag) {
        this.updateTypeGameFlag = updateTypeGameFlag;
    }

    public short getUpdateTypePhotoFlag() {
        return updateTypePhotoFlag;
    }

    public void setUpdateTypePhotoFlag(short updateTypePhotoFlag) {
        this.updateTypePhotoFlag = updateTypePhotoFlag;
    }

    public short getUpdateTypeReviewFlag() {
        return updateTypeReviewFlag;
    }

    public void setUpdateTypeReviewFlag(short updateTypeReviewFlag) {
        this.updateTypeReviewFlag = updateTypeReviewFlag;
    }

    public short getAdvertiseUpdateFlag() {
        return advertiseUpdateFlag;
    }

    public void setAdvertiseUpdateFlag(short advertiseUpdateFlag) {
        this.advertiseUpdateFlag = advertiseUpdateFlag;
    }

    public String getUpdateTypeUserText() {
        return updateTypeUserText;
    }

    public void setUpdateTypeUserText(String updateTypeUserText) {
        this.updateTypeUserText = updateTypeUserText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kiUpdateTypeId != null ? kiUpdateTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiUpdateType)) {
            return false;
        }
        KiUpdateType other = (KiUpdateType) object;
        if ((this.kiUpdateTypeId == null && other.kiUpdateTypeId != null) || (this.kiUpdateTypeId != null && !this.kiUpdateTypeId.equals(other.kiUpdateTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiUpdateType[ kiUpdateTypeId=" + kiUpdateTypeId + " ]";
    }
    
}
