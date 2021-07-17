package br.com.jluna.cliente.escola.gradecurricular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.jluna.cliente.escola.gradecurricular.entity.MateriaEntity;
import br.com.jluna.cliente.escola.gradecurricular.exception.MateriaException;
import br.com.jluna.cliente.escola.gradecurricular.repository.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private IMateriaRepository repository;

	@Override
	public Boolean atualizar(MateriaEntity materia) {

		try {

			/*
			 * Invocamos o método consultar, que irá fazer a verificação da existência o
			 * obj. Caso não haja, retornará uma exceção.
			 */
			MateriaEntity materiaPut = this.consultar(materia.getId());

			// atualizamos todos os valores
			materiaPut.setCodigo(materia.getCodigo());
			materiaPut.setNome(materia.getNome());
			materiaPut.setHoras(materia.getHoras());
			materiaPut.setFrequencia(materia.getFrequencia());

			// salvamos as alteracoes
			this.repository.save(materiaPut);

			return Boolean.TRUE;

		} catch (MateriaException m) {
			throw m;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean excluir(Long id) {
		try {

			// consulta antes de deletar
			this.consultar(id);

			this.repository.deleteById(id);
			return true;

		} catch (MateriaException m) {
			throw m;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<MateriaEntity> listar() {
		return this.repository.findAll();
	}

	@Override
	public Boolean cadastrar(MateriaEntity materia) {

		try {
			this.repository.save(materia);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public MateriaEntity consultar(Long id) {

		try {

			Optional<MateriaEntity> materiaOptional = this.repository.findById(id);
			if (materiaOptional.isPresent()) {
				return materiaOptional.get();
			}

			throw new MateriaException("Matéria não encontrada.", HttpStatus.NOT_FOUND);

		} catch (MateriaException m) {
			throw m;

		} catch (Exception e) {
			throw new MateriaException("Erro interno identificado, contate o suporte",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
