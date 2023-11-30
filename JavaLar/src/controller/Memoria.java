package controller;

import java.util.ArrayList;

import planetas.C;
import planetas.CPlusPlus;
import planetas.CSharp;
import planetas.JavaScript;
import planetas.PHP;
import planetas.Python;
import planetas.RubyOnRails;

public class Memoria {

	private ArrayList<Planetas> planetas = new ArrayList<>();

	private Planetas python = new Python();
	private Planetas javaScript = new JavaScript();
	private Planetas ROR = new RubyOnRails();
	private Planetas php = new PHP();
	private Planetas csharp = new CSharp();
	private Planetas cplusplus = new CPlusPlus();
	private Planetas c = new C();

	public Memoria() {

		adicionarAoArrayList();

	}

	private void adicionarAoArrayList() {
		planetas.add(python);
		planetas.add(javaScript);
		planetas.add(ROR);
		planetas.add(php);
		planetas.add(csharp);
		planetas.add(cplusplus);
		planetas.add(c);
	}

	
	
	public ArrayList<Planetas> getPlanetas() {
		return planetas;
	}

}
