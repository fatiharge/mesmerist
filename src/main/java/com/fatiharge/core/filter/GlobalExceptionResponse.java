package com.fatiharge.core.filter;

public record GlobalExceptionResponse(String message, String reference, String exception
) {
    public static GlobalExceptionResponse fromException(Exception exception) {
        return new GlobalExceptionResponse(
                exception.getMessage( ) == null ? exception.getClass( ).getSimpleName( ) : exception.getMessage( ),
                exception.getClass( ).getName( ),
                exception.getClass( ).getSimpleName( )
        );
    }
}
