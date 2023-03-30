package br.com.oficina.dto;

import javax.validation.constraints.NotEmpty;

public record CadastroFuncionarioDTO(
        @NotEmpty(message = "Nome não pode ser nulo ou vazio")
        String nome,
        @NotEmpty(message = "Matrículo não pode ser nulo ou vazio")
        String matricula
) {
}
