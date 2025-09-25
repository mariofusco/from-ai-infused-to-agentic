package dev.langchain4j.quarkus.agentic.talk.stage2;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(chatMemoryProviderSupplier = RegisterAiService.NoChatMemoryProviderSupplier.class)
public interface StyleEditor {

    @UserMessage("""
            You are a professional editor.
            Analyze and rewrite the following short novel to better fit and be more coherent with the {style} style.
            Return only the novel and nothing else. 
            The novel is "{novel}".
            """)
    @Tool("Edit a novel to better fit a specific style")
    String editNovelInStyle(String novel, String style);

}
