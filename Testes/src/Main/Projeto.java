package Main;

import java.util.ArrayList;

public class Projeto {

	private String Nome;
	private String ID;
	
	private ArrayList<Ocorrencia> ocorrencias;
	
	public Projeto(String nome, String id) throws Exception {
		Nome = nome;
		if(id.length() != 3) {
			System.out.println("ID Inválido");
			throw new Exception("ID Inválido");
		}
		ID = id;
		ocorrencias = new ArrayList();
	}

	public boolean equals(Projeto p) {
		if(p == this){
			return true;
		}
		return p.id().equals(ID) && p.nome().equals(Nome);
	}

	public String id() {
		return ID;
	}
	
	public String nome() {
		return Nome;
	}
	
	public ArrayList<Ocorrencia> ocorrencias(){
		return ocorrencias;
	}

	public boolean addOcorrencia(Ocorrencia o) {
		if(Empresa.Instance().contarOcorrencias(o.idResponsavel()) < 10) {
			ocorrencias.add(o);
			return true;
		}
		System.out.println("Numero máximo de ocorrencias de uma mesma pessoa excedido");
		return false;
		
	}
	
	

}
