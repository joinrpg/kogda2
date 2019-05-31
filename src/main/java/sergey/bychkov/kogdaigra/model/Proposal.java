/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author serge
 */
@Entity
public class Proposal {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;
    private Integer allrpgId;
    private boolean resolved;

    public Proposal() {
    }

    public Proposal(String uri, Integer allrpgId, boolean resolved) {
        this.uri = uri;
        this.allrpgId = allrpgId;
        this.resolved = resolved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getAllrpgId() {
        return allrpgId;
    }

    public void setAllrpgId(Integer allrpgId) {
        this.allrpgId = allrpgId;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
