/**
 * 
 */
package hbs.client.server.not_in_webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hbs.client.common.BaseClientAppMain;

/**
 * @author kishore.veleti
 *
 */
public class ClientApp_ForNotInWebServer extends BaseClientAppMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientApp_ForNotInWebServer.class);

	public ClientApp_ForNotInWebServer() {
		super("applicationContext.xml");
	}

	public static void main(String[] args) {
		LOGGER.debug("Enter");

		ClientApp_ForNotInWebServer client = new ClientApp_ForNotInWebServer();

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
