/**
 * 
 */
package hbs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hbs.client.common.BaseClientAppMain;

/**
 * @author kishore.veleti
 *
 */
public class ClientAppMain_ServerNotInWebServer extends BaseClientAppMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientAppMain_ServerNotInWebServer.class);

	public ClientAppMain_ServerNotInWebServer() {
		super("applicationContext.xml");
	}

	public static void main(String[] args) {
		LOGGER.debug("Enter");

		ClientAppMain_ServerNotInWebServer client = new ClientAppMain_ServerNotInWebServer();

		client.execute(args);

		LOGGER.debug("Exit");

		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");
		LOGGER.debug("	(Not deployed in a webserver)");
		LOGGER.debug("	This client program invokes Heart Beat Server at scheduled intervals");
		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");
	}

}
