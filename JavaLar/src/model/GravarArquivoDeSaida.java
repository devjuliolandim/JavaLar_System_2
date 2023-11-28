package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Respostas;

public class GravarArquivoDeSaida {

	private String matricula;
	private String nome;
	private String planetaMaisMorreu;
	private String planetaMaisViveu;
	private String quadranteBugs;
	private String quadranteDevs;
	private String instantesDaTurma;

	private List<String> velocidadesMedias;
	
	
	private String somatorioBugs;
	private String somatorioDevs;

	public GravarArquivoDeSaida(Respostas resposta, ObterDadosDoBanco obter) {

		preencherVariaveis(resposta, obter);

		JFileChooser escolherArquivo = new JFileChooser();
		escolherArquivo.setDialogTitle("Escolha onde salvar o seu arquivo");

		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");
		escolherArquivo.setFileFilter(filtro);

		int resultado = escolherArquivo.showSaveDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {

			String caminhoDoArquivo = escolherArquivo.getSelectedFile().getAbsolutePath();

			try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminhoDoArquivo))) {

				escrever.write(matricula + " - " + nome + ", " + planetaMaisMorreu + ", " + planetaMaisViveu + ", "
						+ quadranteBugs + ", " + quadranteDevs + ", " + instantesDaTurma + ", ");

				for (int i = 0; i < 7; i++) {
					escrever.write(velocidadesMedias.get(i) + ", ");
				}
				
				escrever.write(somatorioBugs + ", " + somatorioDevs);

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	private void preencherVariaveis(Respostas resposta, ObterDadosDoBanco obter) {
		matricula = resposta.retornarMatricula(obter.getLista());
		nome = resposta.retornarNome(obter.getLista());
		planetaMaisMorreu = resposta.retornarPlanetaQueMaisMorreu(obter.getQuemTemMaisMortes());
		planetaMaisViveu = resposta.retornarPlanetaQueMaisViveu(obter.getQuemTemMaisVidas());
		quadranteBugs = resposta.retornarQuadranteBugs(obter.getQualQuadranteBugs());
		quadranteDevs = resposta.retornarQuadranteDevs(obter.getQualQuadranteDevs());
		instantesDaTurma = resposta.retornarInstantesAnalisadosPelaTurma(obter.getInstantes());
		velocidadesMedias = resposta.retornarListaDasVelocidades(obter.getSomatorioVelocidades(), obter.getInstantes());
		somatorioBugs = resposta.retornarBugsGerados(obter.getSomatorioBugs());
		somatorioDevs = resposta.retornarDevsGerados(obter.getSomatorioDevs());
	
	}

}
