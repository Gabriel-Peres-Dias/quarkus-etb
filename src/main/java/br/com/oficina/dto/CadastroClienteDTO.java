package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record CadastroClienteDTO(
        @NotBlank
        @NotEmpty(message = "Nome não pode ser nulo ou vazio")
        String nome,
        @NotBlank(message = "Email não pode ser nulo ou vazio")
        @Email(message = "Email com formato inválido")
        String email,
        @NotBlank(message = "Telefone não pode ser nulo ou vazio")
        String telefone,
        @NotBlank(message = "Senha não pode ser nulo ou vazio")
        String senha,
        @NotBlank(message = "CPF não pode ser nulo ou vazio")
        String cpf,
        Endereco endereco
) {
}
