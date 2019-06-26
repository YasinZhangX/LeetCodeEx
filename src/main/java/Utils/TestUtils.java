package Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class TestUtils {

    private Class<?> cls;
    private Method[] methods;

    private List<Method> callMethodList;
    private List<Object[]> paramsList;


    public TestUtils(Class<?> cls, String callMethods, String callParams) {
        this.cls = cls;
        this.methods = cls.getDeclaredMethods();
        callMethodList = getCallMethods(callMethods);
        paramsList = getParamsList(callParams);
    }

    private List<Method> getCallMethods(String callMethods) {
        List<Method> callMethodList = new ArrayList<>();

        String[] methods = callMethods.substring(1, callMethods.length()-1).split(",");
        for (String methodName : methods) {
            callMethodList.add(getMethodByName(methodName));
        }

        return callMethodList;
    }

    private Method getMethodByName(String methodName) {
        for (Method method : methods) {
            if (method.getName().equals(methodName.substring(1, methodName.length()-1))) {
                return method;
            }
        }

        return null;
    }

    private List<Object[]> getParamsList(String callParams) {
        List<Object[]> paramsList = new ArrayList<>();

        String[] callParamsForSignalMethod = callParams.substring(1, callParams.length()-1).split(",");
        for (String paramString : callParamsForSignalMethod) {
            String[] paramStrings = paramString.substring(1, paramString.length()-1).split(",");
            paramsList.add(getParamObjects(paramStrings));
        }

        return paramsList;
    }

    private Object[] getParamObjects(String[] paramStrings) {
        List<Object> objectList = new ArrayList<>();
        for (String paramString : paramStrings) {
            if (paramString.length() == 0) {
                continue;
            }
            objectList.add(Integer.parseInt(paramString));
        }

        return objectList.toArray(new Object[0]);
    }

    public String call() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (callMethodList.size() != paramsList.size()-1) {
            throw new RuntimeException("参数数目错误");
        }

        Object[] constructorParams = paramsList.get(0);
        Class<?>[] constructorParamClasses = new Class[constructorParams.length];
        for (int i = 0; i < constructorParams.length; i++) {
            if (constructorParams[i] instanceof Void) {
                constructorParamClasses[i] = Void.class;
            } else if (constructorParams[i] instanceof Integer) {
                constructorParamClasses[i] = int.class;
            }
        }
        Constructor constructor = cls.getDeclaredConstructor(constructorParamClasses);
        Object obj = constructor.newInstance(constructorParams);
        paramsList.remove(0);

        int size = callMethodList.size();
        for (int i = 0; i < size; i++) {
            Object ret = callMethodList.get(i).invoke(obj, paramsList.get(i));
            sb.append("[");
            if (ret instanceof Integer) {
                sb.append(ret);
            }
            sb.append("]");
            if (i != size-1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();

    }
}
