package dev.langchain4j.quarkus.agentic.talk.stage5a;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;

import java.io.IOException;

@ActivateRequestContext
public class SupervisorExample implements QuarkusApplication {

    @Inject
    SupervisorStoryCreator supervisorStoryCreator;

    @Override
    public int run(String... args) throws IOException {
        String topic = "dragons and wizards";
        String style = "fantasy";
        String audience = "young adults";

        Log.infof("Generate a novel about %s in style %s and for %s audience", topic, style, audience);
        String novel = supervisorStoryCreator.write(topic, style, audience);

        Log.infof("Final novel: %s", novel);

        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(SupervisorExample.class, args);
    }
}
