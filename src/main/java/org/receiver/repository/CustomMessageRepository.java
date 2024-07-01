package org.receiver.repository;

import org.receiver.model.entity.CustomMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMessageRepository extends JpaRepository<CustomMessage, Long> {
}
