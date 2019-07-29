package hbs.client.server.inwar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hbs.client.common.BaseClientAppMain;

public class ClientApp_ForInWar extends BaseClientAppMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientApp_ForInWar.class);

	public ClientApp_ForInWar() {
		super("applicationContext-v2.xml");
	}

	public static void main(String[] args) {
		LOGGER.debug("Enter");

		ClientApp_ForInWar client = new ClientApp_ForInWar();

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
