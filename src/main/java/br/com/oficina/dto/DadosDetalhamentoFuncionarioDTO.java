package br.com.oficina.dto;

import br.com.oficina.model.Funcionario;

public record DadosDetalhamentoFuncionarioDTO(
        Long id,
        String nome,
        String matricula,
        boolean status
) {
    public DadosDetalhamentoFuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getMatricula(), funcionario.isStatus());
    }
}
