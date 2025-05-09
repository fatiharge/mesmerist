package com.fatiharge.exception;

import com.fatiharge.core.abstracts.CustomRuntimeException;
import jakarta.ws.rs.core.Response;

public class NoDailyMenuException extends CustomRuntimeException {

    public NoDailyMenuException() {
        super("No daily menu found", Response.Status.NOT_FOUND);
    }
}