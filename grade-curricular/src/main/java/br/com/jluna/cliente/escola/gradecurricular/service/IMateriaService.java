package br.com.jluna.cliente.escola.gradecurricular.service;

import java.util.List;

import br.com.jluna.cliente.escola.gradecurricular.entity.MateriaEntity;

public interface IMateriaService {

	public Boolean atualizar(final MateriaEntity materia);

	public Boolean excluir(final Long id);

	public List<MateriaEntity> listar();

	public MateriaEntity consultar(final Long id);

	public Boolean cadastrar(final MateriaEntity materia);

}
