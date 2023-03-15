package br.com.oficina.service;

import br.com.oficina.repository.ServicoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ServicoService {

    @Inject
    ServicoRepository servicoRepository;
}
