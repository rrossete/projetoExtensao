package ufjf.br.models;

import java.io.Serializable;

public enum Semana implements Serializable {
    SEGUNDA("Segunda-Feira"),
    TERCA("Terça-Feira"),
    QUARTA("Quarta-Feira"),
    QUINTA("Quinta-Feira"),
    SEXTA("Sexta-Feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private final String nome;

    Semana(String nome){
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public static Semana[] Semana(){
        Semana[] valores = Semana.values();
        return valores;
    }
}
