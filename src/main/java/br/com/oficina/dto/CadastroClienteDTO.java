package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;

public record CadastroClienteDTO(
        String nome,
        String email,
        String telefone,
        String senha,
        String cpf,
        Endereco endereco
) {
}
