package model;

import java.util.ArrayList;

public class Relatorio {

	public static void relatorio(ArrayList<Planetas> planetas, ArrayList<CemiterioDePlanetas> cova, int instantes) {

		System.out.println("\n-//-//-//-//- RELATÓRIO -//-//-//-//-\n\n");

		System.out.println("-//-//-//-//- INSTANTES -//-//-//-//-");
		System.out.println("A quantidade de instantes pedida pelo usuário foi de: " + instantes + " instantes.\n\n");

		for (Planetas planeta : planetas) {

			System.out.println("-//-//-//-//- " + planeta.getNome() + " -//-//-//-//-");
			System.out.println("A quantidade de vezes que o planeta " + planeta.getNome() + " colidiu com um bug foi: "
					+ planeta.getBugsCont());
			System.out.println("A quantidade de vezes que o planeta " + planeta.getNome()
					+ " colidiu com um desenvolvedor foi: " + planeta.getDevsCont());
			System.out.println("A velocidade de rotação foi de : " + planeta.getHoras() + " horas por instante");
			System.out.println("A quantidade de dias que se passaram no planeta " + planeta.getNome() + " foram "
					+ Calculos.calculoDias(planeta, instantes) + " dia(s)");
			System.out.println("A quantidade de anos que se passaram no planeta " + planeta.getNome() + " foram "
					+ planeta.getAnos());
			System.out.println("\n\n");
		}

		int size = cova.size();

		System.out.println("-//-//-//-//- EXPLOSÕES -//-//-//-//-");
		if (size == 0) {

			System.out.println("Nenhum planeta explodiu!");

		} else if (size == 1) {

			for (CemiterioDePlanetas covas : cova) {

				System.out.println("O único planeta que explodiu foi o planeta " + covas.getNome());
			}

		} else {

			System.out.println("Os planetas que explodiram foram:");

			for (CemiterioDePlanetas covas : cova) {

				System.out.println("-> " + covas.getNome());
			}

		}

		System.out.println("\n\n-//-//-//-//- RESUMO SOBRE CADA LINGUAGEM -//-//-//-//-\n\n");
		python();
		javaScript();
		rubyOnRails();
		php();
		cSharp();
		cPlusPlus();
		c();

		if (planetas.size() > 2) {
			Calculos.areaDeCobertura(planetas);
		}

	}

	public static void python() {

		System.out.println("-//-//-//-//- PYTHON -//-//-//-//-");
		System.out.println(
				"Desenvolvida por Guido van Rossum no final dos anos 80, Python é conhecida por sua simplicidade e legibilidade.");
		System.out.println("Ela se tornou uma das linguagens mais populares devido à sua versatilidade,");
		System.out.println("sendo usada em áreas como desenvolvimento web, ciência de dados, automação e IA.");

	}

	public static void javaScript() {

		System.out.println("\n\n-//-//-//-//- JAVASCRIPT -//-//-//-//-");
		System.out.println(
				"Criada pela Netscape em 1995, o JavaScript é uma linguagem de script que se tornou essencial para o desenvolvimento web.");
		System.out.println("Ela permite a criação de interatividade em páginas web,");
		System.out.println("tornando possível a construção de aplicativos web modernos e dinâmicos.");

	}

	public static void rubyOnRails() {

		System.out.println("\n\n-//-//-//-//- RUBY ON RAILS -//-//-//-//-");
		System.out.println(
				"Também conhecido como Rails, é um framework de desenvolvimento web escrito em Ruby por David Heinemeier Hansson em 2005.");
		System.out.println(
				"Ele introduziu muitas convenções e padrões que simplificaram o desenvolvimento web ágil e eficiente.");

	}

	public static void php() {

		System.out.println("\n\n-//-//-//-//- PHP -//-//-//-//-");
		System.out.println(
				"Criada por Rasmus Lerdorf em 1994, o PHP (Hypertext Preprocessor) é uma linguagem de script amplamente usada para o desenvolvimento");
		System.out.println(
				"e aplicativos web dinâmicos na criação de sites interativos e na popularização da web dinâmica. ");
	}

	public static void cSharp() {

		System.out.println("\n\n-//-//-//-//- C# -//-//-//-//-");
		System.out.println(
				"Criada pela Microsoft em 2000, a linguagem C# foi projetada para ser a linguagem de programação ");
		System.out.println(
				"principal para o desenvolvimento de aplicativos para a plataforma Windows. Ela é amplamente usada em desenvolvimento de software empresarial e jogos.");

	}

	public static void cPlusPlus() {

		System.out.println("\n\n-//-//-//-//- C++ -//-//-//-//-");
		System.out.println(
				"Desenvolvida por Bjarne Stroustrup nos anos 80, a linguagem C++ é uma extensão da linguagem C que introduziu recursos de programação orientada a objetos");
		System.out.println(
				"Ela se tornou essencial para o desenvolvimento de software de sistemas, jogos e aplicativos de alto desempenho.");
	}

	public static void c() {

		System.out.println("\n\n-//-//-//-//- C -//-//-//-//-");
		System.out.println(
				"A linguagem C, criada por Dennis Ritchie nos laboratórios Bell da AT&T em 1972, é uma das linguagens mais influentes na história da computação.");
		System.out.println(
				"Famosa por sua eficiência e portabilidade, ela serviu como base para o desenvolvimento de muitas outras linguagens e sistemas operacionais.");

	}

}
