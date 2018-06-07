package Main;

public class Funcionario {

	String Nome;
	String ID;
	
	public Funcionario(String nome, String id) {
		Nome = nome;
		ID = id;
	}
	
	public boolean Equals(Funcionario f) {
		return f.nome().equals(Nome) && f.id().equals(ID);
	}
	
	public String nome() {
		return Nome;
	}

	public String id() {
		return ID;
	}
}
