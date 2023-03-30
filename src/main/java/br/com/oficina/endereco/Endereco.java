package br.com.oficina.endereco;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Data
@Embeddable
public class Endereco {

    @NotEmpty(message = "Logradouro não pode ser nulo ou vazio")
    private String logradouro;
    @NotEmpty(message = "Bairro não pode ser nulo ou vazio")
    private String bairro;
    @NotEmpty(message = "CEP não pode ser nulo ou vazio")
    private String cep;
    @NotEmpty(message = "Número não pode ser nulo ou vazio")
    private String numero;
    @NotEmpty(message = "UF não pode ser nulo ou vazio")
    private String uf;
    @NotEmpty(message = "Cidade não pode ser nulo ou vazio")
    private String cidade;
    private String complemento;
}
