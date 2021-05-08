package com.company;

public class Passageiro {
    public String nomeCompleto;
    private String cpf;
    public String categoria;

    Passageiro(String cpf, String nomeCompleto, String categoria){
       this.setCpf(cpf);
       this.nomeCompleto = nomeCompleto;
       this.categoria = categoria;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
