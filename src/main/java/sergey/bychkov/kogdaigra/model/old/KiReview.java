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
@Table(name = "ki_review")
@XmlRootElement

public class KiReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "review_id")
    private Integer reviewId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private int gameId;
    @Size(max = 100)
    @Column(name = "author_name")
    private String authorName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "topic_id")
    private int topicId;
    @Size(max = 200)
    @Column(name = "review_uri")
    private String reviewUri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_review_flag")
    private short showReviewFlag;
    @Column(name = "author_id")
    private Integer authorId;

    public KiReview() {
    }

    public KiReview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public KiReview(Integer reviewId, int gameId, int topicId, short showReviewFlag) {
        this.reviewId = reviewId;
        this.gameId = gameId;
        this.topicId = topicId;
        this.showReviewFlag = showReviewFlag;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getReviewUri() {
        return reviewUri;
    }

    public void setReviewUri(String reviewUri) {
        this.reviewUri = reviewUri;
    }

    public short getShowReviewFlag() {
        return showReviewFlag;
    }

    public void setShowReviewFlag(short showReviewFlag) {
        this.showReviewFlag = showReviewFlag;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiReview)) {
            return false;
        }
        KiReview other = (KiReview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiReview[ reviewId=" + reviewId + " ]";
    }
    
}
