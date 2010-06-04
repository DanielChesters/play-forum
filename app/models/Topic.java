package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * Topic class
 * @author Daniel Chesters
 *
 */
@Entity
public class Topic extends Model {


    /**
     * Title of the topic
     */
    @Required
    public String title;
    /**
     * Date of topic creation
     */
    @Required
    public Date created;
    /**
     * Date of topic modication
     */
    public Date modified;

    /**
     * Posts of the topic
     */
    @OneToMany(mappedBy = "topic", cascade=CascadeType.ALL)
    @OrderBy("created")
    public List<Post> posts;

    /**
     * Default constructor
     * @param title title of the topic
     */
    public Topic(String title) {
        this.title = title;
        this.created = new Date();
        this.posts = new ArrayList<Post>();
    }

    /**
     * add post method
     * @param subtitle Subtitle of the post
     * @param text Text of the post
     * @param author Author of the post
     * @return The topic
     */
    public Topic addPost(String subtitle, String text, String author) {
        Post post = new Post(subtitle, text, author);
        this.posts.add(post);
        this.modified = new Date();
        this.save();

        post.topic = this;
        post.save();

        return this;
    }

}
