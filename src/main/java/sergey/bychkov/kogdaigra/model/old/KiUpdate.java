/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 16715817
 */

@Entity
@Table(name = "ki_updates")
@XmlRootElement
public class KiUpdate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ki_update_id")
    private Integer kiUpdateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ki_update_type_id")
    private int kiUpdateTypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "polygon_id")
    private Integer polygonId;
    @Column(name = "photo_id")
    private Integer photoId;
    @Column(name = "updated_user_id")
    private Integer updatedUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "msg")
    private String msg;
    @Size(max = 45)
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "add_uri_id")
    private Integer addUriId;

    public KiUpdate() {
    }

    public KiUpdate(Integer kiUpdateId) {
        this.kiUpdateId = kiUpdateId;
    }

    public KiUpdate(Integer kiUpdateId, int kiUpdateTypeId, int userId, Date updateDate, String msg) {
        this.kiUpdateId = kiUpdateId;
        this.kiUpdateTypeId = kiUpdateTypeId;
        this.userId = userId;
        this.updateDate = updateDate;
        this.msg = msg;
    }

    public Integer getKiUpdateId() {
        return kiUpdateId;
    }

    public void setKiUpdateId(Integer kiUpdateId) {
        this.kiUpdateId = kiUpdateId;
    }

    public int getKiUpdateTypeId() {
        return kiUpdateTypeId;
    }

    public void setKiUpdateTypeId(int kiUpdateTypeId) {
        this.kiUpdateTypeId = kiUpdateTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getPolygonId() {
        return polygonId;
    }

    public void setPolygonId(Integer polygonId) {
        this.polygonId = polygonId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getAddUriId() {
        return addUriId;
    }

    public void setAddUriId(Integer addUriId) {
        this.addUriId = addUriId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kiUpdateId != null ? kiUpdateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiUpdate)) {
            return false;
        }
        KiUpdate other = (KiUpdate) object;
        if ((this.kiUpdateId == null && other.kiUpdateId != null) || (this.kiUpdateId != null && !this.kiUpdateId.equals(other.kiUpdateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiUpdate[ kiUpdateId=" + kiUpdateId + " ]";
    }
    
}
