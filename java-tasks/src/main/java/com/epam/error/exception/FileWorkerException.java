package com.epam.error.exception;

public class FileWorkerException extends Exception {
    public FileWorkerException() {
    }
    public FileWorkerException(String message, Throwable exception) {
        super(message, exception);
    }

    public FileWorkerException(String message) {
        super(message);
    }

    public FileWorkerException(Throwable exception) {
        super(exception);
    }
}
