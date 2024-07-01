package org.receiver.messaging.consumer;

import org.receiver.model.dto.CustomMessageDto;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumer {

    @KafkaListener(topics = "primaryMessages", groupId = "${kafka.group-id}")
    void primaryMessage(CustomMessageDto dto);

    @KafkaListener(topics = "secondaryMessages", groupId = "${kafka.group-id}")
    void secondaryMessage(CustomMessageDto dto);
}
