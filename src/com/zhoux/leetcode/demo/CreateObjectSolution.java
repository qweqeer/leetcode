package com.zhoux.leetcode.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author:zhouxiang
 * @date:2020-06-13
 * @describe:
 * @status:
 */
public class CreateObjectSolution {

    public static Object createObject(String str) throws Exception{
        /**
         *
         */

        String interfaceName = str.substring(0,str.lastIndexOf("."));
        String name = interfaceName.substring(interfaceName.lastIndexOf(".")+1)+"$ch";

        String methodName = str.substring(str.lastIndexOf(".") + 1, str.indexOf("="));

        Object obj = createImpl(name, interfaceName);

        Field diled = obj.getClass().getField("name");





        return null;
    }

    private static Object createImpl(String name,String interName)
        throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String implPattern="package com.zhoux.leetcode.demo;"
            + "public class %s implements %s{"
            + " private String name;"
            + " public String getName(){"
            + "     return name;"
            + " }"
            + "}";
        String srcCode = String.format(implPattern,name,interName);

        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = jc.getStandardFileManager(null,null,null);
        JavaFileObject jfo = new StringJavaObject(name,srcCode);


        //编译参数，类似于javac <options>中的options
        List<String> optionsList = new ArrayList<String>();
        //编译文件的存放地方，注意：此处是为Eclipse工具特设的
//        optionsList.addAll(Arrays.asList("-d","./bin"));
        //要编译的单元
        List<JavaFileObject> jfos = Arrays.asList(jfo);
        //设置编译环境
        JavaCompiler.CompilationTask task = jc.getTask(null, fileManager, null, optionsList,null,jfos);
        //编译成功

        if(task.call()){
            System.out.println("类编译完成");
            return  Class.forName(name).newInstance();
        }
//        fileManager.getJavaFileObjects()
        //TODO 编译，加载
        return null;
    }

    public static void main(String[] args) {
//        IA.class.newInstance();

        System.out.println(CreateObjectSolution.class.getClassLoader().getResource("").getPath());
        System.out.println(IA.class.getName()+".getName=123");
    }

}



class StringJavaObject extends SimpleJavaFileObject {
    //源代码
    private String content = "";
    //遵循Java规范的类名及文件
    public StringJavaObject(String _javaFileName,String _content){
        super(_createStringJavaObjectUri(_javaFileName), Kind.SOURCE);
        content = _content;
    }
    //产生一个URL资源路径
    private static URI _createStringJavaObjectUri(String name){
        //注意此处没有设置包名
        return URI.create("String:///" + name + Kind.SOURCE.extension);
    }
    //文本文件代码
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
        throws IOException {
        return content;
    }
}
