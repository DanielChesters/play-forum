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

}