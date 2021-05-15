package com.company;

public class Main {


	private static int searchVooIndex(Voo[] voos, int vooNumero){
		int index = -1;
		int arrayLength = voos.length;
		int iterator = 0;

		while(iterator < arrayLength){
			if(voos[iterator].numero == vooNumero){
				index = iterator;
				return index;
			}else{
				iterator ++;
			}
		}
		return index;
	}
	

    public static void main(String[] args) {
	    PassageiroUtil passageiro = new PassageiroUtil();
	    Voo[] voos = new Voo[4];
	    Aviao CRJ200 = new Aviao("Bombardier CRJ 200", 50);
	    Aviao E195 = new Aviao("Embraer 195", 30);

	    //CADASTRAR VOOS
	    voos[0] = new Voo(1797, "Local A", "Local B", CRJ200, 7,
				45,8, 55);

	    //COMO CADASTRAR PASSAGEIROS
		passageiro.setPassageiro("111.111.111-11", "Demetrius Araujo", "Adulto");
		passageiro.setPassageiro("111.111.111-12", "Demetrius Araujo", "Crianca");
		passageiro.setPassageiro("111.111.111-13", "Demetrius Araujo", "Adolescente");
		passageiro.setPassageiro("111.111.111-14", "Demetrius Araujo", "Idoso");

		try {
			//COMO PUXAR AS INFORMAÇOES DO PASSAGEIRO. SE ELE NAO ESTIVER CADASTRADO, SERÁ DISPARADA UMA EXCEPTION
			Passageiro currentPassageiro = passageiro.getPassageiro("111.111.111-11");
			Passageiro currentPassageiro2 = passageiro.getPassageiro("111.111.111-12");
			Passageiro currentPassageiro3 = passageiro.getPassageiro("111.111.111-13");
			Passageiro currentPassageiro4 = passageiro.getPassageiro("111.111.111-14");

			//RETORNA OS ASSENTOS LIVRES DO VOO
			voos[0].getAssentosLivres();


			/*
				A QUESTAO PEDE PARA O PASSAGEIRO INFORMAR O NUMERO DO VOO QUE ELE QUER. PARA ISSO, BASTA PASSAR O NUMERO DO VOO
				PARA A FUNCAO PRIVADA QUE ESTA LOGO ACIMA (this.searchVooIndex) PASSANDO O ARRAY DE VOOS E O NUMERO DO VOO;
				SE FOR ENCONTRADO, SERA RETORNADO O INDEX DO VOO; CASO CONTRARIO, SERA RETORNADO -1;
			 */
			//COMO FAZER UMA RESERVA. SE O ASSENTO ESTIVER OCUPADO AO SE O PASSAGEIRO ESTIVER NO VOO, UMA EXCEPTION SERA DISPARADA
			voos[0].fazerReserva(1, currentPassageiro);
			voos[0].fazerReserva(2, currentPassageiro2);
			voos[0].fazerReserva(3, currentPassageiro3);
			voos[0].fazerReserva(4, currentPassageiro4);

			//COMO OBTER AS ESTATISTICAS
			Estatisticas estatisticas = new Estatisticas(voos[0]);
			System.out.println("Total %: " + estatisticas.getPercentualTotal());
			System.out.println("Criancas %: " + estatisticas.getCriancas());
			System.out.println("Idosos %: " + estatisticas.getIdoso());
			System.out.println("Adultos %: " + estatisticas.getAdulto());
			System.out.println("Adolescentes %: " + estatisticas.getAdolescente());

			//COMO CANCELAR UMA RESERVA. SE O PASSAGEIRO NAO ESTIVER NO VOO, SERA DISPARADA UMA EXCEPTION
			voos[0].cancelarReserva(currentPassageiro);
//			System.out.println("Reserva cancelada com sucesso");

			for(int i = 0; i< 5; i++){
				System.out.println("Assentos: "+voos[0].getAssentosComDetalhes()[i]);
			}

			//Passando o index do voo, irá retornar todas as reservas.
			//Se der um .length, será possivel obter a quantidade de reserva do voo;
			Passageiro[] passageiros = estatisticas.getReservas(voos[0]);

			//Detalhamento do voo;
			for(Passageiro reserva : passageiros){
				System.out.println(reserva.getCpf());
				System.out.println(reserva.categoria);
				System.out.println(reserva.nomeCompleto);
			}



		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
