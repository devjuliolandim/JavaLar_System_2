package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerDadosDoArquivo {

	public  List<String[]> lerDadosDoArquivo(String caminhoArquivo) {

		List<String[]> informacoes = new ArrayList<String[]>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivo))) {

			String informacao;
			
			bufferedReader.readLine();
			
			
			while ((informacao = bufferedReader.readLine()) != null) {

				String[] campo = informacao.split(",");

				informacoes.add(campo);
				
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		

		return informacoes;
	}

}
