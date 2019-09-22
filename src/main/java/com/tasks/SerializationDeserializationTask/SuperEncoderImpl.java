package com.tasks.SerializationDeserializationTask;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serialize/Deserialize class.
 *
 * @author Andrey Bulavin
 * @version 1.0
 */
public class SuperEncoderImpl implements SuperEncoder {

    private List<Object> foundFields = new ArrayList<>();
    private String serializationStr = null;
    private StringBuilder StrBuilder = new StringBuilder();
    private Object mainBean;
    private int counterOfEntry = 1;

    @Override
    public String serialize(Object bean) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (counterOfEntry == 1) {
            mainBean = bean;
            counterOfEntry++;
        }
        Class<?> current = bean.getClass();
        StrBuilder.append("<object_type= " + current.getSimpleName() + ">");
        foundFields.add(current);//add current class to list of fields

        while (current.getSuperclass() != null) { // don't process after Object.class
            Field[] beanFields = current.getDeclaredFields();
            for (Field field : beanFields) {
                field.setAccessible(true);
                if (!field.getType().isPrimitive() && !field.getType().getPackage()
                        .getName().startsWith("java"))// name starts with "java" is prohibited package name
                {
                    if (foundFields.contains(field.getType())) {
                        try {
                            throw new CircularReferenceException();
                        } catch (CircularReferenceException e) {
                            e.printStackTrace();
//                            return;
                            break;
                        }

                    } else {
                        foundFields.add(field.getType());

                        StrBuilder.append("<property_type= " + field.getType().getSimpleName() + " identifier="
                                + field.getName() + ">");

                        Class<?> ClassOfField = Class.forName(field.getType().getName());
                        Object nextObject = ClassOfField.newInstance();
                        serialize(nextObject);
                    }
                } else {
//                         System.out.println(field.get(bean));
                    StrBuilder.append("<property_type= " + field.getType().getSimpleName() + " identifier="
                            + field.getName() + ">" + field.get(bean) + "</property_type>");
                }

            }
            current = current.getSuperclass(); //get parent class from current object
        }
        return StrBuilder.toString();

    }

    @Override
    public Object deserialize(String data) throws IOException, ClassNotFoundException {

        Object deserializeObject = null;
//
//            ByteArrayInputStream byteArrayInputStream = null;
//            ObjectInputStream objectInputStream = null;
//
//            try {
//                byteArrayInputStream = new ByteArrayInputStream(data);
//                objectInputStream = new ObjectInputStream(byteArrayInputStream);
//
//                deserializeObject = objectInputStream.readObject();
//
//            } finally {
//                if (objectInputStream != null) {
//                    objectInputStream.close();
//                }
//
//                if (byteArrayInputStream != null) {
//                    byteArrayInputStream.close();
//                }
//            }
//            return deserializeObject;
//        }
        return deserializeObject;
    }
}
