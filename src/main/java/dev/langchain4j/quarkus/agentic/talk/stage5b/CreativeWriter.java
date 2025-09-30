package dev.langchain4j.quarkus.agentic.talk.stage5b;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.agentic.declarative.ChatModelSupplier;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import io.quarkiverse.langchain4j.ModelName;
import io.quarkus.arc.Arc;

public interface CreativeWriter {

    @UserMessage("""
                You are a creative writer.
                Generate a draft of a story long no more than 3 sentences around the given topic.
                Return only the story and nothing else.
                The topic is {topic}.
                """)
    @Agent("Generate a story based on the given topic")
    String generateStory(String topic);

    @ChatModelSupplier
    static ChatModel chatModel() {
        return Arc.container().instance(ChatModel.class, ModelName.Literal.of("creative")).get();
    }
}
