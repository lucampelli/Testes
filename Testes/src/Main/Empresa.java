package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {

	private HashMap<String,Funcionario> funcionarios;
	private HashMap<String,Projeto> projetos;

	private static Empresa instance;

	public static Empresa Instance() {
		if (instance == null) {
			instance = new Empresa();
		}
		return instance;
	}

	private Empresa() {
		funcionarios = new HashMap();
		projetos = new HashMap();
	}

	public void addFuncionario(Funcionario f) {
		if (!funcionarios.containsKey(f.id())) {
			funcionarios.put(f.id(),f);
		}

	}

	public HashMap<String,Funcionario> funcionarios() {
		return funcionarios;
	}

	public Funcionario getFuncionarioByID(String ID) {
		if(funcionarios.containsKey(ID)) {
			return funcionarios.get(ID);
		}
		System.out.println("Funcionário não encontrado");
		return null;
	}

	public void addProjeto(Projeto p) throws Exception {
		for(String f : p.idResponsaveis()) {
			if(!funcionarios.containsKey(f)) {
				System.out.println("Projeto com algum funcionario Inválido ou Inexistente");
				throw new Exception("Projeto com algum funcionario Inválido ou Inexistente");
			}
		}
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
