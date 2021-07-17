package br.com.jluna.cliente.escola.gradecurricular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jluna.cliente.escola.gradecurricular.entity.MateriaEntity;
import br.com.jluna.cliente.escola.gradecurricular.service.MateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private MateriaService service;

	@GetMapping("/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<MateriaEntity> consultarMaterias(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.consultar(id));
	}

	/**
	 * GET
	 * 
	 * @return
	 */
	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<List<MateriaEntity>> listarMaterias() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.listar());
	}

	/**
	 * POST
	 * 
	 * @param materia
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Boolean> cadastrarMaterias(@RequestBody MateriaEntity materia) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.cadastrar(materia));
	}

	/**
	 * DELETE
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletarMateria(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.excluir(id));
	}

	/**
	 * PUT
	 * 
	 * @param materia
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Boolean> atualizarMateria(@RequestBody MateriaEntity materia) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.atualizar(materia));
	}

}
