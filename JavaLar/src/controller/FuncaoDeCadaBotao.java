package controller;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.GravarArquivoDeSaida;
import model.LerDadosDoArquivo;
import model.ObterDadosDoBanco;
import view.PainelDoPlano;

public class FuncaoDeCadaBotao {

	private ObterDadosDoBanco obterDadosDoBanco = new ObterDadosDoBanco();

	private String nomeDoArquivo;

	public int quantidadeDeBugs;
	public int quantidadeDeDevs;

	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}

	public int getQuantidadeDeBugs() {
		return quantidadeDeBugs;
	}

	public int getQuantidadeDeDevs() {
		return quantidadeDeDevs;
	}

	public void lerDadosDeOutrosParticipantes() {

		obterDadosDoBanco.obterDadosDoBanco();

	}

	public void processarProximoInstante(List<String[]> infos, Memoria memoria, PainelDoPlano painel) {

		if (!infos.isEmpty()) {

			String[] linha = infos.remove(0);

			for (int i = 1; i < linha.length - 2; i++) {

				try {

					int instantes = Integer.parseInt(linha[i]);

					Planetas planeta = memoria.getPlanetas().get(i - 1);

					planeta.mover(instantes);
					
					//new Verificacao(painel).verificarColisaoComEntidadaes(planeta);
					

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

			}

			// CRIAÇÃO DE BUGS E DEVS
			quantidadeDeDevs = Integer.parseInt(linha[linha.length - 1]);
			quantidadeDeBugs = Integer.parseInt(linha[linha.length - 2]);

		} else {

			System.out.println("Não há mais informações disponíveis para mostrar");
		}

	}

	public List<String[]> lerNovoArquivoDeEntrada() {

		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setCurrentDirectory(new File(
				"C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Arquivos de Instantes"));

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

	public void gravaArquivoDeSaida(Respostas respostas) {

		new GravarArquivoDeSaida(respostas, obterDadosDoBanco);

	}

}
