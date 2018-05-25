package ssm.config;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;


@Configuration 
@ComponentScan(basePackages = "ssm") 
@EnableWebMvc
@PropertySource("classpath:jdbc.properties")
@MapperScan("ssm.dao.mappers") // 扫描此包下的所有mapper接口并注册实现bean
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 假设控制器返回"customers"，则做如下拼接确定jsp路径
		// "/WEB-INF/jsp/" + "customers" + ".jsp"
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Bean
	@Primary // 首选
	public DataSource testDataSource(Environment env) { // 数据源的初始化依赖配置环境
		String url = env.getProperty("jdbc.url");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");
		String driverClass = env.getProperty("jdbc.driverClass");
		
		DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(driverClass);
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// GET    /assets/bootstrap/css/bootstrap.min.css
		// 资源路径    /public/bootstrap/css/bootstrap.min.css
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
		registry.addResourceHandler("/customer-pictures/**").addResourceLocations("file:///D:/zhujunqi/upload/");
	}
	
	@Bean
	public MultipartResolver multipartResolver() { // 文件名必须要这么写，因为spring mvc会用这个id查找多部解析器
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(10 * 1024 * 1024); // 字节
		return mr;
	}
	
	//resources
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sf.setDataSource(dataSource);
		return sf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	//密码加密
    @Bean
    public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
    }
    
    //开通支付宝支付功能
    @Bean
    public AlipayClient alipayClient() throws IOException {
		return new DefaultAlipayClient(
				"https://openapi.alipay.com/gateway.do", 
				"2018052360246120", 
				FileUtils.readFileToString(
						new File("C:/liweili/alipay/app-prikey.txt"), "UTF-8"), 
				"json", "UTF-8", 
				FileUtils.readFileToString(
						new File("C:/liweili/alipay/alipay-pubkey.txt"), "UTF-8"), 
				"RSA2"
				);
    }
    
}
