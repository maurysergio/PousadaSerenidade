
package Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cliente")
    private int IDCliente;

    private String nome;

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    private String cpf;

  // ClienteModel
@OneToOne(mappedBy = "cliente",
          cascade = CascadeType.ALL)
private ContatoModel contato;

public ContatoModel getContato() {
    return contato;
}

public void setContato(ContatoModel contato) {
    this.contato = contato;
}
    
}