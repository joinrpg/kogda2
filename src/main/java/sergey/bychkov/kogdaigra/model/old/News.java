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
import java.util.Date;

/**
 *
 * @author 16715817
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n")
    , @NamedQuery(name = "News.findByNewsId", query = "SELECT n FROM News n WHERE n.newsId = :newsId")
    , @NamedQuery(name = "News.findByNewsDate", query = "SELECT n FROM News n WHERE n.newsDate = :newsDate")
    , @NamedQuery(name = "News.findByNewsAuthor", query = "SELECT n FROM News n WHERE n.newsAuthor = :newsAuthor")
    , @NamedQuery(name = "News.findByNewsHeader", query = "SELECT n FROM News n WHERE n.newsHeader = :newsHeader")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "news_id")
    private Integer newsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "news_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newsDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "news_author")
    private String newsAuthor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "news_header")
    private String newsHeader;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "news_text")
    private String newsText;

    public News() {
    }

    public News(Integer newsId) {
        this.newsId = newsId;
    }

    public News(Integer newsId, Date newsDate, String newsAuthor, String newsHeader, String newsText) {
        this.newsId = newsId;
        this.newsDate = newsDate;
        this.newsAuthor = newsAuthor;
        this.newsHeader = newsHeader;
        this.newsText = newsText;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public String getNewsHeader() {
        return newsHeader;
    }

    public void setNewsHeader(String newsHeader) {
        this.newsHeader = newsHeader;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.News[ newsId=" + newsId + " ]";
    }
    
}
