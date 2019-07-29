package hbs.client.from_autosys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hbs.client.common.BaseClientAppMain;
import hbs.client.common.BaseGetServerHBService;
import hbs.client.server.not_in_webserver.ClientApp_ForNotInWebServer;

public class ClientApp_For_Single_Server extends BaseClientAppMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientApp_ForNotInWebServer.class);

	public ClientApp_For_Single_Server() {
		super("appCtx-autosys-single-server.xml");
	}

	public static void main(String[] args) {
		LOGGER.debug("Enter");

		ClientApp_For_Single_Server client = new ClientApp_For_Single_Server();
		BaseGetServerHBService serverInvokerClientService = client.execute(args);

		// Since this client program is invoked by AuthoSys who is taking care of all
		// Scheduling at frequent intervals
		// here we need to explicitly call
		// serverInvokerClientService.executeRestfulCallToServer
		// method to get the server heart beat information

		printInformationAboutThisClient();

		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("START - Accessing the server for its heart beat info");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		// BELOW LINE OF CODE INVOKING THE SERVER FOR ITS HEARTBEAT INFORMATION
		// EXPLICITY THIS IS INVOKED EXPLICITLY BECAUSE THIS CLIENT PROGRAM
		// DOES NOT HAVE ANY SCHEDULER RUNNING IN THIS JVM RUNTIME

		serverInvokerClientService.executeRestfulCallToServer();

		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("END - Accessing the server for its heart beat info");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		LOGGER.debug("Shutting down the client program i.e. this client program JVM is getting killed");

		LOGGER.debug("Exit");

	}

	private static void printInformationAboutThisClient() {
		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");
		LOGGER.debug("	(Server Not deployed in a webserver)");
		LOGGER.debug("	(This client should be invoked through Autosys - so no Spring Scheduler in this client)");
		LOGGER.debug("	This client program invokes Heart Beat Server whenever Autosys invokes this client proram");
		LOGGER.debug("");
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("");
		LOGGER.debug("");
	}

}
