package it.epicode.S5_L5_BE.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException() {
    }
    public AlreadyExistsException(String message) {
        super(message);
    }
}
