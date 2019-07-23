/**
 * 
 */
package hbs.server.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kishore.veleti
 *
 */
@Controller
public class HeartBeatInfoServiceImpl {

	/**
	 * 
	 */
	public HeartBeatInfoServiceImpl() {
	}

	@RequestMapping("/api/heart-beat-info")
	public String provideHeartBeatInfo() {
		return "RUNNING";
	}

}
