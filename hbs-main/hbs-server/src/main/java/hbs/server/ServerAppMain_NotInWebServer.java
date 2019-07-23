/**
 * 
 */
package hbs.server;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kishore.veleti
 *
 */
public class ServerAppMain_NotInWebServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerAppMain_NotInWebServer.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// open/read the application context file
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		Properties props = ctx.getBean("applicationProps", Properties.class);

		// below thisServerPortNo variable is created for display purpose only
		String thisServerPortNo = props.getProperty("heartbeat.server.http.port");
		String heartBeatServerAPIURL = props.getProperty("heartbeat.server.api.url");

		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");
		LOGGER.debug("	(Not deployed in a webserver)");
		LOGGER.debug("	Heart Beat server URL is http://<SERVER-IP>:" + thisServerPortNo + "/" + heartBeatServerAPIURL);
		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");

		/*
		 * Check out applicationContext.xml and application.properties files for
		 * scheduler configuration
		 */

	}

}
