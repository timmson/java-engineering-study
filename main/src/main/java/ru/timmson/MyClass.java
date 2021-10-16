package ru.timmson;

public class MyClass {

    public MyClass(final StringBuffer myVar) {
        myVar.reverse();
    }

    public static void main(String[] args) {
        final StringBuffer myVar = new StringBuffer("Hello, Mir Plat.form!");
        final var myClass = new MyClass(myVar);
        System.out.println(myVar.toString());
    }

}
