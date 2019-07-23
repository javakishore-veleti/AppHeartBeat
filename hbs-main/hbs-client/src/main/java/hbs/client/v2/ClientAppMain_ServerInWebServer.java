package hbs.client.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hbs.client.common.BaseClientAppMain;

public class ClientAppMain_ServerInWebServer extends BaseClientAppMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientAppMain_ServerInWebServer.class);

	public ClientAppMain_ServerInWebServer() {
		super("applicationContext-v2.xml");
	}

	public static void main(String[] args) {
		LOGGER.debug("Enter");

		ClientAppMain_ServerInWebServer client = new ClientAppMain_ServerInWebServer();

		client.execute(args);

		LOGGER.debug("Exit");

		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");
		LOGGER.debug("	(Server deployed in a webserver)");
		LOGGER.debug("	This client program invokes Heart Beat Server at scheduled intervals");
		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");

	}
}
