package com.datatables.demo.exceptions;

public class DatatablesDemoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatatablesDemoException(String message) {
        super(message);
    }

    public DatatablesDemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatatablesDemoException(Throwable cause) {
        super(cause);
    }

}