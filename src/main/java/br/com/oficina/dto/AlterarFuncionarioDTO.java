package br.com.oficina.dto;

import javax.validation.constraints.NotEmpty;

public record AlterarFuncionarioDTO(
        @NotEmpty
        Long id,
        @NotEmpty
        String nome,
        @NotEmpty
        String matricula
) {
}
