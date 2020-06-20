package cn.tst.gongnuan.common;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * 生成word文件工具�?
 * 
 * @author ps_lbin@pscp.co.jp
 */
public class FreeMarkerUtils {
    
    private static FreeMarkerUtils instance;
    
    private static Configuration configuration;
    
    public static FreeMarkerUtils getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        
        synchronized (FreeMarkerUtils.class) {
            if (instance != null) {
                return instance;
            }
            
            instance = new FreeMarkerUtils();
            instance.init();
        }
        return instance;
    }
    
    private void init() throws IOException {
        //创建配置实例 
        configuration = new Configuration();
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //模板文件统一放至 jp.co.pscp.material.materialmg.common.template 包下�?
        FileTemplateLoader ftl1 = new FileTemplateLoader(new File("C:\\tmp\\callcenter\\upload\\ftl"));
        ClassTemplateLoader ctl1 = new ClassTemplateLoader(getClass(), "");
        ClassTemplateLoader ctl2 = new ClassTemplateLoader(getClass(), "/template");
        TemplateLoader[] loaders = new TemplateLoader[]{ftl1, ctl1, ctl2};
        MultiTemplateLoader mtl = new MultiTemplateLoader(loaders);
        configuration.setTemplateLoader(mtl);
//        configuration.setClassForTemplateLoading(FreeMarkerUtils.class, "");
//        configuration.setClassForTemplateLoading(FreeMarkerUtils.class, "/template");
//        configuration.setDirectoryForTemplateLoading(new File("D:/tmp"));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }
    
    public File createWord(Map dataMap, String templateName, String filePath, String fileName) throws Exception {
        Writer out = null;
        try {
            //获取模板 
            Template template = configuration.getTemplate(templateName);

            //输出文件
            File outFile = new File(filePath + File.separator + fileName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }

            //将模板和数据模型合并生成文件 
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

            //生成文件
            template.process(dataMap, out);

            //关闭�?
            out.flush();
            out.close();
            return outFile;
        } catch (Exception e) {
            e.printStackTrace();
            if (out != null) {
                //关闭�?
                out.flush();
                out.close();
            }
            throw e;
        }
    }
}
