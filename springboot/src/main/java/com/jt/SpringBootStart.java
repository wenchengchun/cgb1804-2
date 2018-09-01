package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringBootStart extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStart.class, args);
	}
	//配置默认首页
	public void	 addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
		//当前处理是controller处理的最高级别
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);

	}
}
