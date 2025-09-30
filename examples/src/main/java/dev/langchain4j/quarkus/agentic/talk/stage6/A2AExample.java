package dev.langchain4j.quarkus.agentic.talk.stage6;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;

@ActivateRequestContext
public class A2AExample implements QuarkusApplication {

    @Inject
    SequenceStoryCreator sequenceStoryCreator;

    @Override
    public int run(String... args) {
        String topic = "dragons and wizards";
        String style = "comedy";

        Log.infof("Generate a novel about %s in style %s", topic, style);
        String novel = sequenceStoryCreator.write(topic, style);

        Log.infof("Final novel: \n----------\n%s\n ----------",  novel);

        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(A2AExample.class, args);
    }
}
