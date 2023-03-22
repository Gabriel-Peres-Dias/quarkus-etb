package br.com.oficina.service;

import br.com.oficina.dto.AlterarFuncionarioDTO;
import br.com.oficina.dto.DadosDetalhamentoFuncionarioDTO;
import br.com.oficina.dto.DadosFuncionarioDTO;
import br.com.oficina.model.Funcionario;
import br.com.oficina.repository.FuncionarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public DadosDetalhamentoFuncionarioDTO buscarFuncionarioPorId(Long id) {
        return new DadosDetalhamentoFuncionarioDTO(funcionarioRepository.findById(id));
    }

    public List<DadosDetalhamentoFuncionarioDTO> listarFuncionarios() {
        return  funcionarioRepository.listAll().stream().map(DadosDetalhamentoFuncionarioDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public DadosDetalhamentoFuncionarioDTO cadastrarFuncionario(DadosFuncionarioDTO funcionarioDTO) {
        var funcionario = new Funcionario(funcionarioDTO);
        funcionarioRepository.persist(funcionario);
        return new DadosDetalhamentoFuncionarioDTO(funcionario);
    }

    @Transactional
    public DadosDetalhamentoFuncionarioDTO atualizarFuncionario(AlterarFuncionarioDTO funcionarioDTO) {
        var funcionario = new Funcionario(funcionarioDTO);
        funcionarioRepository.atualizar(funcionario);
        return new DadosDetalhamentoFuncionarioDTO(funcionario);
    }

    @Transactional
    public void desativarFuncionario(Long id) {
        var funcionario = funcionarioRepository.findById(id);
        funcionario.desativar();
    }
}
