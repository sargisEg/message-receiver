package org.receiver.mapper;

import org.receiver.model.entity.CustomMessage;
import org.receiver.model.param.CreateCustomMessageParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CustomMessageMapperImpl implements CustomMessageMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomMessageMapperImpl.class);

    @Override
    public CustomMessage mapToEntity(CreateCustomMessageParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.trace("Mapping from - {} to CustomMessage entity", params);
        return new CustomMessage(params.getTitle(), params.getContent(), params.getType());
    }
}
