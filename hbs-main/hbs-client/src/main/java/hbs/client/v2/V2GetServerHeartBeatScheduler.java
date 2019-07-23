/**
 * 
 */
package hbs.client.v2;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestOperations;

import hbs.client.common.BaseGetServerHBScheduler;

/**
 * @author kishore.veleti
 *
 */
public class V2GetServerHeartBeatScheduler extends BaseGetServerHBScheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger(V2GetServerHeartBeatScheduler.class);

	public static final String BEAN_ID = "getServerHeartBeatScheduler";

	private RestOperations restTemplate;
	private Map<String, String> variables = new HashMap<String, String>(3);

	public V2GetServerHeartBeatScheduler(String v2ServerURL, RestOperations restTemplate) {
		super();
		this.serverURL = v2ServerURL;
		this.restTemplate = restTemplate;
	}

	public void executeRestfulCallToServer() {

		try {

			LOGGER.debug("Fetching the HeartBeat info for the server " + serverURL);

			String receivedMessage = restTemplate.getForObject(serverURL, String.class, variables);

			LOGGER.debug("Received message from the heartbeat info server as " + receivedMessage);

		} catch (Throwable throwable) {

			LOGGER.error("Exception occured while invoking the server for its heartbeat info", throwable);
			sendEmailThatServerNotRunning();
		}
	}

}
