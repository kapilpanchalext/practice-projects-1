package com.app.error.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping(path = "/api/v1")
public class ErrorController extends ResponseEntityExceptionHandler{

//	@ControllerAdvice(basePackageClasses = Exception.class)
//	public ResponseEntity<?> handleControllerException(HttpServletRequest request,
//			Throwable ex) {
//			  HttpStatus status = getStatus(request);
//			  return new ResponseEntity<>(new MyErrorBody(status.value(), ex.getMessage()),
//			status);
//			  }
//	
//	private HttpStatus getStatus(HttpServletRequest request) {
//		Integer code = (Integer)
//				request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//				  HttpStatus status = HttpStatus.resolve(code);
//				  return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
//				  }
}
