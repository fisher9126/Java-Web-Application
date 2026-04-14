import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import re.edu.config.WebConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // Cấu hình multipart cho DispatcherServlet
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                null,               // thư mục tạm (null = mặc định của container)
                5242880,            // max file size (5MB)
                20971520,           // max request size (20MB)
                0                   // file size threshold
        );
        registration.setMultipartConfig(multipartConfig);

    }
}