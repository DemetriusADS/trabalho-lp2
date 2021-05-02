package com.company;

public class Aviao {
    public String nome;
    protected Passageiro[] assentos;

    Aviao(String nome, int assentos){
        this.nome = nome;
        this.assentos = new Passageiro[assentos];
    }

    public int getAssentos() {
        return this.assentos.length;
    }

    public Passageiro[] getAssentosDetalhados(){
        return this.assentos;
    }

    public boolean reservarAssento(int assento, Passageiro passageiro) throws Exception {
        boolean found = false;
        int counter = 0;

        if(this.assentos[assento - 1] == null){

            while(this.assentos.length > counter && !found){
                if(this.assentos[counter] != null && this.assentos[counter].cpf == passageiro.cpf){
                        found = true;
                }
                counter ++;
            }

            if(!found){
                this.assentos[assento - 1] = passageiro;
                return true;
            }else{
                throw new Exception("O passageiro já possui reserva neste vôo");
            }
        }
        throw new Exception("Assento já ocupado.");
    }
}
