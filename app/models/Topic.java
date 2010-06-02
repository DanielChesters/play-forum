package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Topic extends Model {

    public String title;
    public Date created;
    public Date modified;

    @OneToMany(mappedBy = "topic", cascade=CascadeType.ALL)
    @OrderBy("created")
    public List<Post> posts;

    public Topic(String title) {
        super();
        this.title = title;
        this.created = new Date();
        this.posts = new ArrayList<Post>();
    }

    public Topic addPost(String subtitle, String text, String author) {
        Post post = new Post(subtitle, text, author).save();
        posts.add(post);
        post.topic = this;
        this.modified = new Date();
        this.save();
        return this;
    }

}
