package sergey.bychkov.kogdaigra.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Photo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Game game;
    private String author;
    @ManyToOne
    private Link uri;

    public Photo() {
    }

    public Photo(Game game, String author, Link uri) {
        this.game = game;
        this.author = author;
        this.uri = uri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Link getUri() {
        return uri;
    }

    public void setUri(Link uri) {
        this.uri = uri;
    }
}
