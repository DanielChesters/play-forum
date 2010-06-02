package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import play.db.jpa.Model;

@Entity
public class Topic extends Model {

    public String title;
    public Date created;
    public Date modified;

    @OneToMany(mappedBy = "topic", cascade=CascadeType.ALL)
    @OrderBy("created")
    public List<Post> posts;

    public Topic(String title) {
        this.title = title;
        this.created = new Date();
        this.posts = new ArrayList<Post>();
    }

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
