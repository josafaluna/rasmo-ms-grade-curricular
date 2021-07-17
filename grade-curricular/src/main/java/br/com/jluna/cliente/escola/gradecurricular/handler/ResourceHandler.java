package br.com.jluna.cliente.escola.gradecurricular.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jluna.cliente.escola.gradecurricular.exception.MateriaException;
import br.com.jluna.cliente.escola.gradecurricular.model.ErrorResponse;

@ControllerAdvice
public class ResourceHandler {

	@ExceptionHandler(MateriaException.class)
	public ResponseEntity<ErrorResponse> handlerMateriaException(MateriaException m) {

		ErrorResponse.ErrorResponseBuilder erro = ErrorResponse.builder();
		erro.httpStatus(m.getHttpStatus().value());
		erro.mensagem(m.getMessage());
		erro.timeStamp(System.currentTimeMillis());

		return ResponseEntity.status(m.getHttpStatus()).body(erro.build());
	}

}
