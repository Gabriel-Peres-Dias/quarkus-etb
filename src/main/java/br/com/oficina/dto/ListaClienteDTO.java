package br.com.oficina.dto;

import br.com.oficina.endereco.Endereco;
import br.com.oficina.enuns.Perfil;
import br.com.oficina.model.Cliente;

public record ListaClienteDTO(
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco
) {
    public ListaClienteDTO(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.getEndereco());
    }
}
