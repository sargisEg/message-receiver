package org.receiver.messaging.consumer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.receiver.model.dto.CustomMessageDto;
import org.receiver.model.enums.MessageType;
import org.receiver.model.param.CreateCustomMessageParams;
import org.receiver.service.core.CustomMessageService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerImplTest {

    @Mock
    private CustomMessageService customMessageService;

    private KafkaConsumer testSubject;

    @BeforeEach
    public void init() {
        testSubject = new KafkaConsumerImpl(customMessageService);
    }

    @Test
    public void testPrimaryMessageWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.primaryMessage(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testSecondaryMessageWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.secondaryMessage(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testPrimaryMessage() {
        testSubject.primaryMessage(new CustomMessageDto());

        final CreateCustomMessageParams params = new CreateCustomMessageParams();
        params.setType(MessageType.PRIMARY);

        verify(customMessageService).create(params);

        verifyNoMoreInteractions(customMessageService);
    }

    @Test
    public void testSecondaryMessage() {
        testSubject.secondaryMessage(new CustomMessageDto());

        final CreateCustomMessageParams params = new CreateCustomMessageParams();
        params.setType(MessageType.SECONDARY);

        verify(customMessageService).create(params);

        verifyNoMoreInteractions(customMessageService);
    }
}