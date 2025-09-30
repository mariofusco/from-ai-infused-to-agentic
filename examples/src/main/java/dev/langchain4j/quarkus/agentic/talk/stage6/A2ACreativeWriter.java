package dev.langchain4j.quarkus.agentic.talk.stage6;

import dev.langchain4j.agentic.declarative.A2AClientAgent;
import dev.langchain4j.service.V;

public interface A2ACreativeWriter {

    @A2AClientAgent(a2aServerUrl = "http://localhost:8081", outputName = "story")
    String generateStory(String topic);
}
