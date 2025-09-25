package dev.langchain4j.quarkus.agentic.talk.stage1;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;

import java.io.IOException;

@ActivateRequestContext
public class PromptChainingExample implements QuarkusApplication {

    @Inject
    CreativeWriter creativeWriter;

    @Inject
    StyleEditor styleEditor;

    @Inject
    AudienceEditor audienceEditor;

    @Override
    public int run(String... args) throws IOException {
        String topic = "dragons and wizards";
        String style = "fantasy";
        String audience = "young adults";

        Log.infof("Generate a novel about %s in style %s and for %s audience", topic, style, audience);
        String novel = creativeWriter.generateNovel(topic);
        Log.infof("First draft novel: %s", novel);
        novel = styleEditor.editNovel(novel, style);
        Log.infof("Novel in style %s: %s", style, novel);
        novel = audienceEditor.editNovel(novel, audience);
        Log.infof("Final novel: %s", novel);

        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(PromptChainingExample.class, args);
    }
}
