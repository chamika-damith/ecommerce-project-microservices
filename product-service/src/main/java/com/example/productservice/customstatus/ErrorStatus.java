package com.example.productservice.customstatus;

import com.example.productservice.dto.CustomStatus;
import lombok.AllArgsConstructor;
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
