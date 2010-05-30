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

}
