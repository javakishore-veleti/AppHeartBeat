/**
 * 
 */
package hbs.client;

import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;

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
		MailSender mailSender = ctx.getBean(MailSender.class);

		GetServerHeartBeatScheduler heartBeatScheduler = ctx.getBean(GetServerHeartBeatScheduler.class);

		heartBeatScheduler.setHeartBeatInfoService(hbInfoServiceProxy);
		heartBeatScheduler.setMailSender(mailSender);

		Properties props = ctx.getBean("applicationProps", Properties.class);
		populateEmailConfigFromProperties(heartBeatScheduler, props);
		/*
		 * Check out applicationContext.xml and application.properties files for
		 * scheduler configuration
		 */
	}

	private static void populateEmailConfigFromProperties(GetServerHeartBeatScheduler heartBeatScheduler,
			Properties props) {

		heartBeatScheduler.setSendEmailWhenServerRespondFailed(
				props.getProperty("send.emai.when.server.heartbeat.error", "false").equalsIgnoreCase("true"));

		heartBeatScheduler.setEmailTo(props.getProperty("mail.to"));
		heartBeatScheduler.setEmailFrom(props.getProperty("mail.from"));
		heartBeatScheduler.setEmailSubject(props.getProperty("mail.subject"));
		heartBeatScheduler.setEmailMessage(props.getProperty("mail.message"));
	}

}
