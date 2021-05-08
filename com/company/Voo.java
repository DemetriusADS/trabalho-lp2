package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Voo {
    public int numero;
    public String localSaida, localDestino;
    protected Aviao aviao;
    public Calendar horarioSaida, horarioChegada;

    Voo(int numero, String localSaida, String localDestino, Aviao aviao,
        int horarioChegada, int minutoChegda, int horarioSaida, int minutoSaida){

        SimpleDateFormat format = new SimpleDateFormat("HH [às] mm");
        Calendar horaChegada = new GregorianCalendar();
        Calendar horaSaida = new GregorianCalendar();

        horaChegada.set(Calendar.HOUR, horarioChegada);
        horaChegada.set(Calendar.MINUTE, minutoChegda);
        horaSaida.set(Calendar.HOUR, horarioSaida);
        horaSaida.set(Calendar.MINUTE, minutoSaida);

        this.aviao = aviao;
        this.horarioChegada = horaChegada;
        this.localDestino = localDestino;
        this.localSaida = localSaida;
        this.numero = numero;
        this.localSaida = localSaida;
        this.horarioSaida = horaSaida;
    }

    public int getNumero(){
        return this.numero;
    }

    public int getCapacidade(){
        return this.aviao.getAssentos();
    }

    public Passageiro[] getAssentosComDetalhes(){
        return this.aviao.getAssentosDetalhados();
    }

    public boolean fazerReserva(int numeroDoAssento, Passageiro passageiro) throws Exception {
        try{
            return this.aviao.reservarAssento(numeroDoAssento, passageiro);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public int getAssentosLivres(){
        return this.aviao.getAssentosLivres();
    }

    public void cancelarReserva(Passageiro passageiro) throws Exception {
        try{
            this.aviao.cancelarReserva(passageiro);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
