package com.tasks.SerializationDeserializationTask;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        StringBuilder StringBuilder = new StringBuilder();

        Bean2 bean2 = new Bean2();
        bean2.setBean2propertyInt(322);
        Bean1 bean1 = new Bean1(bean2);
        List l = new ArrayList<String>();
        l.add("LIIIST111111");
        l.add("LIIIST2222");
        bean1.setPropertyList(l);
        bean1.setPropertyInt(4);
        bean1.setPropertyInteger(44);
        bean1.setPropertyBean2(bean2);
//        System.out.println(bean1.getPropertyBean2().getBean2propertyInt());
//        Class<?> current = bean1.getClass();
//        StringBuilder.append("<object_type=" + current.getSimpleName() + ">");
//        Field[] beanFields = current.getDeclaredFields();
//        for (Field field : beanFields) {
////            System.out.println(field.getType().getSimpleName());
////            Class ClassOfField = Class.forName(field.getType().getName());
//            if (!field.isAccessible()) {
//                field.setAccessible(true);
//
////            Field nfield = ClassOfField.getField(field.getName());
//                StringBuilder.append("<property_type=" + field.getType().getSimpleName() + ";identifier="
//                        + field.getName() + ">" + "!!!!" + field.get(bean1) + "????");
//            }
//        }
//        System.out.println(StringBuilder.toString());

        SuperEncoderImpl sei = new SuperEncoderImpl();
        String out = sei.serialize(bean1);
        System.out.println(out);
    }


}
