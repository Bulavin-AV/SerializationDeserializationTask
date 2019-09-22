package com.tasks.SerializationDeserializationTask;

public class CircularReferenceException extends Exception {

    CircularReferenceException() {
        super("Circular Reference not allowed");
    }
}
