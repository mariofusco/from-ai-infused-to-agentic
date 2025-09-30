package a2aserver;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreativeWriterProducer {

    @Inject
    ChatModel model;

    @Produces
    public CreativeWriter creativeWriter() {
        return AiServices.builder(CreativeWriter.class)
                .chatModel(model)
                .build();
    }
}
