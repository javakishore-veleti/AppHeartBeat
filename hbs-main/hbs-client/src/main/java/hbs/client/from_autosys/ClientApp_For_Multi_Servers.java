package hbs.client.from_autosys;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hbs.common.api.HeartBeatInfoService;
import hbs.common.dto.AppServerHBeatURLInfo;

public class ClientApp_For_Multi_Servers {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientApp_For_Multi_Servers.class);

	/*
	 * Since this client program is invoked by AuthoSys who is taking care of all
	 * Scheduling at frequent intervals // here we need to explicitly call //
	 * serverInvokerClientService.executeRestfulCallToServer // method to get the
	 * server heart beat information
	 * 
	 */
	public static void main(String[] args) throws Exception {
		LOGGER.debug("Enter");

		ApplicationContext applicationCtx = new ClassPathXmlApplicationContext("appCtx-autosys-multi-app-servers.xml");

		printInformationAboutThisClient();

		List<AppServerHBeatURLInfo> appServerHBUrlsList = parseServersURLInfoJSON("All-App-Servers-HB-URL-Info.json");
		invokeAllAppServersForHeartBeatInfo(appServerHBUrlsList, applicationCtx);

		LOGGER.debug("Shutting down the client program i.e. this client program JVM is getting killed");
		LOGGER.debug("Exit");
	}

	/*
	 * BELOW FOR LOOP IS INVOKING EACH SERVER FOR ITS HEARTBEAT INFORMATION //
	 * EXPLICITY THIS IS INVOKED EXPLICITLY BECAUSE THIS CLIENT PROGRAM // DOES NOT
	 * HAVE ANY SCHEDULER RUNNING IN THIS JVM RUNTIME
	 * 
	 */
	private static void invokeAllAppServersForHeartBeatInfo(List<AppServerHBeatURLInfo> appServerHBUrlsList,
			ApplicationContext applicationCtx) {

		for (AppServerHBeatURLInfo appServerHBeatURLInfo : appServerHBUrlsList) {

			invokeAnAppServerForItsHeartBeatInfo(appServerHBeatURLInfo, applicationCtx);
		}
	}

	/*
	 * http://www.pgt.de/2009/02/26/how-to-use-the-simplehttpinvokerserviceexporter/
	 */
	private static void invokeAnAppServerForItsHeartBeatInfo(AppServerHBeatURLInfo serverHBeatURLInfo,
			ApplicationContext applicationCtx) {

		printStartLogMessage(serverHBeatURLInfo.getAppName());

		HttpInvokerProxyFactoryBean proxyFactoryBean = createNewHttpInvokerProxyBeanInstance(
				serverHBeatURLInfo.getAppHeartBeatUrl());

		String heartBeatMessage = null;

		try {
			heartBeatMessage = ((HeartBeatInfoService) proxyFactoryBean.getObject()).provideHeartBeatInfo();

		} catch (Throwable throwable) {

			LOGGER.error("Exception occured while getting heart beat information for the server "
					+ serverHBeatURLInfo.getAppName());

		}

		printEndLogMessage(serverHBeatURLInfo.getAppName(), heartBeatMessage);
	}

	private static HttpInvokerProxyFactoryBean createNewHttpInvokerProxyBeanInstance(String appServerHBUrl) {

		HttpInvokerProxyFactoryBean proxyFactoryBean = new HttpInvokerProxyFactoryBean();

		proxyFactoryBean.setServiceInterface(HeartBeatInfoService.class);
		proxyFactoryBean.setServiceUrl(appServerHBUrl);
		proxyFactoryBean.afterPropertiesSet();

		return proxyFactoryBean;
	}

	private static List<AppServerHBeatURLInfo> parseServersURLInfoJSON(String allAppServers_HB_URLs_JSON_File)
			throws Exception {
		LOGGER.debug("Enter allAppServers_HB_URLs_JSON_File " + allAppServers_HB_URLs_JSON_File);

		ObjectMapper objectMapper = new ObjectMapper();

		List<AppServerHBeatURLInfo> appServerHBUrlsList = objectMapper
				.readValue(new File(allAppServers_HB_URLs_JSON_File), new TypeReference<List<AppServerHBeatURLInfo>>() {
				});

		LOGGER.debug("Exit");
		return appServerHBUrlsList;
	}

	private static void printEndLogMessage(String serverName, String heartBeatMessage) {

		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("END - Accessing the server for its heart beat info serverName " + serverName
				+ " heartBeatMessage " + heartBeatMessage);
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

	private static void printStartLogMessage(String serverName) {
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		LOGGER.debug("START - Accessing the server for its heart beat info serverName " + serverName);
		LOGGER.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
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
