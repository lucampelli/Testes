package Main;

import java.util.ArrayList;

public class Empresa {

	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Projeto> projetos;

	private static Empresa instance;

	public static Empresa Instance() {
		if (instance == null) {
			instance = new Empresa();
		}
		return instance;
	}

	private Empresa() {
		funcionarios = new ArrayList();
		projetos = new ArrayList();
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
		if (!projetos.contains(p)) {
			projetos.add(p);
		}

	}

	public ArrayList<Projeto> projetos() {
		return projetos;
	}

	public Projeto getProjetoByID(String ID) {
		for (Projeto p : projetos) {
			if (p.id().equals(ID)) {
				return p;
			}
		}
		System.out.println("Projeto não encontrado");
		return null;
	}

	public int contarOcorrencias(String id) {
		int count = 0;
		for (Projeto p : projetos) {
			for (Ocorrencia o : p.ocorrencias()) {
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
