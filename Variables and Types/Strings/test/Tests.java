import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Tests {
    public static String exampleSolution(String name) {
        // Implement the correct solution here
        return "Hello " + name + "!";
    }

    Object[][] valuesToCheck = {
            new Object[]{"John"}, // List the inputs to check here
            new Object[]{"Randall Munroe"},
            new Object[]{"Woodie Flowers"},
            new Object[]{"Gary"},
            new Object[]{"Jumpy"}
    };

    @Test
    public void testSolution() {
        // Check the parameter and return types
        Class testClass = Tests.class;
        Method exampleMethod = null;
        Class[] expectedParameters = new Class[0];
        Class expectedReturnType = null;

        Class taskClass = Task.class;
        Method solutionMethod = null;
        Class[] parameters = new Class[0];
        Class returnType = null;

        boolean exampleFound = false;
        for(Method method : testClass.getMethods()) {
            if(method.getName().equals("exampleSolution")) {
                exampleFound = true;
                expectedParameters = method.getParameterTypes();
                expectedReturnType = method.getReturnType();
                exampleMethod = method;
            }
        }
        Assert.assertTrue("Example solution is not defined", exampleFound);

        boolean solutionFound = false;
        for(Method method : taskClass.getMethods()) {
            if(method.getName().equals("solution")) {
                solutionFound = true;
                parameters = method.getParameterTypes();
                returnType = method.getReturnType();
                solutionMethod = method;
            }
        }
        Assert.assertTrue("Solution was not found, has it been renamed?", solutionFound);

        Assert.assertArrayEquals("The type or number of parameters your solution expects is incorrect", expectedParameters, parameters);
        Assert.assertEquals("The type of variable your solution returns is incorrect", expectedReturnType, returnType);

        for(int i = 0; i < valuesToCheck.length; i++) {
            Object[] inputArr = valuesToCheck[i];
            String testNumber = (i + 1) + "/" + valuesToCheck.length;
            System.out.println("Test " + testNumber + ": " + Arrays.toString(inputArr));

            String failMessage = "Test " + testNumber + " failed. The parameters were: " + Arrays.toString(inputArr);
            try {
                Assert.assertEquals(
                        failMessage,
                        exampleMethod.invoke(null, inputArr),
                        solutionMethod.invoke(null, inputArr)
                );
            } catch (IllegalAccessException | InvocationTargetException e) {
                java.lang.StackTraceElement element = null;
                for (java.lang.StackTraceElement el : e.getCause().getStackTrace()) {
                    if (el.getClassName().equals("Task")) {
                        element = el;
                        break;
                    }
                }
                if (element == null) {
                    Assert.fail("Your program threw an exception:\n" + e.getCause().toString() + "\nbut the line number could not be determined");
                } else {
                    Assert.fail("Your program threw an exception:\n" + e.getCause().toString() + "\non line " + element.getLineNumber());
                }
            }
        }
    }
}