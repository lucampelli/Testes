package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Projeto {

	private String Nome;
	private String ID;
	private ArrayList<String> responsaveis;
	
	private HashMap<String,Ocorrencia> ocorrencias;
	
	public Projeto(String nome, String id, String responsavel) throws Exception {
		Nome = nome;
		if(id.length() != 3) {
			System.out.println("ID Inválido");
			throw new Exception("ID Inválido");
		}
		ID = id;
		ocorrencias = new HashMap();
		responsaveis = new ArrayList();
		responsaveis.add(responsavel);
	}

	public boolean equals(Projeto p) {
		if(p == this){
			return true;
		}
		return p.id().equals(ID) && p.nome().equals(Nome);
	}
	
	public void addFuncionario(String f) {
		if(!responsaveis.contains(f)) {
			responsaveis.add(f);
		} else {
			System.out.println("Funcionário já faz parte deste projeto");
		}
	}

	public String id() {
		return ID;
	}
	
	public String nome() {
		return Nome;
	}
	
	public HashMap<String, Ocorrencia> ocorrencias(){
		return ocorrencias;
	}
	
	public ArrayList<String> idResponsaveis(){
		return responsaveis;
	}

	public boolean addOcorrencia(Ocorrencia o) throws Exception {
		if(Empresa.Instance().getFuncionarioByID(o.idResponsavel()) == null) {
			System.out.println("ID Usuário Inexistente");
			throw new Exception("ID Usuário Inexistente");
		}
		if(Empresa.Instance().getProjetoByID(o.idProjeto()) == null) {
			System.out.println("ID Projeto Inexistente");
			throw new Exception("ID Projeto Inexistente");
		}
		
		if(Empresa.Instance().contarOcorrencias(o.idResponsavel()) < 10) {
			if(ocorrencias.containsKey(o.idOcorrencia())) {
				System.out.println("Ocorrencia com id existente");
				throw new Exception("Ocorrencia com id existente");
			}
			ocorrencias.put(o.idOcorrencia(),o);
			return true;
		}
		System.out.println("Numero máximo de ocorrencias de uma mesma pessoa excedido");
		return false;
		
	}
	
	

}
