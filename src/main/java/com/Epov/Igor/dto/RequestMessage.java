package com.Epov.Igor.dto;

import lombok.Data;

@Data
public class RequestMessage {
    int requestCode;
    String message;

    public RequestMessage(int requestCode, String message) {
        this.requestCode = requestCode;
        this.message = message;
    }
}
