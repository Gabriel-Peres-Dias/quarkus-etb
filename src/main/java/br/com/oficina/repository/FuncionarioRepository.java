package br.com.oficina.repository;

import br.com.oficina.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {

    public void atualizar(Funcionario funcionario) {
        getEntityManager().merge(funcionario);
    }
}
