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
@Table(name = "ki_photo")
@XmlRootElement

public class KiPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "photo_id")
    private Integer photoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private int gameId;
    @Size(max = 255)
    @Column(name = "photo_author")
    private String photoAuthor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "photo_uri")
    private String photoUri;
    @Column(name = "author_id")
    private Integer authorId;
    @Size(max = 200)
    @Column(name = "photo_comment")
    private String photoComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "photo_good_flag")
    private short photoGoodFlag;

    public KiPhoto() {
    }

    public KiPhoto(Integer photoId) {
        this.photoId = photoId;
    }

    public KiPhoto(Integer photoId, int gameId, String photoUri, short photoGoodFlag) {
        this.photoId = photoId;
        this.gameId = gameId;
        this.photoUri = photoUri;
        this.photoGoodFlag = photoGoodFlag;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPhotoAuthor() {
        return photoAuthor;
    }

    public void setPhotoAuthor(String photoAuthor) {
        this.photoAuthor = photoAuthor;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getPhotoComment() {
        return photoComment;
    }

    public void setPhotoComment(String photoComment) {
        this.photoComment = photoComment;
    }

    public short getPhotoGoodFlag() {
        return photoGoodFlag;
    }

    public void setPhotoGoodFlag(short photoGoodFlag) {
        this.photoGoodFlag = photoGoodFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photoId != null ? photoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiPhoto)) {
            return false;
        }
        KiPhoto other = (KiPhoto) object;
        if ((this.photoId == null && other.photoId != null) || (this.photoId != null && !this.photoId.equals(other.photoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiPhoto[ photoId=" + photoId + " ]";
    }
    
}
