package com.example.orderservice.customstatus;

import com.example.orderservice.dto.CustomStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorStatus implements CustomStatus {
    private int statusCode;
    private String statusMessage;

    public ErrorStatus(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
