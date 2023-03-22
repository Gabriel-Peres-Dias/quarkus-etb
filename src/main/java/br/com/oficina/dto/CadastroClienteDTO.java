package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CadastroClienteDTO(
        @NotBlank
        @NotEmpty
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        @NotBlank
        String telefone,
        @NotBlank
        String senha,
        @NotBlank
        String cpf,
        @NotNull
        Endereco endereco
) {
}
