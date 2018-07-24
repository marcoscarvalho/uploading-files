package hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	/**
	 * Error Attributes in the Application
	 */
//	private ErrorAttributes errorAttributes;

	private final static String ERROR_PATH = "/error";

	/**
     * Controller for the Error Controller
     * @param errorAttributes
     */
//    public ErrorController(ErrorAttributes errorAttributes) {
//        this.errorAttributes = errorAttributes;
//    }

	/**
	 * Supports the HTML Error View
	 * 
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = ERROR_PATH, produces = "text/html")
//	public ModelAndView errorHtml(HttpServletRequest request) {
//		return new ModelAndView("/errors/error", getErrorAttributes(request, false));
//	}
	
	@RequestMapping(value = ERROR_PATH, produces = "text/html")
	public String errorHtml(HttpServletRequest request) {
		return "404";
	}

	/**
	 * Supports other formats like JSON, XML
	 * 
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = ERROR_PATH)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//		Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
//		HttpStatus status = getStatus(request);
//		return new ResponseEntity<Map<String, Object>>(body, status);
//	}

	/**
	 * Returns the path of the error page.
	 *
	 * @return the error path
	 */
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

//	private boolean getTraceParameter(HttpServletRequest request) {
//		String parameter = request.getParameter("trace");
//		if (parameter == null) {
//			return false;
//		}
//		return !"false".equals(parameter.toLowerCase());
//	}

//	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
//		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
//		return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
//	}

//	private HttpStatus getStatus(HttpServletRequest request) {
//		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//		if (statusCode != null) {
//			try {
//				return HttpStatus.valueOf(statusCode);
//			} catch (Exception ex) {
//			}
//		}
//		return HttpStatus.INTERNAL_SERVER_ERROR;
//	}

}
