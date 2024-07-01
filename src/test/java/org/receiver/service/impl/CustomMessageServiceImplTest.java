package org.receiver.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.receiver.mapper.CustomMessageMapper;
import org.receiver.model.entity.CustomMessage;
import org.receiver.model.enums.MessageType;
import org.receiver.model.param.CreateCustomMessageParams;
import org.receiver.repository.CustomMessageRepository;
import org.receiver.service.core.CustomMessageService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomMessageServiceImplTest {

    @Mock
    private CustomMessageRepository customMessageRepository;

    @Mock
    private CustomMessageMapper customMessageMapper;

    private CustomMessageService testSubject;

    @BeforeEach
    public void init() {
        testSubject = new CustomMessageServiceImpl(customMessageRepository, customMessageMapper);
    }

    @Test
    public void testCreateWhenParamsIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.create(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreate() {
        final CreateCustomMessageParams params = new CreateCustomMessageParams("title", "content", MessageType.SECONDARY);

        when(customMessageMapper.mapToEntity(params))
                .thenReturn(new CustomMessage());

        when(customMessageRepository.save(new CustomMessage()))
                .thenReturn(new CustomMessage());

        Assertions.assertThat(testSubject.create(params))
                        .isEqualTo(new CustomMessage());

        verify(customMessageMapper).mapToEntity(params);
        verify(customMessageRepository).save(new CustomMessage());

        verifyNoMoreInteractions(customMessageMapper, customMessageRepository);
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.findById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testFindByIdWhenMessageNotFound() {
        when(customMessageRepository.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThat(testSubject.findById(1L))
                        .isEqualTo(Optional.empty());

        verify(customMessageRepository).findById(1L);

        verifyNoMoreInteractions(customMessageMapper, customMessageRepository);
    }

    @Test
    public void testFindById() {
        when(customMessageRepository.findById(1L))
                .thenReturn(Optional.of(new CustomMessage()));

        Assertions.assertThat(testSubject.findById(1L))
                        .isEqualTo(Optional.of(new CustomMessage()));

        verify(customMessageRepository).findById(1L);

        verifyNoMoreInteractions(customMessageMapper, customMessageRepository);
    }

    @Test
    public void testFindAll() {
        when(customMessageRepository.findAll())
                .thenReturn(List.of(new CustomMessage()));

        Assertions.assertThat(testSubject.findAll())
                        .isEqualTo(List.of(new CustomMessage()));

        verify(customMessageRepository).findAll();

        verifyNoMoreInteractions(customMessageMapper, customMessageRepository);
    }

    @Test
    public void testDeleteByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.deleteById(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testDeleteById() {

        testSubject.deleteById(1L);

        verify(customMessageRepository).deleteById(1L);

        verifyNoMoreInteractions(customMessageMapper, customMessageRepository);
    }
}