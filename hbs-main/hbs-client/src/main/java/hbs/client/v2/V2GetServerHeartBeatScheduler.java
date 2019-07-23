/**
 * 
 */
package hbs.client.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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

	public V2GetServerHeartBeatScheduler(String v2ServerURL, RestOperations restTemplate) {
		super();
		this.serverURL = v2ServerURL;
		this.restTemplate = restTemplate;
	}

	public void executeRestfulCallToServer() {

		try {

			LOGGER.debug("Fetching the HeartBeat info for the server " + serverURL);

			ResponseEntity<String> response = restTemplate.getForEntity(serverURL, String.class);
			String receivedMessage = response.getBody();

			// String receivedMessage = restTemplate.getForObject(serverURL, String.class,
			// variables);

			LOGGER.debug("Received message from the heartbeat info server as " + receivedMessage);

		} catch (Throwable throwable) {

			LOGGER.error("Exception occured while invoking the server for its heartbeat info", throwable);
			sendEmailThatServerNotRunning();
		}
	}

}
