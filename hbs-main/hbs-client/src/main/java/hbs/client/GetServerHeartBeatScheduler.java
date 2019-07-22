/**
 * 
 */
package hbs.client;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestOperations;

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

	public GetServerHeartBeatScheduler(String serverURL) {
		this.serverURL = serverURL;
	}

	public HeartBeatInfoService getHeartBeatInfoService() {
		return heartBeatInfoService;
	}

	public void setHeartBeatInfoService(HeartBeatInfoService heartBeatInfoService) {
		this.heartBeatInfoService = heartBeatInfoService;
	}

	/*
	 * CAUTION : Any change to this method name needs to be updated even in
	 * applicationContext.xml This method is invoked because of configuration in
	 * applicationContext.xml
	 */
	public void executeRestfulCallToServer() {

		try {

			LOGGER.debug("Fetching the HeartBeat info for the server " + serverURL);

			// Look into this example https://www.baeldung.com/spring-remoting-http-invoker
			// for how this client program users Spring Remote API to invoke the server
			this.heartBeatInfoService.provideHeartBeatInfo();

		} catch (Throwable throwable) {
			// LOGGER.error("Exception occured while invoking the server for its heartbeat
			// info", throwable);
		}

	}
}
