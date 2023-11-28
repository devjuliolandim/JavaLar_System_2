package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Respostas {

	public String retornarNome(List<DadosDeCadaAluno> lista) {

		Map<String, Integer> frequenciaNomes = new HashMap<>();
		
		for(DadosDeCadaAluno aluno : lista) {
			
			frequenciaNomes.put(aluno.getNome(), frequenciaNomes.getOrDefault(aluno.getNome(), 0) + 1);	
			
		}
		
		String nomeMaisRepetido = Collections.max(frequenciaNomes.entrySet(), Map.Entry.comparingByValue()).getKey();
		
		return nomeMaisRepetido;
	}
	
	public String retornarMatricula(List<DadosDeCadaAluno> lista) {

		Map<String, Integer> frequenciaMatriculas = new HashMap<>();
		
		for(DadosDeCadaAluno aluno : lista) {
			
			frequenciaMatriculas.put(aluno.getMatricula(), frequenciaMatriculas.getOrDefault(aluno.getMatricula(), 0) + 1);	
			
		}
		
		String matriculaMaisRepetida = Collections.max(frequenciaMatriculas.entrySet(), Map.Entry.comparingByValue()).getKey();
		
		return matriculaMaisRepetida;
	}

	public String retornarPlanetaQueMaisMorreu(int[] planetasComMaisMortes) {

		int maior = 0;

		for (int i = 0; i < 7; i++) {

			if (planetasComMaisMortes[i] > planetasComMaisMortes[maior]) {

				maior = i;

			}

		}

		if (maior == 0) {

			return "Python";

		} else if (maior == 1) {

			return "Java Script";

		} else if (maior == 2) {

			return "Ruby on Rails";

		} else if (maior == 3) {

			return "PHP";

		} else if (maior == 4) {

			return "C#";

		} else if (maior == 5) {

			return "C++";

		} else if (maior == 6) {

			return "C";
		}

		return "";

	}

	public String retornarPlanetaQueMaisViveu(int[] planetasComMaisVidas) {

		int maior = 0;

		for (int i = 0; i < 7; i++) {

			if (planetasComMaisVidas[i] > planetasComMaisVidas[maior]) {

				maior = i;

			}

		}

		if (maior == 0) {

			return "Python";

		} else if (maior == 1) {

			return "Java Script";

		} else if (maior == 2) {

			return "Ruby on Rails";

		} else if (maior == 3) {

			return "PHP";

		} else if (maior == 4) {

			return "C#";

		} else if (maior == 5) {

			return "C++";

		} else if (maior == 6) {

			return "C";
		}

		return "";

	}

	public String retornarQuadranteBugs(int[] quadranteBugs) {
		
		int maior = 0;
		
		for(int i = 0; i<4; i++) {
			
			if(quadranteBugs[i]> quadranteBugs[maior]) {
				
				maior = i;
			}
		
			
		}
		
		
		if(maior == 0) {
			
			return "1";
		
		}else if(maior == 1) {
			
			return "2";
		
		}else if(maior == 2) {
			
			return "3";
		
		}else if (maior == 3) {
			
			return "4";
		}
		
		
		
		
		
		
		return null;
	}
	
	public String retornarQuadranteDevs(int[] quadranteDevs) {
		
		int maior = 0;
		
		for(int i = 0; i<4; i++) {
			
			if(quadranteDevs[i]> quadranteDevs[maior]) {
				
				maior = i;
			}
		
			
		}
		
		
		if(maior == 0) {
			
			return "1";
		
		}else if(maior == 1) {
			
			return "2";
		
		}else if(maior == 2) {
			
			return "3";
		
		}else if (maior == 3) {
			
			return "4";
		}
		
		
		
		
		
		
		return null;
	}
	
	public String retornarInstantesAnalisadosPelaTurma(int instantes) {
		
		String resposta = String.valueOf(instantes);
		
		return resposta;
	}

	public List<String> retornarListaDasVelocidades(int[] velocidades, int instantes){
		
		List<String> lista = new ArrayList<>();
		
		String[] linguagens = {"Python: " , "JavaScript: ","Ruby on Rails: ","PHP: ","C#: ","C++: ","C: "};
		
		float[] velocidadesMedias = new float[7];
		
		for(int i = 0; i<7; i++) {
			
			velocidadesMedias[i] =(float) velocidades[i]/instantes; 
			
		}
		
		
		for(int i = 0 ; i <7; i++) {
			
			
			lista.add(i, linguagens[i] + String.valueOf(velocidadesMedias[i]));
			
			
		}
	
		
		
		return lista;
		
	}
	
	public String retornarBugsGerados(int somatorioBugs) {
		
		String somatorio = String.valueOf(somatorioBugs);
		
		
		return somatorio;
		
	}
	
	public String retornarDevsGerados(int somatorioDevs) {
		
		String somatorio = String.valueOf(somatorioDevs);
		
		return somatorio;
	}
	
	public String retornarHorasTotais(int somatorioHoras) {
		
		String somatorio = String.valueOf(somatorioHoras);
		
		return somatorio;
	}

	public String retornarAnosTotais(int somatorioAnos) {
		
		String somatorio = String.valueOf(somatorioAnos);
		
		return somatorio;
		
	}

	
	


}
