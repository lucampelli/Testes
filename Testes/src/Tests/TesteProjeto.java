package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Empresa;
import Main.Funcionario;
import Main.Projeto;

public class TesteProjeto {

	Empresa empresa;
	
	@BeforeEach
	public void beforeEach() {
		empresa = Empresa.Instance();
		empresa.Reset();
	}
	
	
	@Test
	void testProjeto() throws Exception {
		Funcionario juninho = new Funcionario("Juninho", "0000007");
		empresa.addFuncionario(juninho);
		Projeto p = new Projeto("RuneEscape", "002", juninho);
		empresa.addProjeto(p);
		assertEquals(p.nome(), "RuneEscape");
		assertEquals(p.id(), "002");
		assertEquals(p, empresa.getProjetoByID("002"));
		assertEquals(p.idResponsaveis().get("0000007"), juninho);
	}
}
