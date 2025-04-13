package br.gov.sp.fatec.springboot3app2025.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usr_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "usr_nome")
    @Getter
    @Setter
    private String nome;

    @Column(name = "usr_senha")
    @Getter
    @Setter
    private String senha;
    
}
