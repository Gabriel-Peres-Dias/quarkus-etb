package br.com.oficina.service;

import br.com.oficina.repository.PedidoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PedidoService {

    @Inject
    PedidoRepository pedidoRepository;
}
