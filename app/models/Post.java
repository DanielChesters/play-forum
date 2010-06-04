package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * Post class
 * @author Daniel Chesters
 *
 */
@Entity
public class Post extends Model {
    /**
     * Subtitle of the topic
     */
    public String subtitle;
    /**
     * Text of the post
     */
    @Lob
    @Required
    public String text;

    /**
     * Author of the post
     * TODO change to futur User class
     */
    @Required
    public String author;

    /**
     * Date of post creation
     */
    @Required
    public Date created;
    /**
     * Date of last post modification
     */
    public Date modified;
    /**
     * Topic link the post
     */
    @ManyToOne
    public Topic topic;

    /**
     * Default constructor
     * @param subtitle subtitle of the post
     * @param text text of the post
     * @param author author of the post
     */
    public Post(String subtitle, String text, String author) {
        this.subtitle = subtitle;
        this.text = text;
        this.author = author;
        this.created = new Date();
    }
}
