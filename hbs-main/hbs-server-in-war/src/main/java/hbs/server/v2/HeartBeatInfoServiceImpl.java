/**
 * 
 */
package hbs.server.v2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/api/heart-beat-info")
	@ResponseBody
	public ResponseEntity<String> provideHeartBeatInfo() {

		return new ResponseEntity<String>("RUNNING", HttpStatus.OK);
	}

}
