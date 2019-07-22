/**
 * 
 */
package hbs.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hbs.common.api.HeartBeatInfoService;

/**
 * @author kishore.veleti
 *
 */
public class ClientAppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// open/read the application context file
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		HeartBeatInfoService hbInfoServiceProxy = ctx.getBean(HeartBeatInfoService.class);

		GetServerHeartBeatScheduler heartBeatScheduler = ctx.getBean(GetServerHeartBeatScheduler.class);
		heartBeatScheduler.setHeartBeatInfoService(hbInfoServiceProxy);

		/*
		 * Check out applicationContext.xml and application.properties files for
		 * scheduler configuration
		 */
	}

}
