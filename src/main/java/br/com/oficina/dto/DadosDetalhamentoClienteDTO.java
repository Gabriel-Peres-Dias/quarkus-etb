package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;
import br.com.oficina.model.Cliente;

public record DadosDetalhamentoClienteDTO(
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco
) {
    public DadosDetalhamentoClienteDTO(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.getEndereco());
    }
}
