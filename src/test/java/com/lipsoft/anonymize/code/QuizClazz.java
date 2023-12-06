package com.lipsoft.anonymize.code;

class Person {
    Person(String name, int i) {
        ++pid;
        this.name=name;
        age=1;
    }
    static int pid;
    int age;
    String name;
}

public class QuizClazz {
    int a = 10;
    private int privateA = 10;

    class nestedQuizClazz {
        private void method2() {
            System.out.println(privateA);
        }
    }

    static {
        System.out.println("pam");
    }

    static void testClazz() {
        System.out.println("testClazz");
    }

    public static String toStrin2g() {
        System.out.println("Test toString called");
        return "";
    }

    public static void main(String args[]) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 is:" + (s1 == s2));

        QuizClazz quizClazz = new QuizClazz();
        quizClazz.print(6);
        quizClazz.print(5);

        System.out.println(quizClazz.a);
    }

    private void print(int a) {
//        for (int a = 0; a < 5; a++) {
//
//        }

        a = 8;
        System.out.println(a + " ");
    }



}
