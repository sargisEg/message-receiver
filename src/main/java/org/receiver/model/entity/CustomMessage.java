package org.receiver.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.receiver.model.enums.MessageType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOM_MESSAGES")
public class CustomMessage {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CUSTOM_MESSAGES_ID_SEQ"
    )
    @SequenceGenerator(name = "CUSTOM_MESSAGES_ID_SEQ")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MessageType type;

    public CustomMessage(String title, String content, MessageType type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }
}
