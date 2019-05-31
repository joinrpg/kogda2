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
 * @author 16715817
 */
@Entity
public class Polygon implements Serializable {

    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    @ManyToOne
    private Region region;

    public Polygon() {
    }

    public Polygon(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
