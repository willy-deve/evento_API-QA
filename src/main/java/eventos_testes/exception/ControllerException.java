package eventos_testes.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundIdException(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError();
        HttpStatus statusError = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(statusError.value());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        error.setError("Recurso não encontrado");
        return ResponseEntity.status(statusError).body(error);
    }
}
