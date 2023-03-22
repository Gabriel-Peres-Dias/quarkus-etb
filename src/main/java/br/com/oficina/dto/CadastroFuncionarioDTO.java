package br.com.oficina.dto;

import javax.validation.constraints.NotEmpty;

public record CadastroFuncionarioDTO(
        @NotEmpty
        String nome,
        @NotEmpty
        String matricula
) {
}
