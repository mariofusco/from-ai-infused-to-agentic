package dev.langchain4j.quarkus.agentic.talk.stage1;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(chatMemoryProviderSupplier = RegisterAiService.NoChatMemoryProviderSupplier.class)
public interface CreativeWriter {

    @UserMessage("""
                You are a creative writer.
                Generate a draft of a story long no more than 3 sentence around the given topic.
                Return only the story and nothing else.
                The topic is {topic}.
                """)
    String generateNovel(String topic);

}
