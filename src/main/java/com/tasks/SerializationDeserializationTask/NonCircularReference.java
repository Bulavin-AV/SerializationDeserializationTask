package com.tasks.SerializationDeserializationTask;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Class for checking references.
 * *<b>foundFields</b> store fiealds, which can resolve circular reference
 * if there's circular refer∟ence
 *
 * @author Andrey Bulavin
 * @version 1.0
 * @throws CircularReferenceException
 */

public class NonCircularReference {
    private List<Object> foundFields = new ArrayList<>();


    /**
     * Method check current object and its parents for availability circular reference
     * Using reflection and superclass
     */
    public void NonCircularReferenceAllowed(Object bean) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> current = bean.getClass();
        foundFields.add(current);//add current class to list of fields
        while (current.getSuperclass() != null) { // don't process after Object.class
            Field[] beanFields = current.getDeclaredFields();
            for (Field field : beanFields) {
                if (!field.getType().isPrimitive() && !field.getType().getPackage()
                        .getName().startsWith("java"))// name starts with "java" is prohibited package name
                {
                    if (foundFields.contains(field.getType())) {


                        try {
                            throw new CircularReferenceException();
                        } catch (CircularReferenceException e) {
                            e.printStackTrace();
                            return;
                        }

                    } else {
                        foundFields.add(field.getType());

                        Class ClassOfField = Class.forName(field.getType().getName());
                        Object nextObject = ClassOfField.newInstance();

                        NonCircularReferenceAllowed(nextObject);
                    }
                }

            }
            current = current.getSuperclass(); //get parent class from current object
        }
    }
}