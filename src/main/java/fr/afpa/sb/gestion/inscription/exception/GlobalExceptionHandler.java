package fr.afpa.sb.gestion.inscription.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Gestionnaires des exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Entité de ResourceNotFoundException.
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<?>
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
	}

	/**
	 * Entité de InvalidIdException.
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<?>
	 */
//    @ResponseBody
//    @ExceptionHandler(InvalidIdException.class)
//    public ResponseEntity<?> invalidIdException(InvalidIdException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus.NO_CONTENT);
//        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
//    }

//    @ResponseBody
//    @ExceptionHandler(NotFoundWithIdException.class)
//    public ResponseEntity<ErrorDetails> notFoundIdException(NotFoundWithIdException ex, WebRequest request)
//    {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(errorDetails.getStatus()).body(errorDetails);
//    }

	/**
	 * Entité de Exception.
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<?>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Entité de ApplicationException.
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<?>
	 */
//    @ExceptionHandler(ApplicationException.class)
//    public ResponseEntity<?> applicationException(ApplicationException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus.BAD_GATEWAY);
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
//    }

	/**
	 * Entité de BadRequestException
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<?>
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Entité de ConflictRequestException.
	 *
	 * @param ex
	 * @param request
	 * @return ResponseEntity<?>
	 */
//    @ExceptionHandler(ConflictRequestException.class)
//    public ResponseEntity<?> conflictRequestException(ConflictRequestException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus.CONFLICT);
//        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
//    }

}
