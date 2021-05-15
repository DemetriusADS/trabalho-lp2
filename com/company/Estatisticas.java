package com.company;

public class Estatisticas {
    protected float percentualTotal, criancas, adolescente, adulto, idoso;
    protected Voo voo;

    Estatisticas(Voo voo){
        this.voo = voo;
        this.execute();
    }

    protected void execute(){
        int capacidade = this.voo.getCapacidade();
        int criancas = 0;
        int adultos = 0;
        int idosos = 0;
        int adolescentes = 0;

        Passageiro[] passageiros = this.voo.getAssentosComDetalhes();
        for (Passageiro passageiro : passageiros) {
            if (passageiro != null) {
                switch (passageiro.categoria) {
                    case "Crianca":
                        criancas += 1;
                        break;
                    case "Adolescente":
                        adolescentes += 1;
                        break;
                    case "Adulto":
                        adultos += 1;
                        break;
                    case "Idoso":
                        idosos += 1;
                        break;
                    default:
                        break;
                }
            }
        }
        this.percentualTotal = (float)((criancas + adolescentes + adultos + idosos)* 100 / capacidade) ;
        this.criancas = (float)((criancas)* 100 / capacidade) ;
        this.adolescente = (float)(( adolescentes ) * 100 / capacidade) ;
        this.adulto = (float)(adultos * 100 / capacidade) ;
        this.idoso = (float)(idosos * 100 / capacidade) ;
    }

    public float getAdolescente() {
        return this.adolescente;
    }
    public float getAdulto(){
        return this.adulto;
    }

    public float getCriancas(){
        return this.criancas;
    }

    public float getIdoso() {
        return this.idoso;
    }

    public float getPercentualTotal() {
        return this.percentualTotal;
    }

    public Passageiro[] getReservas(Voo voo){
        return voo.getReservas();

    }
}
