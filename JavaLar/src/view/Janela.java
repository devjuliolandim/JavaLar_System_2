package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Memoria;

public class Janela extends JFrame {

	private PainelDoPlano painelDoPlano;
	private PainelBotoes painelDeBotoes;

	public static Memoria memoria = new Memoria();

	public Janela() {

		this.setTitle("Sistema JavaLar");
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		configurarPaineis();
	

		this.setVisible(true);
	}

	public void configurarPaineis() {

		painelDoPlano = new PainelDoPlano(memoria);
		add(painelDoPlano, BorderLayout.CENTER);

		painelDeBotoes = new PainelBotoes(memoria, painelDoPlano);
		add(painelDeBotoes, BorderLayout.EAST);

	}

}
