package dev.langchain4j.quarkus.agentic.talk.stage1;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.ModelName;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(
        modelName = "creative")
public interface CreativeWriter {

    @UserMessage("""
                You are a creative writer.
                Generate a draft of a story long no more than 3 sentences around the given topic.
                Return only the story and nothing else.
                The topic is {topic}.
                """)
    String generateNovel(String topic);

}
