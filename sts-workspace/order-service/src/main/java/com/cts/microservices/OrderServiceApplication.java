package com.cts.microservices;

import org.apache.http.entity.ContentType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}
	
	@Bean
	public RequestInterceptor authInterceptor() {
		return(
				request->{
					request.header("auth", "Header sent from Oredr Service");
					request.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
					log.info("Header Successfully Sent");
				}
				);
	}
	

}
