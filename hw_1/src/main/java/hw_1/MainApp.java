package hw_1;

import java.lang.reflect.InvocationTargetException;

public class MainApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        A a = new A();
        B b = new B();
        Class classA = a.getClass();
        Class classB = b.getClass();

        TestApp.start(classA);
        System.out.println();
        TestApp.start(classB);
    }
}
