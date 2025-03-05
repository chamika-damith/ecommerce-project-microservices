package com.example.productservice.customstatus;

import com.example.productservice.dto.CustomStatus;
import lombok.AllArgsConstructor;
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
