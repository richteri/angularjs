/**
 * 
 */
package bugger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Root controller
 * @author richteri
 *
 */
@Controller
public class RouteController {
	@RequestMapping({
		"/"
	})
	public String index() {
	    return "forward:/index.html";
	}
	
}
