package dev.langchain4j.quarkus.agentic.talk.stage5b;

import dev.langchain4j.agentic.declarative.SubAgent;
import dev.langchain4j.agentic.declarative.SupervisorAgent;
import dev.langchain4j.agentic.declarative.SupervisorRequest;
import dev.langchain4j.agentic.supervisor.SupervisorResponseStrategy;
import dev.langchain4j.service.V;

public interface SupervisorStoryCreator {
    @SupervisorAgent(outputName = "story", responseStrategy = SupervisorResponseStrategy.LAST, subAgents = {
            @SubAgent(type = CreativeWriter.class, outputName = "story"),
            @SubAgent(type = StyleReviewLoopAgent.class, outputName = "story")
    })
    String write(@V("topic") String topic, @V("style") String style);

    @SupervisorRequest
    static String request(@V("topic") String topic, @V("style") String style) {
        return "Write a story about " + topic + " and then adapt it for " + style + " style";
    }

}
