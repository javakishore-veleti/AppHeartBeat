/**
 * 
 */
package hbs.client.server.not_in_webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hbs.client.common.BaseGetServerHBService;

/**
 * @author kishore.veleti
 *
 */
public class GetServerHeartBeatService extends BaseGetServerHBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetServerHeartBeatService.class);

	public static final String BEAN_ID = "getServerHeartBeatService";

	public GetServerHeartBeatService(String serverURL) {
		this.serverURL = serverURL;
	}

	// Look into this example https://www.baeldung.com/spring-remoting-http-invoker
	// for how this client program users Spring Remote API to invoke the server
	/*
	 * CAUTION : Any change to this method name needs to be updated even in
	 * applicationContext.xml This method is invoked because of configuration in
	 * applicationContext.xml
	 */
	@Override
	public void executeRestfulCallToServer() {
		LOGGER.debug("Enter");

		try {

			LOGGER.debug("Fetching the HeartBeat info for the server " + serverURL);

			String receivedMessage = this.heartBeatInfoService.provideHeartBeatInfo();

			LOGGER.debug("Received message from the heartbeat info server as " + receivedMessage);

		} catch (Throwable throwable) {

			LOGGER.error("Exception occured while invoking the server for its heartbeat info", throwable);
			sendEmailThatServerNotRunning();
		}

		LOGGER.debug("Exit");
	}

}
