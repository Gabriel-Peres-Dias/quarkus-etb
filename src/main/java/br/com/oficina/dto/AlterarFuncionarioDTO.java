package br.com.oficina.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record AlterarFuncionarioDTO(
        @NotNull
        Long id,
        @NotEmpty
        String nome,
        @NotEmpty
        String matricula
) {
}
