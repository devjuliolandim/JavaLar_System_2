package model;

import java.util.ArrayList;

import planetas.C;
import planetas.CPlusPlus;
import planetas.CSharp;
import planetas.JavaScript;
import planetas.PHP;
import planetas.Python;
import planetas.RubyOnRails;

public class MenuJavaLar {

	private int opcao;
	private boolean operador = true;

	public MenuJavaLar() {

		Planetas python = new Python();
		Planetas javaScript = new JavaScript();
		Planetas ROR = new RubyOnRails();
		Planetas php = new PHP();
		Planetas csharp = new CSharp();
		Planetas cplusplus = new CPlusPlus();
		Planetas c = new C();

		ArrayList<Bug> bugs = new ArrayList<>();
		ArrayList<Desenvolvedor> dev = new ArrayList<>();
		ArrayList<Planetas> planetas = new ArrayList<>();
		ArrayList<CemiterioDePlanetas> cova = new ArrayList<>();

		planetas.add(python);
		planetas.add(javaScript);
		planetas.add(ROR);
		planetas.add(php);
		planetas.add(csharp);
		planetas.add(cplusplus);
		planetas.add(c);

		Utilidades utilidades = new Utilidades();

		do {
			MostrarMensagens.bemVindo();
			opcao = utilidades.retornarOpcao();

			if (opcao == 1) {

				new Simulacao(planetas, utilidades, bugs, dev, cova);
				operador = false;
			
			} else if (opcao == 2) {

				new MostrarMensagens(utilidades);

			} else if (opcao == 3) {

				System.out.println("Tchauzinho! Até a próxima!");
				operador = false;
			}

		} while (operador == true);

	}
}