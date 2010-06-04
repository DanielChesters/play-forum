import models.Topic;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;


/**
 * @author Daniel Chesters
 * @see Job
 */
@OnApplicationStart
public class Bootstrap extends Job {
    @Override
    public void doJob() throws Exception {
        if (Topic.count() == 0){
            Fixtures.load("initial-data.yml");
        }
    }
}
