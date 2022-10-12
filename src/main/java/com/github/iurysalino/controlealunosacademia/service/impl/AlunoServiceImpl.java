package com.github.iurysalino.controlealunosacademia.service.impl;

import com.github.iurysalino.controlealunosacademia.entity.Aluno;
import com.github.iurysalino.controlealunosacademia.entity.AvaliacaoFisica;
import com.github.iurysalino.controlealunosacademia.entity.form.AlunoForm;
import com.github.iurysalino.controlealunosacademia.entity.form.AlunoUpdateForm;
import com.github.iurysalino.controlealunosacademia.infra.utils.JavaTimeUtils;
import com.github.iurysalino.controlealunosacademia.repository.AlunoRepository;
import com.github.iurysalino.controlealunosacademia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository repository;

  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    return null;
  }

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {

    if(dataDeNascimento == null) {
      return repository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }

  }

  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    Aluno aluno = repository.findById(id).get();

    return aluno.getAvaliacoes();

  }

}
