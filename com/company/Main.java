package com.company;

public class Main {

    public static void main(String[] args) {
	    PassageiroUtil passageiro = new PassageiroUtil();
	    Voo[] voos = new Voo[4];
	    Aviao CRJ200 = new Aviao("Bombardier CRJ 200", 50);
	    Aviao E195 = new Aviao("Embraer 195", 30);

	    voos[0] = new Voo(1797, "Local A", "Local B", CRJ200, 7,
				45,8, 55);

		passageiro.setPassageiro("111.111.111-11", "Demetrius Araujo", "Adulto");
		passageiro.setPassageiro("111.111.111-12", "Demetrius Araujo", "Adulto");

		try {
			Passageiro currentPassageiro = passageiro.getPassageiro("111.111.111-11");
			Passageiro currentPassageiro2 = passageiro.getPassageiro("111.111.111-12");

			voos[0].fazerReserva(1, currentPassageiro);
			voos[0].fazerReserva(1, currentPassageiro2);

			for(int i = 0; i< 5; i++){
				System.out.println("Assentos: "+voos[0].getAssentosComDetalhes()[i]);
			}

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
