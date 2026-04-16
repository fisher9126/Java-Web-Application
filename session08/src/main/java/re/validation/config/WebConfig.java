package re.validation.config;


<<<<<<< HEAD
=======
import org.springframework.context.MessageSource;
>>>>>>> 72b6359 (mini-project)
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

=======
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
>>>>>>> 72b6359 (mini-project)
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

<<<<<<< HEAD
=======
import java.time.Duration;
import java.util.Locale;

>>>>>>> 72b6359 (mini-project)

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "re.validation")
<<<<<<< HEAD
public class WebConfig  {
=======
public class WebConfig implements WebMvcConfigurer {
>>>>>>> 72b6359 (mini-project)
    @Bean
   public SpringResourceTemplateResolver templateResolver(){
       SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
       templateResolver.setPrefix("/WEB-INF/");
       templateResolver.setSuffix(".html");
       templateResolver.setCharacterEncoding("UTF-8");
       return templateResolver;
   }
   @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
   }
   @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
   }
<<<<<<< HEAD
=======
    // Khai báo nới chưa bản dịch
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // Chọn nơi lưu trữ ngôn ngữ (cookie)
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(Duration.ofDays(30));
        resolver.setDefaultLocale(new Locale("vi"));
        return resolver;
    }

    // Tạo bộ bắt tham số thay đổi ngôn ngữ từ url
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    // đăng ký interceptors
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
>>>>>>> 72b6359 (mini-project)
}