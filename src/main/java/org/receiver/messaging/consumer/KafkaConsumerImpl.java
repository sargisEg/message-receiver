package org.receiver.messaging.consumer;

import lombok.RequiredArgsConstructor;
import org.receiver.model.dto.CustomMessageDto;
import org.receiver.model.enums.MessageType;
import org.receiver.model.param.CreateCustomMessageParams;
import org.receiver.service.core.CustomMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class KafkaConsumerImpl implements KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    private final CustomMessageService customMessageService;

    @Override
    public void primaryMessage(CustomMessageDto dto) {
        Assert.notNull(dto, "dto should not be null");
        LOGGER.debug("Received primary message - {}", dto);
        customMessageService.create(new CreateCustomMessageParams(dto.getTitle(), dto.getContent(), MessageType.PRIMARY));
    }

    @Override
    public void secondaryMessage(CustomMessageDto dto) {
        Assert.notNull(dto, "dto should not be null");
        LOGGER.debug("Received secondary message - {}", dto);
        customMessageService.create(new CreateCustomMessageParams(dto.getTitle(), dto.getContent(), MessageType.SECONDARY));
    }
}
