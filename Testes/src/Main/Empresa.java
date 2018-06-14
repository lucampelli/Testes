package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {

	private ArrayList<Funcionario> funcionarios;
	private HashMap<String,Projeto> projetos;

	private static Empresa instance;

	public static Empresa Instance() {
		if (instance == null) {
			instance = new Empresa();
		}
		return instance;
	}

	private Empresa() {
		funcionarios = new ArrayList();
		projetos = new HashMap();
	}

	public void addFuncionario(Funcionario f) {
		if (!funcionarios.contains(f)) {
			funcionarios.add(f);
		}

	}

	public ArrayList<Funcionario> funcionarios() {
		return funcionarios;
	}

	public Funcionario getFuncionarioByID(String ID) {
		for (Funcionario f : funcionarios) {
			if (f.id().equals(ID)) {
				return f;
			}
		}
		System.out.println("Funcionário não encontrado");
		return null;
	}

	public void addProjeto(Projeto p) {
		if (!projetos.containsKey(p.id())) {
			projetos.put(p.id(),p);
		}

	}

	public HashMap<String,Projeto> projetos() {
		return projetos;
	}

	public Projeto getProjetoByID(String ID) {
		if(projetos.containsKey(ID)) {
			return projetos.get(ID);
		}
		System.out.println("Projeto não encontrado");
		return null;
	}

	public int contarOcorrencias(String id) {
		int count = 0;
		for (Projeto p : projetos.values()) {
			for (Ocorrencia o : p.ocorrencias().values()) {
				if (o.idResponsavel().equals(id) && o.estado().equals(Ocorrencia.Estado.Aberto)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public void Reset() {
		funcionarios.clear();
		projetos.clear();
	}

}
