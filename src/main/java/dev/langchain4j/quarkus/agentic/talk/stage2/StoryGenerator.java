package dev.langchain4j.quarkus.agentic.talk.stage2;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;

@RegisterAiService
public interface StoryGenerator {
    @UserMessage("""
     Write a short story about {topic} for a {audience} in a {style} style.
     Makes sure you use the given tools to write the story and adapt it to the 
     audience and style.
     """)
    @ToolBox({CreativeWriter.class, StyleEditor.class, AudienceEditor.class})
    String generate(String topic, String style, String audience);
}
