package mg.crustyz;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
	ex.printStackTrace();

	ModelAndView mav = new ModelAndView();
	mav.addObject("exception", ex);
	mav.addObject("url", request.getRequestURL());
	mav.setViewName("error");

	return mav;
    }
}

