package dev.langchain4j.quarkus.agentic.talk.stage6;

import dev.langchain4j.agentic.declarative.SequenceAgent;
import dev.langchain4j.agentic.declarative.SubAgent;
import dev.langchain4j.quarkus.agentic.talk.stage5b.StyleReviewLoopAgent;

public interface SequenceStoryCreator {
    @SequenceAgent(outputName = "story", subAgents = {
            @SubAgent(type = A2ACreativeWriter.class, outputName = "story"),
            @SubAgent(type = StyleReviewLoopAgent.class, outputName = "story")
    })
    String write(String topic, String style);
}
