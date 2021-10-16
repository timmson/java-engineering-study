package ru.timmson.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MyStaticGenericClassShould {

    @Test
    void example() throws ReflectiveOperationException {
        assertNotNull(MyStaticGenericClass.<String>genericExample(String.class));
    }
}