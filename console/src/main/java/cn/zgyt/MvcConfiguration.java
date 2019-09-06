package cn.zgyt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.zgyt.utils.ConsoleConfig;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private ConsoleConfig consoleConfig;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:D:/OTA/"是文件真实的存储路径
        registry.addResourceHandler(consoleConfig.getPICPath()).addResourceLocations("file:"+consoleConfig.getPICRealPath());
        registry.addResourceHandler(consoleConfig.getTempPath()).addResourceLocations("file:"+consoleConfig.getTempRealPath());
        super.addResourceHandlers(registry);
    }
    
    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//      // addPathPatterns("/**") 表示拦截所有的请求，
//      // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
//      InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
//      loginRegistry.addPathPatterns("/**");
//      // 排除路径
//      loginRegistry.excludePathPatterns("/login/**");
//      loginRegistry.excludePathPatterns("/login");
//      loginRegistry.excludePathPatterns("/loginout");
//      // 排除资源请求
//      loginRegistry.excludePathPatterns("/css/login/*.css");
//      loginRegistry.excludePathPatterns("/js/login/**/*.js");
//      loginRegistry.excludePathPatterns("/image/login/*.png");
////      registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**", "/register");
//    }
}
