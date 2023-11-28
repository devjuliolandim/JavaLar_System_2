package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Respostas;

public class GravarArquivoDeSaida {

	public GravarArquivoDeSaida(Respostas resposta, ObterDadosDoBanco obter) {


		JFileChooser escolherArquivo = new JFileChooser();
		escolherArquivo.setDialogTitle("Escolha onde salvar o seu arquivo");

		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");
		escolherArquivo.setFileFilter(filtro);

		int resultado = escolherArquivo.showSaveDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {

			String caminhoDoArquivo = escolherArquivo.getSelectedFile().getAbsolutePath();

			try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminhoDoArquivo))) {

				escrever.write(resposta.retornarMatricula(obter.getLista()) + " - " + resposta.retornarNome(obter.getLista()) + ", " + resposta.retornarPlanetaQueMaisMorreu(obter.getQuemTemMaisMortes()) + ", " + resposta.retornarPlanetaQueMaisViveu(obter.getQuemTemMaisVidas()) + ", " + resposta.retornarQuadranteBugs(obter.getQualQuadranteBugs()));

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
