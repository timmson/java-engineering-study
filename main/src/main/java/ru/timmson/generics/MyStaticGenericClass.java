package ru.timmson.generics;

public class MyStaticGenericClass {

    public static <T> T genericExample(Class<T> aClass) throws ReflectiveOperationException {
        return aClass.getDeclaredConstructor().newInstance();
    }

}
