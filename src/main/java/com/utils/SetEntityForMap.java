package com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 将request 传来的Map 直接设置实体类
 *
 * @author zhaos
 * @create 2019-05-13-19:06
 */
public class SetEntityForMap {
    private static final Logger log = LoggerFactory.getLogger(SetEntityForMap.class);

    /**
     * 根据提交的表单 设置实体值
     */
    private static void set(HttpServletRequest request, Object model, Boolean defultColumnSet, Boolean inserFlg) {

        Map<String, String[]> properties = request.getParameterMap();

        Field[] field = model.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组
        Class clazz = model.getClass();
        for (int j = 0; j < field.length; j++) { //遍历所有属性
            String name = field[j].getName(); //获取属性的名字

            //System.out.println("attribute name:" + name);
            //name = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString(); //获取属性的类型
            if ("class java.lang.String".equals(type)) { //如果type是类类型，则前面包含"class "，后面跟类名
                /*Method m = model.getClass().getMethod("get" + name);
                String value = (String) m.invoke(model); //调用getter方法获取属性值
                if (value != null) {

                    System.out.println("attribute value:" + value);
                }*/
                PropertyDescriptor pd = null;
                try {
                    pd = new PropertyDescriptor(name, clazz);
                } catch (IntrospectionException e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
                Method setMethod = pd.getWriteMethod();
                if (setMethod != null && properties.containsKey(name)) {
                    try {
                        setMethod.invoke(model, getStringForList(properties.get(name)));
                    } catch (IllegalAccessException e) {
                        log.error(e.getMessage());
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        log.error(e.getMessage());
                        e.printStackTrace();
                    }
                    //System.out.println("attribute value:" + value);
                }
                if (defultColumnSet) {
                    setDefualtColumn(request, model, setMethod, name, inserFlg);
                }
            }
            /*if (type.equals("class java.lang.Integer")) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                if (value != null) {
                    System.out.println("attribute value:" + value);
                }
            }
            if (type.equals("class java.lang.Short")) {
                Method m = model.getClass().getMethod("get" + name);
                Short value = (Short) m.invoke(model);
                if (value != null) {
                    System.out.println("attribute value:" + value);
                }
            }
            if (type.equals("class java.lang.Double")) {
                Method m = model.getClass().getMethod("get" + name);
                Double value = (Double) m.invoke(model);
                if (value != null) {
                    System.out.println("attribute value:" + value);
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = model.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(model);
                if (value != null) {
                    System.out.println("attribute value:" + value);
                }
            }
            if (type.equals("class java.util.Date")) {
                Method m = model.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(model);
                if (value != null) {
                    System.out.println("attribute value:" + value.toLocaleString());
                }
            }*/
        }
    }

    /**
     * 根据传的表单设置实体的值。
     *
     * @param request 请求
     * @param model   实体类
     */
    public static void set(HttpServletRequest request, Object model) {
        set(request, model, false, false);
    }

    /**
     * 根据传的表单设置实体的值。新增时填写默认字段
     *
     * @param request 请求
     * @param model   实体类
     */
    public static void setForInsert(HttpServletRequest request, Object model) {
        set(request, model, true, false);
    }


    /**
     * 根据传的表单设置实体的值。修改时修改默认字段
     *
     * @param request 请求
     * @param model   实体类
     */
    public static void setForUpdate(HttpServletRequest request, Object model) {
        set(request, model, true, true);
    }

    private static String getStringForList(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        String rs = "";
        for (String s : strs) {
            rs += s;
        }
        return rs;
    }

    /**
     * 设置默认字段
     */
    private static void setDefualtColumn(HttpServletRequest request, Object model, Method setMethod, String name, Boolean update) {
        if (setMethod != null) {
            String id = request.getParameter("token");
            try {
                if (update) {

                    switch (name) {
                        case "lastUpdateTime":
                            setMethod.invoke(model, DateFormatUtils.getCurrentDateString());

                            break;
                        case "lastUpdateId":
                            setMethod.invoke(model, id);

                            break;
                        default:
                            break;
                    }

                } else {

                    switch (name) {
                        case "createdTime":
                            setMethod.invoke(model, DateFormatUtils.getCurrentDateString());
                            break;

                        case "createrId":
                            setMethod.invoke(model, id);

                            break;
                        case "lastUpdateTime":
                            setMethod.invoke(model, DateFormatUtils.getCurrentDateString());

                            break;
                        case "lastUpdateId":
                            setMethod.invoke(model, id);
                            break;
                        case "id":
                            setMethod.invoke(model, UUIDUtils.generate());
                            break;
                        default:
                            break;
                    }

                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                log.error(e.getMessage());

            }
        }


    }
}
