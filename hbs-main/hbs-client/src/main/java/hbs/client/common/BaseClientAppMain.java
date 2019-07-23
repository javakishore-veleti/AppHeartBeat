/**
 * 
 */
package hbs.client.common;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;

import hbs.common.api.HeartBeatInfoService;

/**
 * @author kishore.veleti
 *
 */
public class BaseClientAppMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseClientAppMain.class);

	public static final String SERVER_HEART_BEAT_SCHEDULER_BEAN_ID = "getServerHeartBeatScheduler";

	protected String appCtxXMLFileName;
	protected Properties props = null;

	public BaseClientAppMain(String appCtxXMLFileName) {
		this.appCtxXMLFileName = appCtxXMLFileName;
	}

	/**
	 * @param args
	 */
	public void execute(String[] args) {
		LOGGER.debug("Enter appCtxXMLFileName " + appCtxXMLFileName);

		// open/read the application context file
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(appCtxXMLFileName);

		BaseGetServerHBScheduler heartBeatScheduler = ctx.getBean(SERVER_HEART_BEAT_SCHEDULER_BEAN_ID,
				BaseGetServerHBScheduler.class);

		loadOptionalHeartBeatInfoService(ctx, heartBeatScheduler);

		MailSender mailSender = ctx.getBean(MailSender.class);
		heartBeatScheduler.setMailSender(mailSender);

		props = ctx.getBean("applicationProps", Properties.class);
		populateEmailConfigFromProperties(heartBeatScheduler, props);

		/*
		 * Check out applicationContext.xml and application.properties files for
		 * scheduler configuration
		 */

		LOGGER.debug("Exit");
	}

	private void loadOptionalHeartBeatInfoService(ClassPathXmlApplicationContext ctx,
			BaseGetServerHBScheduler heartBeatScheduler) {

		try {
			HeartBeatInfoService hbInfoServiceProxy = ctx.getBean(HeartBeatInfoService.class);
			heartBeatScheduler.setHeartBeatInfoService(hbInfoServiceProxy);

		} catch (Throwable throwable) {
			LOGGER.warn("Optional HeartBeatInfoService bean does not exists");
		}
	}

	private static void populateEmailConfigFromProperties(BaseGetServerHBScheduler heartBeatScheduler,
			Properties props) {
		LOGGER.debug("Enter");

		heartBeatScheduler.setSendEmailWhenServerRespondFailed(
				props.getProperty("send.emai.when.server.heartbeat.error", "false").equalsIgnoreCase("true"));

		heartBeatScheduler.setEmailTo(props.getProperty("mail.to"));
		heartBeatScheduler.setEmailFrom(props.getProperty("mail.from"));
		heartBeatScheduler.setEmailSubject(props.getProperty("mail.subject"));
		heartBeatScheduler.setEmailMessage(props.getProperty("mail.message"));

		LOGGER.debug("Exit");
	}

}
