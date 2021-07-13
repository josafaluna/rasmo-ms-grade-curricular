package br.com.jluna.cliente.escola.gradecurricular.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materia")
public class MateriaController {

	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<String> hello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello - Rasmoo");
	}

}
