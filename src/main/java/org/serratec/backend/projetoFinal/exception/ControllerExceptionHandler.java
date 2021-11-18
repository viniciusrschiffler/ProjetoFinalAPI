package org.serratec.backend.projetoFinal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem Campos Inválidos. Confira o que preencheu. ",
				LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
}
