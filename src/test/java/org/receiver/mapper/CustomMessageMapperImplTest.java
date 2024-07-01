package org.receiver.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.receiver.model.entity.CustomMessage;
import org.receiver.model.enums.MessageType;
import org.receiver.model.param.CreateCustomMessageParams;

@ExtendWith(MockitoExtension.class)
class CustomMessageMapperImplTest {

    private CustomMessageMapper testSubject;

    @BeforeEach
    public void init() {
        testSubject = new CustomMessageMapperImpl();
    }

    @Test
    public void testMapToEntityWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.mapToEntity(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testMapToEntity() {
        final CreateCustomMessageParams params = new CreateCustomMessageParams("title", "content", MessageType.PRIMARY);
        Assertions.assertThat(testSubject.mapToEntity(params))
                .isEqualTo(new CustomMessage("title", "content", MessageType.PRIMARY));
    }

}