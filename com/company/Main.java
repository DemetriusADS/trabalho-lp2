package com.company;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Main implements ActionListener{
	
	private static JLabel lbTituloCadastro;
	private static JLabel lbInputCpf;	
	private static JTextField inputCpf;
	private static JLabel lbInputNome;
	private static JTextField inputNome;
	private static JLabel lbInputTipo;
	private static JComboBox inputTipo;
	private static JLabel respostaCadastrado;
	private static JButton buttonCadastraPassageiro;
	
	private static JComboBox inputEstatisticas;

	private static JLabel lbStatTitulo;
	private static JLabel lbStatTotal;
	private static JLabel lbStatCrianca;
	private static JLabel lbStatIdoso;
	private static JLabel lbStatAdulto;
	private static JLabel lbStatAdolescente;
	private static JLabel lbStatAssentosLivres;
	
	private static JLabel lbTituloReserva;
	private static JLabel lbInputCpfReserva;
	private static JTextField inputCpfReserva;
	private static JLabel lbInputNrVooReserva;
	private static JComboBox inputNrVooReserva;
	private static JButton verificarPassageiro;
	private static JButton realizarReserva;
	private static JLabel lbAssentoReserva;
	private static JTextField inputAssentoReserva;
	private static JLabel respostaReserva;
	
	private static PassageiroUtil passageiro;
	private static Estatisticas estatisticasVoo;
	private static Estatisticas estatisticasVooNovo;
			
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
    	String[] tipos = {"Adulto","Crianca","Adolecente"};
    	String[] nrVoos = {"1797","4163","1865","4164"}; 
    	
    	
    	passageiro = new PassageiroUtil();
	    Voo[] voos = new Voo[4];
	    Aviao CRJ200 = new Aviao("Bombardier CRJ 200", 50);
	    Aviao E195 = new Aviao("Embraer 195", 30);
	    
	    
	    //CADASTRAR VOOS
	    voos[0] = new Voo(1797, "Local A", "Local B", CRJ200, 7,
				45,8, 55);
	    voos[1] = new Voo(4163, "Local A", "Local B", E195, 11,
				10,12, 05);
	    voos[2] = new Voo(1865, "Local A", "Local B", CRJ200, 6,
				5,7, 20);
	    voos[3] = new Voo(4164, "Local A", "Local B", E195, 16,
				45,17, 40);

	    
	    //COMO CADASTRAR PASSAGEIROS
		passageiro.setPassageiro("11111111111", "Demetrius Araujo", "Adulto");
		passageiro.setPassageiro("11111111112", "Demetrius Araujo", "Crianca");
		passageiro.setPassageiro("11111111113", "Demetrius Araujo", "Adolescente");
		passageiro.setPassageiro("11111111114", "Demetrius Araujo", "Idoso");

		try {
			//COMO PUXAR AS INFORMAÃ‡OES DO PASSAGEIRO. SE ELE NAO ESTIVER CADASTRADO, SERÃ� DISPARADA UMA EXCEPTION
			Passageiro currentPassageiro = passageiro.getPassageiro("11111111111");
			Passageiro currentPassageiro2 = passageiro.getPassageiro("11111111112");
			Passageiro currentPassageiro3 = passageiro.getPassageiro("11111111113");
			Passageiro currentPassageiro4 = passageiro.getPassageiro("11111111114");
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
			estatisticasVoo = new Estatisticas(voos[0]);
			System.out.println("Total %: " + estatisticasVoo.getPercentualTotal());
			System.out.println("Criancas %: " + estatisticasVoo.getCriancas());
			System.out.println("Idosos %: " + estatisticasVoo.getIdoso());
			System.out.println("Adultos %: " + estatisticasVoo.getAdulto());
			System.out.println("Adolescentes %: " + estatisticasVoo.getAdolescente());

			//COMO CANCELAR UMA RESERVA. SE O PASSAGEIRO NAO ESTIVER NO VOO, SERA DISPARADA UMA EXCEPTION
			voos[0].cancelarReserva(currentPassageiro);
//			System.out.println("Reserva cancelada com sucesso");

			for(int i = 0; i< 5; i++){
				System.out.println("Assentos: "+voos[0].getAssentosComDetalhes()[i]);
			}

			//Passando o index do voo, irÃ¡ retornar todas as reservas.
			//Se der um .length, serÃ¡ possivel obter a quantidade de reserva do voo;
			Passageiro[] passageiros = estatisticasVoo.getReservas();

			//Detalhamento do voo;
			for(Passageiro reserva : passageiros){
				System.out.println(reserva.getCpf());
				System.out.println(reserva.categoria);
				System.out.println(reserva.nomeCompleto);
			}

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		//cadastro de passageiro, fazer reserva, puxar as estatísticas e cancelar a reserva
		
		JPanel panelCadastroUsuario = new JPanel();
	    JPanel panelReserva = new JPanel();
	    JPanel panelListaVoo = new JPanel();
	    JPanel panelEstatisticas = new JPanel();
	    JFrame frame = new JFrame();
	    
	    panelCadastroUsuario.setBounds(50, 0, 300,300);
	    panelCadastroUsuario.setLayout(new GridLayout(9,1));
	    
	    panelListaVoo.setBounds(0, 640, 300,300);
	    panelListaVoo.setLayout(new GridLayout(9,1));
	    
	    panelEstatisticas.setBounds(50,320,300,200);
	    panelEstatisticas.setLayout(new GridLayout(8,1));
	    
	    panelReserva.setBounds(400, 0, 300, 300);
	    panelReserva.setLayout(new GridLayout(10,1));
	    
	    //painel de reserva
	    
	    lbTituloReserva = new JLabel("Reservar do voo");
	    panelReserva.add(lbTituloReserva);
	    
	    lbInputCpfReserva = new JLabel("CPF");
	    panelReserva.add(lbInputCpfReserva);
	    
	    inputCpfReserva = new JTextField(11);
	    panelReserva.add(inputCpfReserva);
	    
	    verificarPassageiro = new JButton("Verificar Passageiro");
	    verificarPassageiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//System.out.println(inputCpfReserva.getText());
					Passageiro currentPassageiroVoo = passageiro.getPassageiro(inputCpfReserva.getText());
					respostaReserva.setText("Usuario Verificado!");
				}catch(Exception erro){
					System.out.print(erro.getMessage());
					respostaReserva.setText("Algum erro aconteceu!");
				}
					
			}
	    }); 
	    panelReserva.add(verificarPassageiro);
	    
	    lbAssentoReserva = new JLabel("Assento Desejado");
	    panelReserva.add(lbAssentoReserva);
	    
	    inputAssentoReserva = new JTextField(2);
	    panelReserva.add(inputAssentoReserva);
	    
	    lbInputNrVooReserva = new JLabel("Numero do Voo");
	    panelReserva.add(lbInputNrVooReserva);
	    
	    inputNrVooReserva = new JComboBox(nrVoos);
	    panelReserva.add(inputNrVooReserva);
	    
	    realizarReserva = new JButton("Realizar Reserva");
	    realizarReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int nrVooInt = Integer.valueOf((String)inputNrVooReserva.getSelectedItem());
				int index = searchVooIndex(voos,nrVooInt);
				try {
					//System.out.println(inputCpfReserva.getText());
					//System.out.println(Integer.parseInt(inputAssentoReserva.getText()));
					//System.out.println(index + " - " + nrVooInt);
					Passageiro currentPassageiroVoo = passageiro.getPassageiro(inputCpfReserva.getText());
					voos[index].fazerReserva(Integer.parseInt(inputAssentoReserva.getText()), currentPassageiroVoo);
					respostaReserva.setText("Reserva Realizada com sucesso!");
					System.out.println("Reserva Realizada com sucesso");
				}catch(Exception erro){
					System.out.print(erro.getMessage());
					respostaReserva.setText("Algum erro aconteceu!");
				}	
			}
	    });
	    panelReserva.add(realizarReserva);
	    
	    respostaReserva = new JLabel("");
	    panelReserva.add(respostaReserva);	
	    
	    
	    //painel de estatisticas do voo
	    
	    inputEstatisticas = new JComboBox(nrVoos);
	    inputEstatisticas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int nrVooInt = Integer.valueOf((String)inputEstatisticas.getSelectedItem());
				int index = searchVooIndex(voos,nrVooInt);
				estatisticasVooNovo = new Estatisticas(voos[index]);

				lbStatTitulo.setText("Estatisticas do voo:  " + nrVooInt);
				
				lbStatTotal.setText("Total: " + estatisticasVooNovo.getPercentualTotal()+ "%");
			    lbStatCrianca.setText("Criancas: " + estatisticasVooNovo.getCriancas()+ "%");
			    lbStatIdoso.setText("Idosos: " + estatisticasVooNovo.getIdoso()+ "%");
			    lbStatAdulto.setText("Adultos: " + estatisticasVooNovo.getAdulto()+ "%");
			    lbStatAdolescente.setText("Adolescentes: " + estatisticasVooNovo.getAdolescente()+ "%");
			    lbStatAssentosLivres.setText("Assentos livres: " + voos[index].getAssentosLivres());
			}
	    });
	    panelEstatisticas.add(inputEstatisticas); 
	    
	    lbStatTitulo = new JLabel("Estatisticas do voo");
	    panelEstatisticas.add(lbStatTitulo);
	    lbStatTotal = new JLabel("Total: " + estatisticasVoo.getPercentualTotal()+ "%");
	    panelEstatisticas.add(lbStatTotal);
	    lbStatCrianca = new JLabel("Criancas: " + estatisticasVoo.getCriancas()+ "%");
	    panelEstatisticas.add(lbStatCrianca);
	    lbStatIdoso = new JLabel("Idosos: " + estatisticasVoo.getIdoso()+ "%");
	    panelEstatisticas.add(lbStatIdoso);
	    lbStatAdulto = new JLabel("Adultos: " + estatisticasVoo.getAdulto()+ "%");
	    panelEstatisticas.add(lbStatAdulto);
	    lbStatAdolescente = new JLabel("Adolescentes: " + estatisticasVoo.getAdolescente()+ "%");
	    panelEstatisticas.add(lbStatAdolescente);
	    lbStatAssentosLivres = new JLabel("Assentos livres: " + voos[0].getAssentosLivres());
	    panelEstatisticas.add(lbStatAssentosLivres);
	    
	    //painel cadastro de passageiro
	    lbTituloCadastro = new JLabel("Cadastro de Passageiro");
	    panelCadastroUsuario.add(lbTituloCadastro);
	    
	    lbInputCpf = new JLabel("CPF");
	    panelCadastroUsuario.add(lbInputCpf);
	    
	    inputCpf = new JTextField(11);
	    panelCadastroUsuario.add(inputCpf);
	    
	    lbInputNome = new JLabel("Nome");
	    panelCadastroUsuario.add(lbInputNome);
	    
	    inputNome = new JTextField(100);
	    panelCadastroUsuario.add(inputNome);
	    
	    lbInputTipo  = new JLabel("Tipo");
	    panelCadastroUsuario.add(lbInputTipo);
	    
	    inputTipo = new JComboBox(tipos);
	    inputTipo.addActionListener(new Main());
	    panelCadastroUsuario.add(inputTipo);       
	 
	    buttonCadastraPassageiro = new JButton("Cadastrar");
	    buttonCadastraPassageiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpf = inputCpf.getText();
		    	String nome = inputNome.getText();
		    	Object tipo = inputTipo.getSelectedItem();
		    	
		    	if(cpf != "" && nome != "" && tipo != null) {
		    		passageiro.setPassageiro(cpf, nome, tipo.toString());
		    		respostaCadastrado.setText("Passageiro Cadastrado com Sucesso!");
		    		System.out.println(cpf+" - "+ nome +" - "+ tipo.toString());
		    	}else{
		    		System.out.println("Dados faltantes");
		    		respostaCadastrado.setText("Preencha todos os Campos!");
		    		System.out.println("erro");
		    	}
				
			}
	    }); 
	    panelCadastroUsuario.add(buttonCadastraPassageiro);
	    
	    respostaCadastrado = new JLabel("");
	    panelCadastroUsuario.add(respostaCadastrado);	
	    
	    
	    frame.setSize(900,900);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panelCadastroUsuario);
	    frame.add(panelEstatisticas);
	    frame.add(panelReserva);
	    frame.add(panelListaVoo);
	    
	    frame.setVisible(true);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
    	
	}
}
