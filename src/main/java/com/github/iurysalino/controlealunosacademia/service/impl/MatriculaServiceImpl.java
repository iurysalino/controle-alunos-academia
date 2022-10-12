package com.github.iurysalino.controlealunosacademia.service.impl;

import com.github.iurysalino.controlealunosacademia.entity.Aluno;
import com.github.iurysalino.controlealunosacademia.entity.Matricula;
import com.github.iurysalino.controlealunosacademia.entity.form.MatriculaForm;
import com.github.iurysalino.controlealunosacademia.repository.AlunoRepository;
import com.github.iurysalino.controlealunosacademia.repository.MatriculaRepository;
import com.github.iurysalino.controlealunosacademia.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  @Override
  public List<Matricula> getAll(String bairro) {

    if(bairro == null){
      return matriculaRepository.findAll();
    }else{
      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

  }

  @Override
  public void delete(Long id) {}



}
