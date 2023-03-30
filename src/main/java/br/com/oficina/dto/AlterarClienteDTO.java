package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record AlterarClienteDTO(
        @NotNull(message = "ID não pode ser nulo")
        Long id,
        @NotEmpty(message = "Nome não pode ser nulo ou vazio")
        String nome,
        @Email(message = "Email com formato inválido")
        @NotEmpty(message = "Email não pode ser nulo ou vazio")
        String email,
        @NotEmpty(message = "Telefone não pode ser nulo ou vazio")
        String telefone,
        @NotEmpty(message = "Senha não pode ser nulo ou vazio")
        String senha,
        @NotEmpty(message = "CPF não pode ser nulo ou vazio")
        String cpf,
        @Valid
        @NotNull(message = "Endereço não pode ser nulo")
        Endereco endereco
) {

}
