package sergey.bychkov.kogdaigra.model;

import sergey.bychkov.kogdaigra.model.old.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Audit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private Long   objectId;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date   timestamp;
    private String ip;
    private User   author;

    public Audit() {
    }

    public Audit(Long objectId) {
        this.objectId = objectId;

    }

    public Audit(Long objectId, String message, Date timestamp, String ip, User author) {
        this.objectId = objectId;
        this.message = message;
        this.timestamp = timestamp;
        this.ip = ip;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
