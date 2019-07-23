package hbs.client.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import hbs.common.api.HeartBeatInfoService;

public abstract class BaseGetServerHBScheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseGetServerHBScheduler.class);

	protected String serverURL;
	protected MailSender mailSender;
	protected boolean sendEmailWhenServerRespondFailed;

	protected String emailFrom;
	protected String emailTo;
	protected String emailSubject;
	protected String emailMessage;

	protected HeartBeatInfoService heartBeatInfoService;

	public BaseGetServerHBScheduler() {
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

	/*
	 * https://www.javatpoint.com/spring-java-mail-tutorial
	 */
	protected void sendEmailThatServerNotRunning() {
		LOGGER.debug("Enter");

		if (this.sendEmailWhenServerRespondFailed) {

			// creating message
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(this.emailFrom);
			message.setTo(this.emailTo);
			message.setSubject(this.emailSubject);
			message.setText(this.emailMessage);

			LOGGER.debug("Sending Email now");
			// sending message
			mailSender.send(message);

		}

		LOGGER.debug("Exit");

	}
}
