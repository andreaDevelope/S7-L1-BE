package it.epicode.S7_L1_BE.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {
    private String message;
    private HttpStatus statusCode;
}
