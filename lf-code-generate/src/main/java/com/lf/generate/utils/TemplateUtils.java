package com.lf.generate.utils;

import com.google.common.base.CaseFormat;
import com.lf.generate.entity.GenerateInfo;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author lufeifan
 */
public class TemplateUtils {

    public static ByteArrayOutputStream fillTemplate(GenerateInfo info, ByteArrayOutputStream outputStream){
        List<Template> templateList;
        try {
            templateList = TemplateUtils.initTemplate();
            for (Template template : templateList) {
                ZipOutputStream zip = new ZipOutputStream(outputStream);
//                String path = TemplateUtils.initPath(template, info.getPackageName(), info.getClassName());
//                zip.putNextEntry(new ZipEntry(path));
                template.process(info, new OutputStreamWriter(zip));
                zip.closeEntry();
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    /**
     *  模板位置
     **/
    public static List<Template> initTemplate() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setTemplateLoader(new ClassTemplateLoader(TemplateUtils.class, "/templates"));
        cfg.setDefaultEncoding("UTF-8");
        List<Template> list = new ArrayList<>();
        list.add(cfg.getTemplate("service.java.ftl"));
        list.add(cfg.getTemplate("entity.java.ftl"));
        list.add(cfg.getTemplate("serviceImpl.java.ftl"));
        list.add(cfg.getTemplate("mapper.java.ftl"));
        list.add(cfg.getTemplate("controller.java.ftl"));
        list.add(cfg.getTemplate("vue.java.ftl"));
        list.add(cfg.getTemplate("addOrUpdate.java.ftl"));
        list.add(cfg.getTemplate("api.java.ftl"));
        list.add(cfg.getTemplate("sql.java.ftl"));
        return list;
    }

    /**
     *  文件生成路径
     **/
    public static String initPath(Template template, String packageName, String className) {
        String name = template.getName();
        packageName = packageName.replace(".", File.separator);
        String path = null;
        switch (name) {
            case "service.java.ftl":
                path = "main" + File.separator + "java" + File.separator + packageName + File.separator + "service" + File.separator + className + "Service.java";
                break;
            case "entity.java.ftl":
                path = "main" + File.separator + "java" + File.separator + packageName + File.separator + "entity" + File.separator + className + ".java";
                break;
            case "serviceImpl.java.ftl":
                path = "main" + File.separator + "java" + File.separator + packageName + File.separator + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
                break;
            case "mapper.java.ftl":
                path = "main" + File.separator + "java" + File.separator + packageName + File.separator + "mapper" + File.separator + className + "Mapper.java";
                break;
            case "controller.java.ftl":
                path = "main" + File.separator + "java" + File.separator + packageName + File.separator + "controller" + File.separator + className + "Controller.java";
                break;
            case "vue.java.ftl":
                path = "main" + File.separator + "java" + File.separator + "resources" + File.separator + "vue" + File.separator + "views" +  File.separator + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,className) + File.separator + "index.vue";
                break;
            case "addOrUpdate.java.ftl":
                path = "main" + File.separator + "java" + File.separator + "resources" + File.separator + "vue" + File.separator + "views" + File.separator + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,className) + File.separator + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,className) + "-add-or-update.vue";
                break;
            case "api.java.ftl":
                path = "main" + File.separator + "java" + File.separator + "resources" + File.separator + "vue" + File.separator + "api" + File.separator + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,className) + ".js";
                break;
            case "sql.java.ftl":
                path = className + "Menu.sql";
                break;
        }
        return path;
    }
}