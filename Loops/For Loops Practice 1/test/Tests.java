import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.ArrayList;

public class Tests {
    public static int[] exampleSolution(int[] arr) {
        // Implement the correct solution here
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 2 * arr[i];
        }
        return arr;
    }

    Object[][] valuesToCheck = {
            new Object[]{new int[]{1, 2, 3}},
            new Object[]{new int[]{10, -4, 6, 0}},
            new Object[]{new int[]{11}},
            new Object[]{new int[]{-1, -7, -3}},
            new Object[]{new int[]{10, 5, 9, 4, 8, 3, 7, 2, 6, 1, 5, 0}},
    };

    public Object[] objectToArray(Object o) {
        if(o.getClass().getComponentType().isPrimitive()) {
            int len = Array.getLength(o);
            Object[] arr = new Object[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Array.get(arr, i);
            }
            return arr;
        } else {
            return (Object[]) o;
        }
    }

    public Object[] deepCloneArr(Object[] inArr) {
        Object[] out = new Object[inArr.length];
        for(int i = 0; i < inArr.length; i++) {
            if(inArr[i].getClass().getComponentType() != null && inArr[i].getClass().getComponentType().isPrimitive()) {
                out[i] = inArr[i];
            } else if(inArr[i].getClass() == ArrayList.class) {
                out[i] = ((ArrayList) inArr[i]).clone();
            } else if (inArr[i].getClass().isArray())
                out[i] = deepCloneArr(objectToArray(inArr[i]));
            else {
                out[i] = inArr[i];
            }
        }
        return out;
    }

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

            String failMessage = "Test " + testNumber + " failed. The parameters were: " + Arrays.deepToString(inputArr);
            try {
                if (returnType.isArray()) {
                    Assert.assertArrayEquals(
                            failMessage,
                            objectToArray(exampleMethod.invoke(null, inputArr)),
                            objectToArray(solutionMethod.invoke(null, inputArr))
                    );
                } else {
                    Assert.assertEquals(
                            failMessage,
                            exampleMethod.invoke(null, deepCloneArr(inputArr)),
                            solutionMethod.invoke(null, deepCloneArr(inputArr))
                    );
                }
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