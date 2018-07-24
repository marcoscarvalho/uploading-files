package hello;

public class ErrorController2222 {
	
//}
//@Controller
//public class ErrorController2222 implements org.springframework.boot.web.servlet.error.ErrorController {
//
//	@Autowired
//	private Logger logger;
//
//	private final static String ERROR_PATH = "/error";
//
//	@RequestMapping(value = ERROR_PATH, method = RequestMethod.GET)
//	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
//
//		logger.error("Error request " + httpRequest.getRequestURL());
//
//		ModelAndView errorPage = new ModelAndView("errorPage");
//		String errorMsg = "";
//		int httpErrorCode = (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
//		;
//
//		switch (httpErrorCode) {
//		case 400: {
//			errorMsg = "Http Error Code: 400. Bad Request";
//			break;
//		}
//		case 401: {
//			errorMsg = "Http Error Code: 401. Unauthorized";
//			break;
//		}
//		case 404: {
//			errorMsg = "Http Error Code: 404. Resource not found";
//			break;
//		}
//		case 500: {
//			errorMsg = "Http Error Code: 500. Internal Server Error";
//			break;
//		}
//		}
//		errorPage.addObject("errorMsg", errorMsg);
//		return errorPage;
//	}
//
//	@Override
//	public String getErrorPath() {
//		return ERROR_PATH;
//	}

}
