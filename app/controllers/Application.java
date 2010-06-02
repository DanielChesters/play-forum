package controllers;

import java.util.List;

import models.Topic;

import play.mvc.*;

public class Application extends Controller {

    public static void index() {
        List<Topic> topics = Topic.find("order by modified desc").fetch();
        render(topics);
    }

    public static void show(Long id) {
        Topic topic = Topic.findById(id);
        render(topic);
    }

    public static void reply(Long topicId,String author, String subtitle, String text){
        Topic topic = Topic.findById(topicId);
        topic.addPost(subtitle, text, author);
        flash.success("Your reply was posted");
        show(topicId);
    }

}