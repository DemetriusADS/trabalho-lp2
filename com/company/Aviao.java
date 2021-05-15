package com.company;

import java.util.Objects;

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

    public int getAssentosLivres() {
        int count = 0;

        for (Passageiro assento : this.assentos) {
            count += assento == null ? 1 : 0;
        }

        return count;
    }

    public Passageiro[] getAssentosDetalhados(){
        return this.assentos;
    }

    private int searchPassageiroByCpf(String cpf){
        int counter = 0;
        int index = -1;

        while(counter < this.assentos.length){
            if(this.assentos[counter] != null && Objects.equals(this.assentos[counter].getCpf(), cpf)){
                index = counter;
                return index;
            }else{
                counter ++;
            }
        }
        return index;
    }

    public boolean reservarAssento(int assento, Passageiro passageiro) throws Exception {
        boolean found;
        int counter = 0;

        if(this.assentos[assento - 1] == null){

            found = this.searchPassageiroByCpf(passageiro.getCpf()) > -1;

            if(!found){
                this.assentos[assento - 1] = passageiro;
                return true;
            }else{
                throw new Exception("O passageiro já possui reserva neste vôo");
            }
        }
        throw new Exception("Assento já ocupado.");
    }

    public void cancelarReserva(Passageiro passageiro) throws  Exception{
        int index = this.searchPassageiroByCpf(passageiro.getCpf());

        if(index == -1){
            throw new Exception("Passageiro não encontrado neste vôo");
        }

        this.assentos[index] = null;
    }

    public Passageiro[] getReservas(){
        int assentosComReserva = this.getAssentos() - this.getAssentosLivres();
        Passageiro[] passageiros = new Passageiro[this.getAssentos() - this.getAssentosLivres()];
        int indexAux = 0;
        for(Passageiro assento : this.assentos){
            if(assento != null){
                passageiros[indexAux] = assento;
                indexAux++;
            }
        }
        return passageiros;
    }
}
