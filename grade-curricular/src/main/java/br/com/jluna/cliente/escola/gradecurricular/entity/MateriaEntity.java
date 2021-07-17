package br.com.jluna.cliente.escola.gradecurricular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_materia")
@Data
@NoArgsConstructor
public class MateriaEntity implements Serializable {

	private static final long serialVersionUID = 9154758446674678699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "id")
	private Long id;

	@JsonInclude(Include.NON_EMPTY)
	private String nome;

	@Column(name = "hrs")
	private int horas;

	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "cod")
	private String codigo;

	@Column(name = "freq")
	private int frequencia;

}
