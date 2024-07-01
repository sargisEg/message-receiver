package org.receiver.mapper;

import org.receiver.model.entity.CustomMessage;
import org.receiver.model.param.CreateCustomMessageParams;

public interface CustomMessageMapper {

    CustomMessage mapToEntity(CreateCustomMessageParams params);
}
