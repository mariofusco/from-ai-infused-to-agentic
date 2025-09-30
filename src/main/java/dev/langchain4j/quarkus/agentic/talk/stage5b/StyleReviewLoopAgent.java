package dev.langchain4j.quarkus.agentic.talk.stage5b;

import dev.langchain4j.agentic.declarative.ExitCondition;
import dev.langchain4j.agentic.declarative.LoopAgent;
import dev.langchain4j.agentic.declarative.SubAgent;
import dev.langchain4j.service.V;

public interface StyleReviewLoopAgent {

    @LoopAgent(
            description = "Review and score the given story to ensure it aligns with the specified style",
            outputName = "story", maxIterations = 5,
            subAgents = {
                    @SubAgent(type = StyleScorer.class, outputName = "score"),
                    @SubAgent(type = StyleEditor.class, outputName = "story")
            }
    )
    String reviewAndScore(String story, String style);

    @ExitCondition
    static boolean exit(double score) {
        return score >= 0.8;
    }
}