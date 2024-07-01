package org.receiver.service.impl;

import lombok.RequiredArgsConstructor;
import org.receiver.mapper.CustomMessageMapper;
import org.receiver.model.entity.CustomMessage;
import org.receiver.model.param.CreateCustomMessageParams;
import org.receiver.repository.CustomMessageRepository;
import org.receiver.service.core.CustomMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomMessageServiceImpl implements CustomMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomMessageServiceImpl.class);

    private final CustomMessageRepository customMessageRepository;
    private final CustomMessageMapper customMessageMapper;

    @Override
    public CustomMessage create(CreateCustomMessageParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.debug("Creating custom message with params - {}", params);

        final CustomMessage message = customMessageRepository.save(customMessageMapper.mapToEntity(params));

        LOGGER.debug("Successfully created custom message with params - {}, result - {}", params, message);
        return message;
    }

    @Override
    public Optional<CustomMessage> findById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.debug("Finding message with id - {}", id);

        final Optional<CustomMessage> optionalCustomMessage = customMessageRepository.findById(id);

        LOGGER.debug("Successfully found message with id - {}, result - {}", id, optionalCustomMessage);
        return optionalCustomMessage;
    }

    @Override
    public List<CustomMessage> findAll() {
        LOGGER.debug("Finding all messages");

        final List<CustomMessage> messages = customMessageRepository.findAll();

        LOGGER.debug("Successfully found all messages");
        return messages;
    }

    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.debug("Deleting message with id - {}", id);

        customMessageRepository.deleteById(id);

        LOGGER.debug("Successfully deleted message with id - {}", id);
    }
}
