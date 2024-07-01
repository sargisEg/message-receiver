package org.receiver.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MessageType {

    PRIMARY("Primary"),
    SECONDARY("Secondary");

    private final String value;
}
