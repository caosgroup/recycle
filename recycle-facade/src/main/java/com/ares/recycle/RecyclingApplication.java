package com.ares.recycle;

import com.ares.recycle.common.base.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.ares.recycle"})
@SpringBootApplication(scanBasePackages = {"com.ares.recycle"})
public class RecyclingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RecyclingApplication.class, args);
		SpringContextUtil.setApplicationContext(context);
	}

}
