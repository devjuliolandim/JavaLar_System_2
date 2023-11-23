package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Memoria;

public class Janela extends JFrame {

	private PainelDoPlano exibirPlanetas;
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

		exibirPlanetas = new PainelDoPlano(memoria);
		add(exibirPlanetas, BorderLayout.CENTER);

		painelDeBotoes = new PainelBotoes(memoria, exibirPlanetas);
		add(painelDeBotoes, BorderLayout.EAST);

	}

}
