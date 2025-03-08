package com.example.userservice.customstatus;

import com.example.userservice.dto.CustomStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuccessStatus implements CustomStatus {
    private int statusCode;
    private String statusMessage;

    public SuccessStatus(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
