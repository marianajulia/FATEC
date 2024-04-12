package br.com.fatec.ProjetoDados.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name= "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 25)
    private Role role;


    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;

    @Column(name = "criado_por")
    private String criadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    public Usuario(Long id, String username, String password, Role role, LocalDateTime dataCriacao, LocalDateTime dataModificacao, String criadoPor, String modificadoPor) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.criadoPor = criadoPor;
        this.modificadoPor = modificadoPor;
    }


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Usuario usuario = (Usuario) o;

        return Objects.equals(id, usuario.id);
    }


    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Usuario(" + "id= " + id + ")";
    }


    public enum Role{
        ROLE_ADMIN, ROLE_CLIENTE
    }

}
