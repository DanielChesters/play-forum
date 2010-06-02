import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    private Long topicId;

    @Before
    public void setup(){
        Fixtures.deleteAll();
        Topic topic = new Topic("title").save();
        topicId = topic.id;
    }

    @Test
    public void createdTopic(){
        Topic topic = Topic.findById(topicId);

        assertNotNull(topic);
        assertNotNull(topic.id);
        assertEquals("title", topic.title);
        assertNotNull(topic.created);
        assertNull(topic.modified);
        assertNotNull(topic.posts);
        assertEquals(0, topic.posts.size());

    }

    @Test
    public void createdPost() {
        Topic topic = Topic.findById(topicId);

        topic.addPost("subtitle", "text", "author");

        assertNotNull(topic.modified);
        assertEquals(1 , topic.posts.size());
        Post post = topic.posts.get(0);

        assertNotNull(post);
        assertNotNull(post.id);
        assertEquals("subtitle", post.subtitle);
        assertEquals("text", post.text);
        assertEquals("author", post.author);
        assertNotNull(post.created);
        assertNull(post.modified);
        assertNotNull(post.topic);
        assertEquals(topic, post.topic);
    }


}
