package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Empresa;
import Main.Funcionario;
import Main.Ocorrencia;
import Main.Projeto;

public class TestOcorrencia {

	Empresa empresa;
	Funcionario f;
	Projeto p;
	@BeforeEach
	void beforeEach() throws Exception {
		empresa = Empresa.Instance();
		empresa.Reset();
		f = new Funcionario("Godofredo", "0000001");
		empresa.addFuncionario(f);
		p = new Projeto("Tibia 2", "001");
		empresa.addProjeto(p);
		
	}
	
	@Test
	void testAdicionarOcorrenciaEmProjeto() throws Exception {
		Ocorrencia o = new Ocorrencia("0000001", Ocorrencia.Tipo.Melhoria, Ocorrencia.Prioridade.Alta, "000001");
		assertTrue(p.addOcorrencia(o));
		assertEquals(p.ocorrencias().size(), 1);
		assertEquals(empresa.contarOcorrencias("0000001"), 1);
	}
	
	@Test
	void testAdicionarOnzeOcorrencias() throws Exception {
		for(int i = 0; i < 11; i++) {
			Ocorrencia o = new Ocorrencia("0000001", Ocorrencia.Tipo.Melhoria, Ocorrencia.Prioridade.Alta, "000001");
			if(i < 10) {
				assertTrue(p.addOcorrencia(o));
			} else {
				assertFalse(p.addOcorrencia(o));
			}
		}
	}
}
