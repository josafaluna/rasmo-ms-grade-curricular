package br.com.jluna.cliente.escola.gradecurricular.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MateriaException extends RuntimeException {

	private static final long serialVersionUID = -2280649004955226733L;

	private final HttpStatus httpStatus;

	public MateriaException(final String mensagem, final HttpStatus status) {
		super(mensagem);
		this.httpStatus = status;
	}

}
