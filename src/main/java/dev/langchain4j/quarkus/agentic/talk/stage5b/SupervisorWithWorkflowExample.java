package dev.langchain4j.quarkus.agentic.talk.stage5b;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;

import java.io.IOException;

@ActivateRequestContext
public class SupervisorWithWorkflowExample implements QuarkusApplication {

    @Inject
    SupervisorStoryCreator supervisorStoryCreator;

    @Override
    public int run(String... args) throws IOException {
        String topic = "dragons and wizards";
        String style = "comedy";

        Log.infof("Generate a novel about %s in style %s", topic, style);
        String novel = supervisorStoryCreator.write(topic, style);

        Log.infof("Final novel: %s", novel);

        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(SupervisorWithWorkflowExample.class, args);
    }
}
