package com.github.iurysalino.controlealunosacademia.service.impl;

import com.github.iurysalino.controlealunosacademia.entity.Aluno;
import com.github.iurysalino.controlealunosacademia.entity.AvaliacaoFisica;
import com.github.iurysalino.controlealunosacademia.entity.form.AvaliacaoFisicaForm;
import com.github.iurysalino.controlealunosacademia.entity.form.AvaliacaoFisicaUpdateForm;
import com.github.iurysalino.controlealunosacademia.repository.AlunoRepository;
import com.github.iurysalino.controlealunosacademia.repository.AvaliacaoFisicaRepository;
import com.github.iurysalino.controlealunosacademia.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return null;
  }

  @Override
  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
