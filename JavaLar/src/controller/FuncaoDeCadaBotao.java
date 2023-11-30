package controller;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.GravarArquivoDeSaida;
import model.LerDadosDoArquivo;
import model.LerDadosDeOutrosParticipantes;
import view.Coordenada;
import view.PainelDoPlano;

public class FuncaoDeCadaBotao {

	private LerDadosDeOutrosParticipantes lerDadosDeOutrosParticipantes;
	
	private String nomeDoArquivo;

	private int quantidadeDeBugs;
	private int quantidadeDeDevs;

	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}

	public void processarProximoInstante(List<String[]> infosDoArquivoSelecionado, Memoria memoria,
			PainelDoPlano painelDoPlano) {

		interpretarDadosLidos(infosDoArquivoSelecionado, memoria, painelDoPlano);
		
		painelDoPlano.adicionarImagensDosBugs(quantidadeDeBugs);
		painelDoPlano.adicionarImagemDosDevs(quantidadeDeDevs);
		
		for (Coordenada coordenada : painelDoPlano.getCoordenadasOcupadasPorPlanetas()) {
			coordenada.remove(coordenada.getImagem());
		}
		
		painelDoPlano.getCoordenadasOcupadasPorPlanetas().clear();
		painelDoPlano.adicionarImagensDosPlanetas();
		
	}

	private void interpretarDadosLidos(List<String[]> infos, Memoria memoria, PainelDoPlano painel) {

		if (!infos.isEmpty()) {

			String[] linha = infos.remove(0);

			for (int i = 1; i < linha.length - 2; i++) {

				try {

					int instantes = Integer.parseInt(linha[i]);

					Planetas planeta = memoria.getPlanetas().get(i - 1);

					planeta.mover(instantes);

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

			}

			// CRIAÇÃO DE BUGS E DEVS
			quantidadeDeDevs = Integer.parseInt(linha[linha.length - 1]);
			quantidadeDeBugs = Integer.parseInt(linha[linha.length - 2]);

		}

	}

	public List<String[]> lerNovoArquivoDeEntrada() {

		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setCurrentDirectory(new File("Arquivos de Instantes"));

		fileChooser.setFileFilter(new FileNameExtensionFilter("csv", "csv"));

		int resultado = fileChooser.showOpenDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {

			File arquivoSelecionado = fileChooser.getSelectedFile();

			String diretorioDoArquivo = arquivoSelecionado.getAbsolutePath();

			nomeDoArquivo = arquivoSelecionado.getName();

			return new LerDadosDoArquivo().lerDadosDoArquivo(diretorioDoArquivo);

		}
		return null;

	}
	
	public void gravarRelatorio(Relatorio relatorio, PainelDoPlano painelDoPlano) {

		relatorio.setNomeArquivo(nomeDoArquivo);

		relatorio.relatorioQuadrantesBugs(painelDoPlano.getCoordenadasOcupadasPorBugs());
		relatorio.relatorioQuadrantesDevs(painelDoPlano.getCoordenadasOcupadasPorDesenvolvedores());

		relatorio.enviarRelatorioParaOBanco();

	}

	public void lerDadosDeOutrosParticipantes() {

		lerDadosDeOutrosParticipantes = new LerDadosDeOutrosParticipantes();
		lerDadosDeOutrosParticipantes.obterDadosDoBanco();

	}

	public void gravaArquivoDeSaida(Respostas respostas) {

		new GravarArquivoDeSaida(respostas, lerDadosDeOutrosParticipantes);

	}

	

}
