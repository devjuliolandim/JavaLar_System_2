package model;

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
	private ArrayList<Bug> bugs = new ArrayList<>();
	private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();
	
	
	
	Planetas python = new Python();
	Planetas javaScript = new JavaScript();
	Planetas ROR = new RubyOnRails();
	Planetas php = new PHP();
	Planetas csharp = new CSharp();
	Planetas cplusplus = new CPlusPlus();
	Planetas c = new C();

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

	public void setPlanetas(ArrayList<Planetas> planetas) {
		this.planetas = planetas;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}

	public ArrayList<Desenvolvedor> getDesenvolvedores() {
		return desenvolvedores;
	}

	public void setDesenvolvedores(ArrayList<Desenvolvedor> desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}

}
