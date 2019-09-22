package com.tasks.SerializationDeserializationTask;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface SuperEncoder {
    String serialize(Object anyBean) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException;

    Object deserialize(String data) throws IOException, ClassNotFoundException;
}
