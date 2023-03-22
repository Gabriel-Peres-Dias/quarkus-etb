package br.com.oficina.repository;

import br.com.oficina.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public void atualizar(Cliente cliente) {
        getEntityManager().merge(cliente);
    }
}
