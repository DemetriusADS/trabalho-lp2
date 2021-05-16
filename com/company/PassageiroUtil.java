package com.company;

import java.util.ArrayList;

public class PassageiroUtil {
    protected ArrayList<Passageiro> passageiro = new ArrayList();

    public Passageiro getPassageiro(String cpf) throws Exception {
        int index = 0;
        boolean found = false;
        int count = 0;
        
        while(count < this.passageiro.size() && !found){
        	System.out.println(this.passageiro.get(count).getCpf() + " == " +  cpf );
            if(this.passageiro.get(count).getCpf() == cpf){
                index = count;
                found = true;
            }
            count ++;
        }
        if(!found){
            throw new Exception("Usuário não encontrado");
        }
        return this.passageiro.get(index);
    }

    public void setPassageiro(String cpf, String nomeCompleto, String categoria){
        this.passageiro.add(new Passageiro(cpf, nomeCompleto, categoria));
    }
}
