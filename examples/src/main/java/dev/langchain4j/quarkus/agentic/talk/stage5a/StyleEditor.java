package dev.langchain4j.quarkus.agentic.talk.stage5a;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.agentic.declarative.ChatModelSupplier;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.ModelName;
import io.quarkus.arc.Arc;

public interface StyleEditor {

    @UserMessage("""
                You are a professional editor.
                Analyze and rewrite the following story to better fit and be more coherent with the {style} style.
                Return only the story and nothing else.
                The story is "{story}".
                """)
    @Agent("Edit a story to better fit a given style")
    String editStoryInStyle(String story,String style);

    @ChatModelSupplier
    static ChatModel chatModel() {
        return Arc.container().instance(ChatModel.class, ModelName.Literal.of("style")).get();
    }
}
