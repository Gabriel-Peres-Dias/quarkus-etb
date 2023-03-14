package br.com.oficina.model;

import br.com.oficina.endereco.Endereco;
import br.com.oficina.enuns.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cpf;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

}
