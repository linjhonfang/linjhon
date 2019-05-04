package com.linjhon.myspringboot.python;


import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.Properties;

public class JythonTest {

    public static void main(String[] args) {
        //以下初始化操作不可少
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        //
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("C:\\python\\20190503.py");

        PyFunction pyFunction = interpreter.get("add", PyFunction.class); // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyObject pyObject = pyFunction.__call__(new PyInteger(2), new PyInteger(4)); // 调用函数

        System.out.println(pyObject);

        interpreter.execfile("C:\\python\\20190504.py");
    }

}
