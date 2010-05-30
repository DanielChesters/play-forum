package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

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
}
