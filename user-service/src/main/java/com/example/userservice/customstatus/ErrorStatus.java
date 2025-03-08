package com.example.userservice.customstatus;

import com.example.userservice.dto.CustomStatus;
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
