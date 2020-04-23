package Servlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TemplateEngine {
    Configuration config;
    public TemplateEngine(String root_path) throws IOException {
        config = new Configuration(Configuration.VERSION_2_3_28){{
            setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
            setDirectoryForTemplateLoading(new File(root_path));
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setLogTemplateExceptions(false);
            setWrapUncheckedExceptions(true);
        }};
    }

    public static TemplateEngine folder(String root_path) throws IOException {
        return new TemplateEngine(root_path);
    }

    public void render(String templateFile, HashMap<String,Object> data, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        try (PrintWriter w = resp.getWriter()){
            config.getTemplate(templateFile).process(data,w);
        } catch (TemplateException | IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Freemarker error!");
        }
    }

    
}
