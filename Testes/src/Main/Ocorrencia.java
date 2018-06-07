package Main;

public class Ocorrencia {

	private String idResponsavel;
	private Tipo tipo;
	private Prioridade prioridade;
	private String idOcorrencia;
	
	private Estado estado;
	
	public Ocorrencia(String idResponavel, Tipo tipo, Prioridade prioridade, String idOcorrencia) throws Exception {
		if(idResponavel.length() != 7) {
			System.out.println("ID Responsável Inválido");
			throw new Exception("ID Responsável Inválido");
		}
		if(Empresa.Instance().getFuncionarioByID(idResponavel) == null) {
			System.out.println("ID Usuário Inexistente");
			throw new Exception("ID Usuário Inexistente");
		}
		
		if(idOcorrencia.length() != 6) {
			System.out.println("ID Ocorrencia Inválido");
			throw new Exception("ID Ocorrencia Inválido");
		}
		this.idOcorrencia = idOcorrencia;
		this.idResponsavel = idResponavel;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.estado = Estado.Aberto;
	}
	
	public String idResponsavel() {
		return idResponsavel;
	}
	
	public void fechar(String id) {
		if(id.equals(idResponsavel)) {
			estado = Estado.Fechado;
		}
	}
	
	public Estado estado() {
		return estado;
	}
	
	public enum Estado {Aberto, Fechado};
	public enum Tipo {Tarefa, Bug, Melhoria};
	public enum Prioridade {Alta, Media, Baixa};
	
}
