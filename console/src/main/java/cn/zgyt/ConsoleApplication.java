package cn.zgyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.zgyt.entiry.Product;
import cn.zgyt.entiry.ProductType;
import cn.zgyt.utils.ConsoleConfig;
@EnableTransactionManagement
@SpringBootApplication
public class ConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleApplication.class, args);
	}
	@Bean(name = "consoleConfig")
	@ConfigurationProperties(prefix="server")
	public ConsoleConfig portalConfig(){
		return new ConsoleConfig();
	}
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.exposeIdsFor(Product.class,ProductType.class);
			}
		};
	}
	
}
