package com.tietoevry.hike.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CannotConvertToTargetObjectException extends RuntimeException {
    public CannotConvertToTargetObjectException(JsonProcessingException e) {
    }
}
