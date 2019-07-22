/**
 * 
 */
package hbs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import hbs.common.api.HeartBeatInfoService;

/**
 * @author kishore.veleti
 *
 */
public class GetServerHeartBeatScheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetServerHeartBeatScheduler.class);

	public static final String BEAN_ID = "getServerHeartBeatScheduler";

	private HeartBeatInfoService heartBeatInfoService;
	private String serverURL;
	private MailSender mailSender;
	private boolean sendEmailWhenServerRespondFailed;

	private String emailFrom;
	private String emailTo;
	private String emailSubject;
	private String emailMessage;

	public GetServerHeartBeatScheduler(String serverURL) {
		this.serverURL = serverURL;
	}

	public HeartBeatInfoService getHeartBeatInfoService() {
		return heartBeatInfoService;
	}

	public void setHeartBeatInfoService(HeartBeatInfoService heartBeatInfoService) {
		this.heartBeatInfoService = heartBeatInfoService;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public boolean isSendEmailWhenServerRespondFailed() {
		return sendEmailWhenServerRespondFailed;
	}

	public void setSendEmailWhenServerRespondFailed(boolean sendEmailWhenServerRespondFailed) {
		this.sendEmailWhenServerRespondFailed = sendEmailWhenServerRespondFailed;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	// Look into this example https://www.baeldung.com/spring-remoting-http-invoker
	// for how this client program users Spring Remote API to invoke the server
	/*
	 * CAUTION : Any change to this method name needs to be updated even in
	 * applicationContext.xml This method is invoked because of configuration in
	 * applicationContext.xml
	 */
	public void executeRestfulCallToServer() {

		try {

			LOGGER.debug("Fetching the HeartBeat info for the server " + serverURL);

			String receivedMessage = this.heartBeatInfoService.provideHeartBeatInfo();

			LOGGER.debug("Received message from the heartbeat info server as " + receivedMessage);

		} catch (Throwable throwable) {

			LOGGER.error("Exception occured while invoking the server for its heartbeat info", throwable);
			sendEmailThatServerNotRunning();
		}
	}

	/*
	 * https://www.javatpoint.com/spring-java-mail-tutorial
	 */
	private void sendEmailThatServerNotRunning() {

		if (this.sendEmailWhenServerRespondFailed) {

			// creating message
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(this.emailFrom);
			message.setTo(this.emailTo);
			message.setSubject(this.emailSubject);
			message.setText(this.emailMessage);

			// sending message
			mailSender.send(message);

		}

	}
}
