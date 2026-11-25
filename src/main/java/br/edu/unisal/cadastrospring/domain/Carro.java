package br.edu.unisal.cadastrospring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Description;

@Entity 
public class Carro {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Description("Identificador único, gerado automaticamente")
    private Long id;

    @Description("Fabricante do veículo")
    private String marca;

    @Description("Modelo do veículo")
    private String modelo;

    @Description("Ano em que o veículo foi fabricado")
    private Integer anoFabricacao;

    @Description("Ano correspondente ao modelo do veículo")
    private Integer anoModelo;

    @Description("Especificação do motor do veículo")
    private String motorizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }
}
