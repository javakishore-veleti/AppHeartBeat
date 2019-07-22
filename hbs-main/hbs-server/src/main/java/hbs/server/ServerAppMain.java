/**
 * 
 */
package hbs.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kishore.veleti
 *
 */
public class ServerAppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// open/read the application context file
		new ClassPathXmlApplicationContext("applicationContext.xml");

		/*
		 * Check out applicationContext.xml and application.properties files for
		 * scheduler configuration
		 */

	}

}
