package com.bingai.demo;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-17 11:41
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //1.上下文（数据模型）
        Context context = new Context();
        Map dataModel = new HashMap();
        dataModel.put("name","杂货铺电商系统");
        context.setVariables(dataModel);

        //2.准备文件
        File dest = new File("D:\\IdeaProjects\\project_others\\thymeleaf\\html\\test_out.html");
        PrintWriter printWriter = new PrintWriter(dest,"utf-8");

        //3.生成页面
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();//模板解析器
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setSuffix(".html");

        TemplateEngine engine = new TemplateEngine();//模板引擎
        engine.setTemplateResolver(templateResolver);

        engine.process("test",context,printWriter);

    }
}
