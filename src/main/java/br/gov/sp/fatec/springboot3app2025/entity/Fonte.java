package br.gov.sp.fatec.springboot3app2025.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fon_fonte")
public class Fonte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fon_id")
    @Getter
    private Long id;

    @Column(name = "fon_descritivo", unique = true)
    @Getter
    @Setter
    private String descritivo;

    @Column(name = "fon_preco_sugerido")
    @Getter
    @Setter
    private Float precoSugerido;

    @Column(name = "fon_data_lancamento", nullable = false)
    @Getter
    @Setter
    private LocalDate dataLancamento;

    @Column(name = "fon_potencia_real")
    @Getter
    @Setter
    private Integer potenciaReal; 

    @Column(name = "fon_potencia_nominal", nullable = false)
    @Getter
    @Setter
    private Integer potenciaNominal;
    
}
