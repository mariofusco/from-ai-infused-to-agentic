package dev.langchain4j.quarkus.agentic.talk.stage2;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(chatMemoryProviderSupplier = RegisterAiService.NoChatMemoryProviderSupplier.class)
public interface AudienceEditor {

    @UserMessage("""
            You are a professional editor.
            Analyze and rewrite the following short novel to better align with the target audience of {audience}.
            Return only the novel and nothing else. 
            The novel is "{novel}".
            """)
    @Tool("Edit a novel for a specific audience")
    String editNovelForAudience(String novel, String audience);

}
