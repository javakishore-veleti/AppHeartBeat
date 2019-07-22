package hbs.server;

import hbs.common.api.HeartBeatInfoService;

public class HeartBeatInfoServiceImpl implements HeartBeatInfoService {

	private static final long serialVersionUID = 1L;

	public HeartBeatInfoServiceImpl() {
	}

	/*
	 * Look into this example
	 * 
	 * https://www.baeldung.com/spring-remoting-http-invoker
	 */
	@Override
	public String provideHeartBeatInfo() {
		return "RUNNING";
	}

}
