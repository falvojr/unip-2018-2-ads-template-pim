package br.unip.ads.pim.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Chamado;
import br.unip.ads.pim.repository.ChamadoRepository;
import br.unip.ads.pim.service.ChamadoService;
import br.unip.ads.pim.util.ExcecaoNegocial;

@Service
public class ChamadoServiceImpl implements ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Override
	public void incluir(Chamado chamado) {
		if (chamado.getId() != null) {
			throw new ExcecaoNegocial("O ID não deve ser especificado.");
		}
		this.chamadoRepository.save(chamado);
	}

	@Override
	public Iterable<Chamado> buscarTodos() {
		return this.chamadoRepository.findAll();
	}

	@Override
	public Chamado buscarUm(Long id) {
		Optional<Chamado> chamado = this.chamadoRepository.findById(id);
		return chamado.orElseThrow(() -> new ExcecaoNegocial("ID não localizado."));
	}

	@Override
	public void atualizar(Chamado chamado) {
		if (chamado.getId() == null) {
			throw new ExcecaoNegocial("O ID deve ser especificado.");
		}
		this.chamadoRepository.save(chamado);
	}

	@Override
	public void remover(Long id) {
		this.chamadoRepository.deleteById(id);
	}

}