package com.zcq.springbootobservation;

import com.zcq.springbootobservation.Service.DataScanner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static java.lang.Thread.sleep;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
@EnableAsync
@MapperScan("com.zcq.springbootobservation.Mapper")
public class SpringBootObservationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootObservationApplication.class, args);

		System.out.println("运行成功");



	}

	/*@Scheduled(cron= "3 0 0 * * ?")
	public void Dataloading(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.err.println("---->>数据入库:"+"当前时间：" + sdf.format(d));
	}*/


}
