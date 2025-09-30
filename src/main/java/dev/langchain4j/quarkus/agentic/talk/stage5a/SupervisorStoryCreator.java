package dev.langchain4j.quarkus.agentic.talk.stage5a;

import dev.langchain4j.agentic.declarative.SubAgent;
import dev.langchain4j.agentic.declarative.SupervisorAgent;
import dev.langchain4j.agentic.declarative.SupervisorRequest;
import dev.langchain4j.agentic.supervisor.SupervisorResponseStrategy;
import dev.langchain4j.service.V;

public interface SupervisorStoryCreator {

    @SupervisorAgent(outputName = "story", responseStrategy = SupervisorResponseStrategy.LAST, subAgents = {
            @SubAgent(type = CreativeWriter.class, outputName = "story"),
            @SubAgent(type = AudienceEditor.class, outputName = "story"),
            @SubAgent(type = StyleEditor.class, outputName = "story")
    })
    String write(String topic,String audience,String style);

    @SupervisorRequest
    static String request(String topic, String audience, String style) {
        return "Write a story about " + topic + " in " + style + " style for " + audience + " audience.";
    }
}
