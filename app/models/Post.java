package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Post extends Model {
    public String subtitle;
    @Lob
    public String text;

    public String author;

    public Date created;
    public Date modified;
    @ManyToOne
    public Topic topic;

    public Post(String subtitle, String text, String author) {
        this.subtitle = subtitle;
        this.text = text;
        this.author = author;
        this.created = new Date();
    }
}
