package Main;

public class Funcionario {

	private String Nome;
	private String ID;
	
	public Funcionario(String nome, String id) throws Exception {
		Nome = nome;
		if(id.length() != 7) {
			System.out.println("ID Inválido");
			throw new Exception("ID Inválido " + id);
		}
		ID = id;
	}
	
	@Override
	public String toString() {
		return "Funcionário: " + Nome + " ID: " + ID;
	}
	
	public boolean equals(Funcionario f) {
		if(f == this) {
			return true;
		}
		return f.nome().equals(Nome) && f.id().equals(ID);
	}
	
	public String nome() {
		return Nome;
	}

	public String id() {
		return ID;
	}
}
