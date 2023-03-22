package br.com.oficina.dto;

import br.com.oficina.model.Funcionario;

public record DadosDetalhamentoFuncionarioDTO(
        String nome,
        String matricula,
        boolean status
) {
    public DadosDetalhamentoFuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getNome(), funcionario.getMatricula(), funcionario.isStatus());
    }
}
