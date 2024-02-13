package com.jorleong.onlinebanking.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.XmlViewResolver;

import com.jorleong.onlinebanking.domain.Account;
import com.jorleong.onlinebanking.domain.Branch;
import com.jorleong.onlinebanking.domain.Customer;
import com.jorleong.onlinebanking.domain.Loan;
import com.jorleong.onlinebanking.domain.Role;
import com.jorleong.onlinebanking.domain.Transaction;
import com.jorleong.onlinebanking.domain.User;

//import com.jorleong.domain.Employee;

@Configuration
// @ComponentScan(basePackages="com.jorleong")
@EnableWebMvc
//@EnableWebSecurity
public class AppConfig /* extends WebMvcConfigurerAdapter */ {

	public Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.put("hibernate.show_sql", true);
//		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		return hibernateProperties;

	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setAnnotatedClasses(Account.class, Branch.class, Transaction.class, User.class, Role.class,
				Loan.class, Customer.class);
		return sessionFactory;
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public XmlViewResolver xmlViewResolver() {
		XmlViewResolver resolver = new XmlViewResolver();
		resolver.setLocation(new ClassPathResource("view.xml"));
		resolver.setOrder(0);
		return resolver;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * public void configureViewResolvers(ViewResolverRegistry registry){
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/views/"); resolver.setSuffix(".jsp");
	 * resolver.setViewClass(JstlView.class);
	 * 
	 * registry.viewResolver(resolver); }
	 */

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/onlinebanking?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;

	}

	@Bean(name = "entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(new String[] { "com.jorleong" });
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());

		return entityManagerFactoryBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("/WEB-INF/messages/messages");
		return messageSource;
	}

	public void configureMessageConverters(java.util.List<HttpMessageConverter<?>> converters) {

		Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter = new Jaxb2RootElementHttpMessageConverter();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();

		converters.add(jaxb2RootElementHttpMessageConverter);
		converters.add(mappingJackson2HttpMessageConverter);
		converters.add(mappingJackson2XmlHttpMessageConverter);

	}

	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(25);
		mailSender.setUsername("jorleongsessionusc10@gmail.com");
		mailSender.setPassword("synergistic10");

		mailSender.setJavaMailProperties(javaMailProperties());

		return mailSender;
	}

//	@Bean
//	public SimpleMailMessage mailMessage() {
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setTo("");
//		mailMessage.setFrom("");
//		mailMessage.setSubject("");
//		mailMessage.setText("");
//		return mailMessage;
//	}

	public Properties javaMailProperties() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.debug", "true");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		return javaMailProperties;
	}

//	public void configureMessageConverters(java.util.List<HttpMessageConverter<?>> converters) {
//		
//		Jaxb2RootElementHttpMessageConverter  jaxb2RootElementHttpMessageConverter = new Jaxb2RootElementHttpMessageConverter();
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();
//		
//		
//		converters.add(jaxb2RootElementHttpMessageConverter);
//		converters.add(mappingJackson2HttpMessageConverter);
//		converters.add(mappingJackson2XmlHttpMessageConverter);
//		
//	}
//	
}
