package hbs.common.dto;

import java.util.List;

public class AppHBUrlJsonContent {

	private List<AppServerHBeatURLInfo> serverHBeatURLInfos;

	public AppHBUrlJsonContent() {
	}

	public List<AppServerHBeatURLInfo> getServerHBeatURLInfos() {
		return serverHBeatURLInfos;
	}

	public void setServerHBeatURLInfos(List<AppServerHBeatURLInfo> serverHBeatURLInfos) {
		this.serverHBeatURLInfos = serverHBeatURLInfos;
	}

}
