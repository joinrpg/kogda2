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
@Table(name = "ki_games")
@XmlRootElement
public class KiGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uri")
    private String uri;
    @Basic(optional = false)
    @Column(name = "type")
    private Integer type;
    @Basic(optional = false)
    @Column(name = "polygon")
    private Integer polygon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mg")
    private String mg;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_flags")
    private int showFlags;
    @Basic(optional = false)
    @Column(name = "status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_region_id")
    private int subRegionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted_flag")
    private short deletedFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hide_email")
    private short hideEmail;
    @Column(name = "players_count")
    private Integer playersCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "review_count")
    private int reviewCount;
    @Column(name = "allrpg_info_id")
    private Integer allrpgInfoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "photo_count")
    private int photoCount;
    @Column(name = "redirect_id")
    private Integer redirectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vk_likes")
    private int vkLikes;
    @Size(max = 40)
    @Column(name = "vk_club")
    private String vkClub;
    @Size(max = 255)
    @Column(name = "lj_comm")
    private String ljComm;
    @Size(max = 40)
    @Column(name = "fb_comm")
    private String fbComm;

    public KiGame() {
    }

    public KiGame(Integer id) {
        this.id = id;
    }

    public KiGame(Integer id, String name, String uri, Integer type, int polygon, String mg, String email, int showFlags, Integer status, String comment, int subRegionId, short deletedFlag, short hideEmail, int reviewCount, int photoCount, int vkLikes) {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.type = type;
        this.polygon = polygon;
        this.mg = mg;
        this.email = email;
        this.showFlags = showFlags;
        this.status = status;
        this.comment = comment;
        this.subRegionId = subRegionId;
        this.deletedFlag = deletedFlag;
        this.hideEmail = hideEmail;
        this.reviewCount = reviewCount;
        this.photoCount = photoCount;
        this.vkLikes = vkLikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPolygon() {
        return polygon;
    }

    public void setPolygon(Integer polygon) {
        this.polygon = polygon;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShowFlags() {
        return showFlags;
    }

    public void setShowFlags(int showFlags) {
        this.showFlags = showFlags;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSubRegionId() {
        return subRegionId;
    }

    public void setSubRegionId(int subRegionId) {
        this.subRegionId = subRegionId;
    }

    public short getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(short deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public short getHideEmail() {
        return hideEmail;
    }

    public void setHideEmail(short hideEmail) {
        this.hideEmail = hideEmail;
    }

    public Integer getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(Integer playersCount) {
        this.playersCount = playersCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getAllrpgInfoId() {
        return allrpgInfoId;
    }

    public void setAllrpgInfoId(Integer allrpgInfoId) {
        this.allrpgInfoId = allrpgInfoId;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public Integer getRedirectId() {
        return redirectId;
    }

    public void setRedirectId(Integer redirectId) {
        this.redirectId = redirectId;
    }

    public int getVkLikes() {
        return vkLikes;
    }

    public void setVkLikes(int vkLikes) {
        this.vkLikes = vkLikes;
    }

    public String getVkClub() {
        return vkClub;
    }

    public void setVkClub(String vkClub) {
        this.vkClub = vkClub;
    }

    public String getLjComm() {
        return ljComm;
    }

    public void setLjComm(String ljComm) {
        this.ljComm = ljComm;
    }

    public String getFbComm() {
        return fbComm;
    }

    public void setFbComm(String fbComm) {
        this.fbComm = fbComm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiGame)) {
            return false;
        }
        KiGame other = (KiGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiGames[ id=" + id + " ]";
    }
    
}
