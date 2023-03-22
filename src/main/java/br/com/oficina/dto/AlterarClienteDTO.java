package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record AlterarClienteDTO(
        @NotNull
        Long id,
        @NotEmpty
        String nome,
        @Email
        @NotEmpty
        String email,
        @NotEmpty
        String telefone,
        @NotEmpty
        String senha,
        @NotEmpty
        String cpf,
        @NotNull
        Endereco endereco
) {

}
