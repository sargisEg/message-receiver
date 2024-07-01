package org.receiver.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.receiver.model.enums.MessageType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomMessageParams {

    private String title;
    private String content;
    private MessageType type;
}
