package in.erp.lib.mgmtbe.exception;

import java.sql.SQLException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Autowired
	private Environment env;

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(HttpClientErrorException.class)
	public final ErrorResponse handleForbiddenException(HttpClientErrorException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getStatusCode().toString(), Calendar.getInstance().getTime(),
				"Client Error", ex.getStatusText(), ex.getMessage());
		return error;
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public final ErrorResponse handleAllExceptions(HttpServerErrorException ex, WebRequest request) {

		ErrorResponse error = new ErrorResponse(ex.getStatusCode().toString(), Calendar.getInstance().getTime(),
				"Server Error", ex.getStatusText(), ex.getMessage());

		return error;
	}

	@ExceptionHandler(SQLException.class)
	public final ErrorResponse handleSQLExceptions(SQLException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(HttpStatus.NO_CONTENT.toString(), Calendar.getInstance().getTime(),
				ex.getMessage(), "", ex.getMessage());
		LOGGER.error(ex.getMessage());
		return error;
	}
	
	@ExceptionHandler(DataAccessException.class)
	public final ErrorResponse handleDalaAccessExceptions(DataAccessException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(HttpStatus.NO_CONTENT.toString(), Calendar.getInstance().getTime(),
				ex.getMessage(), "", ex.getMessage());
		return error;
	}

}
