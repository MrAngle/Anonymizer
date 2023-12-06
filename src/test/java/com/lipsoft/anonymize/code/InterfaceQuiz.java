package com.lipsoft.anonymize.code;

public interface InterfaceQuiz extends Interface2, Interface3 {
    int x = 10;

    static void staticMethod() {
//        static {
//            System.out.println("inside method");
//        }
        System.out.println("staticMethod InterfaceQuiz");
    }
}
