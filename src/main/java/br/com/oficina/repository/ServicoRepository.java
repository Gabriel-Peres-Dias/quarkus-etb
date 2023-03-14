package br.com.oficina.repository;

import br.com.oficina.model.Servico;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicoRepository implements PanacheRepository<Servico> {
}
