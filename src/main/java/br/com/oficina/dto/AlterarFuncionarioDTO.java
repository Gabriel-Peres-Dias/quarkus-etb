package br.com.oficina.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record AlterarFuncionarioDTO(
        @NotNull(message = "ID não pode ser nulo")
        Long id,
        @NotEmpty(message = "Nome não pode nulo ou vazio")
        String nome,
        @NotEmpty(message = "Matrícula não pode nulo ou vazio")
        String matricula
) {
}
