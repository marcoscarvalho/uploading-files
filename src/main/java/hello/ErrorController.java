package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@Autowired
	private Logger logger;

	private final static String ERROR_PATH = "/error";
	private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	@RequestMapping(value = ERROR_PATH, produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request, Exception e) {

		ModelAndView errorPage = new ModelAndView("404");
		String errorMsg = "";
		int httpErrorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
		String data = sdf.format(new Date());

		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 404: {
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 500: {
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		errorPage.addObject("httpErrorCode", httpErrorCode);
		errorPage.addObject("httpRequestUri", uri);
		errorPage.addObject("exception", e);
		errorPage.addObject("data", data);

		String msg = "Error request >> " + httpErrorCode + " >> " + errorMsg + " >> " + uri + " >> " + data + " >> " + e;
		logger.error(msg);

		return errorPage;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
