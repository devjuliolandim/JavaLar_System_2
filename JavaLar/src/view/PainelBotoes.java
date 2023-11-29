package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.FuncaoDeCadaBotao;
import controller.Memoria;
import controller.Respostas;
import controller.Planetas;
import controller.Relatorio;
import model.RelatorioDAO;

public class PainelBotoes extends JPanel implements ActionListener {

	private Botao processarProximoInstante;
	private Botao lerNovoArquivoDeEntrada;
	private Botao gravarRelatorio;
	private Botao lerDadosDeOutrosParticipantes;
	private Botao gravarArquivoDeSaida;
	private FuncaoDeCadaBotao funcaoDeCadaBotao = new FuncaoDeCadaBotao();

	private List<String[]> infosDoArquivoSelecionado;

	private Memoria memoria;

	private PainelDoPlano painelDoPlano;

	private Relatorio relatorio;

	public PainelBotoes(Memoria memoria, PainelDoPlano painelPlanetas) {

		this.painelDoPlano = painelPlanetas;
		this.memoria = memoria;

		relatorio = new Relatorio(this.memoria);

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(250, 1000));
		setLayout(new GridLayout(5, 1));

		instanciarBotoes();
		adicionarBotoes();

	}

	private void instanciarBotoes() {

		processarProximoInstante = new Botao("Processar Próximo Instante");
		lerNovoArquivoDeEntrada = new Botao("Ler Novo Arquivo de Entrada");
		gravarRelatorio = new Botao("Gravar Relatório");
		lerDadosDeOutrosParticipantes = new Botao("Ler Dados de Outros Participantes");
		gravarArquivoDeSaida = new Botao("Gravar Arquivo de Saída");

	}

	private void adicionarBotoes() {

		processarProximoInstante.addActionListener(this);
		add(processarProximoInstante);

		lerNovoArquivoDeEntrada.addActionListener(this);
		add(lerNovoArquivoDeEntrada);

		gravarRelatorio.addActionListener(this);
		add(gravarRelatorio);

		lerDadosDeOutrosParticipantes.addActionListener(this);
		add(lerDadosDeOutrosParticipantes);

		gravarArquivoDeSaida.addActionListener(this);
		add(gravarArquivoDeSaida);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == processarProximoInstante) {

			funcaoDeCadaBotao.processarProximoInstante(infosDoArquivoSelecionado, memoria, painelDoPlano);
			painelDoPlano.adicionarImagensDosBugs(funcaoDeCadaBotao.getQuantidadeDeBugs());
			painelDoPlano.adicionarImagemDosDevs(funcaoDeCadaBotao.getQuantidadeDeDevs());

			for (Coordenada coordenada : painelDoPlano.getCoordenadasOcupadasPorPlanetas()) {
				coordenada.remove(coordenada.getImagem());
			}

			painelDoPlano.adicionarImagensDosPlanetas();

		} else if (e.getSource() == lerNovoArquivoDeEntrada) {

			infosDoArquivoSelecionado = funcaoDeCadaBotao.lerNovoArquivoDeEntrada();

		} else if (e.getSource() == gravarRelatorio) {

			relatorio.setNomeArquivo(funcaoDeCadaBotao.getNomeDoArquivo());

			relatorio.relatorioQuadrantesBugs(painelDoPlano.getCoordenadasOcupadasPorBugs());
			relatorio.relatorioQuadrantesDevs(painelDoPlano.getCoordenadasOcupadasPorDesenvolvedores());

			relatorio.enviarRelatorioParaOBanco();

		} else if (e.getSource() == lerDadosDeOutrosParticipantes) {

			funcaoDeCadaBotao.lerDadosDeOutrosParticipantes();

		} else if (e.getSource() == gravarArquivoDeSaida) {

			Respostas respostas = new Respostas();

			funcaoDeCadaBotao.gravaArquivoDeSaida(respostas);

		}

	}

}
