package hw_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class TestApp {

    public static void start(Class c) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Constructor constructor = c.getConstructor();
        Object refObj = constructor.newInstance();



        int NumberBeforeSuite = 0;
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if(++NumberBeforeSuite > 1) {
                    throw new RuntimeException("В классе два метода с аннотацией BeforeSuite");
                } else
                    method.invoke(refObj);

            }
        }

        Map<Integer, Method> sortMethods = new TreeMap<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                int runPriValue = annotation.runPriority();
                sortMethods.put(runPriValue, method);
            }
        }
        for (Map.Entry<Integer, Method> integerMethodEntry : sortMethods.entrySet()) {
            integerMethodEntry.getValue().invoke(refObj);
        }



        int NumberAfterSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if(++NumberAfterSuite > 1) {
                    throw new RuntimeException("В классе два метода с аннотацией AfterSuite");
                } else
                    method.invoke(refObj);
            }
        }



    }


}
