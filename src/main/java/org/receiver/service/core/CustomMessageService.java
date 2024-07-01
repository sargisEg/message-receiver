package org.receiver.service.core;

import org.receiver.model.entity.CustomMessage;
import org.receiver.model.param.CreateCustomMessageParams;

import java.util.List;
import java.util.Optional;

public interface CustomMessageService {

    CustomMessage create(CreateCustomMessageParams params);

    Optional<CustomMessage> findById(Long id);

    List<CustomMessage> findAll();

    void deleteById(Long id);
}
