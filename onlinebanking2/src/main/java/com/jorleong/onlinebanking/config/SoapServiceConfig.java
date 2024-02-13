package com.jorleong.onlinebanking.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jorleong.onlinebanking.ws.AccountWebService;


@Configuration
public class SoapServiceConfig {
	@Autowired
	Bus bus;
	
	@Autowired
	AccountWebService accountWebService;
	@Bean(name="cxf")
	public SpringBus theBus(){
		return new SpringBus();
	}
	
	@Bean
	public ServletRegistrationBean servletBean(){
		return new ServletRegistrationBean(new CXFServlet(),"/services/*");
	}
	
	@Bean
	public Endpoint endpoint(SpringBus bus){
		EndpointImpl endpoint=new EndpointImpl(bus,accountWebService);
		endpoint.publish("/AccountWebService");
		return endpoint;
		
	}
}
