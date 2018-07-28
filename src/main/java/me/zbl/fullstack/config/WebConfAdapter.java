package me.zbl.fullstack.config;

import me.zbl.fullstack.interceptor.UserAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * WEB MVC configuration
 *
 * @author raviteja
 */
@Configuration
public class WebConfAdapter extends WebMvcConfigurerAdapter {

  private UserAuthenticationInterceptor securityInterceptor;

  @Autowired
  public WebConfAdapter(UserAuthenticationInterceptor securityInterceptor) {
    super();
    this.securityInterceptor = securityInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //Background login interceptor to intercept the path
    registry.addInterceptor(securityInterceptor)
            .addPathPatterns("/admin/**")
            .excludePathPatterns("/adminlogin/**");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    super.addViewControllers(registry);
    //Home page
    registry.addViewController("/").setViewName("forward:/index");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // Configure static resource paths
    registry.addResourceHandler("/**").addResourceLocations("classpath:static/");
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    super.configureMessageConverters(converters);
    converters.add(responseBodyConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    super.configureContentNegotiation(configurer);
    configurer.favorPathExtension(false);
  }

  @Override
  public Validator getValidator() {
    return super.getValidator();
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowCredentials(true);
    configuration.addAllowedOrigin("*");
    configuration.addAllowedHeader("*");
    configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
    source.registerCorsConfiguration("/**", configuration);
    return new CorsFilter(source);
  }

  @Bean
  public HttpMessageConverter<String> responseBodyConverter() {
   // Coding
    return new StringHttpMessageConverter(Charset.forName("UTF-8"));
  }

}
