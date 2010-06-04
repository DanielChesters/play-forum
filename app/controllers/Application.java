package controllers;

import java.util.List;

import models.Topic;

import play.data.validation.Required;
import play.mvc.*;

/**
 * Application controller
 *
 * @author Daniel Chesters
 *
 */
public class Application extends Controller {

    /**
     * list of topics
     */
    public static void index() {
        List<Topic> topics = Topic.find("order by modified desc").fetch();
        render(topics);
    }

    /**
     * Show a topic
     *
     * @param id
     *            id of the topic
     */
    public static void show(Long id) {
        Topic topic = Topic.findById(id);
        render(topic);
    }

    /**
     * add a topic
     */
    public static void add() {
        render();
    }

    /**
     * @param topicId
     *            id of the topic
     * @param author
     *            author of the post
     * @param subtitle
     *            subtitle of the post
     * @param text
     *            text of the post
     */
    public static void reply(Long topicId,
            @Required(message = "You must say you name") String author,
            String subtitle,
            @Required(message = "You must say something") String text) {
        Topic topic = Topic.findById(topicId);
        if (validation.hasErrors()){
            render("Application/show.html", topic);
        } else {
            topic.addPost(subtitle, text, author);
            flash.success("Your reply was posted");
            show(topicId);
        }
    }

    /**
     * @param title
     *            title of the topic
     * @param author
     *            author of the first post
     * @param subtitle
     *            subtitle of the first post
     * @param text
     *            text of the first post
     */
    public static void createTopic(
            @Required(message = "You must have a title") String title,
            @Required(message = "You must say you name") String author,
            String subtitle,
            @Required(message = "You must say something") String text) {
        if (validation.hasErrors()) {
            render("Application/add.html");
        } else {
            Topic topic = new Topic(title);
            topic.addPost(subtitle, text, author);
            topic.save();
            flash.success("Your topic was created");
            show(topic.id);
        }

    }
}