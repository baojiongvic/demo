package com.example.demo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 源程序名称：SingletonTest <br>
 * 软件著作权：恒生电子股份有限公司 版权所有 <br>
 * 系统名称：SEE2.0 <br>
 * 开发时间：2020/5/27 9:46 上午 <br>
 *
 * @author baojiong20176
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception{
        Class[] classes = {A.class, B.class};

        for (Class aClass : classes) {
            getBean(aClass);
        }
        System.out.println(singletonMap);;
    }

    public static Map<String, Object> singletonMap = new HashMap<>(2);

    public static <T> T getBean(Class<T> beanClass) throws Exception {
        String beanName = beanClass.getSimpleName().toLowerCase();
        if (singletonMap.containsKey(beanName)) {
            return (T) singletonMap.get(beanName);
        }

        Object object = beanClass.getDeclaredConstructor().newInstance();
        singletonMap.put(beanName, object);

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();

            field.set(object, singletonMap.containsValue(fieldBeanName) ? singletonMap.get(fieldBeanName) : getBean(fieldClass));
        }
        return (T) object;
    }

}
