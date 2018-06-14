package Main;

public class Ocorrencia {

	private String idResponsavel;
	private String projeto;
	private Tipo tipo;
	private Prioridade prioridade;
	private String idOcorrencia;
	
	
	private Estado estado;
	
	public Ocorrencia(String idResponsavel, String projeto, Tipo tipo, Prioridade prioridade, String idOcorrencia) throws Exception {
		if(idResponsavel.length() != 7) {
			System.out.println("ID Responsável Inválido");
			throw new Exception("ID Responsável Inválido");
		}
		
		if(idOcorrencia.length() != 6) {
			System.out.println("ID Ocorrencia Inválido");
			throw new Exception("ID Ocorrencia Inválido");
		}
		
		if(projeto.length() != 3) {
			System.out.println("ID Projeto Inválido");
			throw new Exception("ID Projeto Inválido");
		}

		this.idOcorrencia = idOcorrencia;
		this.projeto = projeto;
		this.idResponsavel = idResponsavel;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.estado = Estado.Aberto;
	}
	
	public String idResponsavel() {
		return idResponsavel;
	}
	
	public String idOcorrencia() {
		return idOcorrencia;
	}
	
	public void fechar(String id) throws Exception {
		if(estado != Estado.Aberto) {
			System.out.println("Ocorrencias fechadas não podem ser alteradas");
			throw new Exception("Ocorrencias fechadas não podem ser alteradas");
		}
		if(id.equals(idResponsavel)) {
			
				estado = Estado.Fechado;
			
		} else {
			System.out.println("Somente o usuário responsável pela ocorrencia pode fechá-la");
			throw new Exception("Somente o usuário responsável pela ocorrencia pode fechá-la");
		}
	}
	
	public void alterarPrioridade(Prioridade novaPrioridade) throws Exception {
		if(estado == Estado.Aberto) {
			prioridade = novaPrioridade;
		} else {
			System.out.println("Ocorrencias fechadas não podem ser alteradas");
			throw new Exception("Ocorrencias fechadas não podem ser alteradas");
		}
	}
	
	public Estado estado() {
		return estado;
	}
	
	
	public enum Estado {Aberto, Fechado};
	public enum Tipo {Tarefa, Bug, Melhoria};
	public enum Prioridade {Alta, Media, Baixa}
	
	public Prioridade prioridade() {
		return prioridade;
	}

	public String idProjeto() {
		return projeto;
	};
	
}
