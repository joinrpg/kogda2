/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author serge
 */
@Entity
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String url;
    @ManyToOne
    private LinkType type;

    public Link(String url, LinkType type) {
        this.url = url;
        this.type = type;
    }

    public Link() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LinkType getType() {
        return type;
    }

    public void setType(LinkType type) {
        this.type = type;
    }
}
