package in.scalive.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 // Exception Handler
    @ExceptionHandler(value=EmpAlreadyExistsException.class)
    public ResponseEntity <ErrorResponse> handleException(EmpAlreadyExistsException ex) {
        ErrorResponse error=new ErrorResponse();
        error.setStatuscode(HttpStatus.CONFLICT.value());
        error.setMessage(ex.getMessage());
    	return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value=NoSuchEmpExistsException.class)
    public ResponseEntity <ErrorResponse> handleNoSuchEmpExistsException(NoSuchEmpExistsException ex) {
        ErrorResponse error=new ErrorResponse();
        error.setStatuscode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public ResponseEntity <ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponse error=new ErrorResponse();
        error.setStatuscode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
