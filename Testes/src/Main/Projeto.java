package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Projeto {

	private String Nome;
	private String ID;
	private HashMap<String,Funcionario> IDResponsaveis;
	
	private HashMap<String,Ocorrencia> ocorrencias;
	
	public Projeto(String nome, String id, Funcionario responsavel) throws Exception {
		Nome = nome;
		if(id.length() != 3) {
			System.out.println("ID Inválido");
			throw new Exception("ID Inválido");
		}
		ID = id;
		ocorrencias = new HashMap();
		IDResponsaveis = new HashMap();
		IDResponsaveis.put(responsavel.id(), responsavel);
	}

	public boolean equals(Projeto p) {
		if(p == this){
			return true;
		}
		return p.id().equals(ID) && p.nome().equals(Nome);
	}
	
	public void addFuncionario(Funcionario f) {
		if(!IDResponsaveis.containsKey(f.id())) {
			IDResponsaveis.put(f.id(), f);
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
	
	public HashMap<String, Funcionario> idResponsaveis(){
		return IDResponsaveis;
	}

	public boolean addOcorrencia(Ocorrencia o) throws Exception {
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
