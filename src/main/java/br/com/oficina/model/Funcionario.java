package br.com.oficina.model;

import br.com.oficina.dto.AlterarFuncionarioDTO;
import br.com.oficina.dto.CadastroFuncionarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_FUNCIONARIO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private boolean status;

    public Funcionario(CadastroFuncionarioDTO funcionarioDTO) {
        this.nome = funcionarioDTO.nome();
        this.matricula = funcionarioDTO.matricula();
        this.status = true;
    }

    public Funcionario(AlterarFuncionarioDTO funcionarioDTO) {
        this.id = funcionarioDTO.id();
        this.nome = funcionarioDTO.nome();
        this.matricula = funcionarioDTO.matricula();
        this.status = true;
    }

    public void desativar() {
        this.status = false;
    }
}
