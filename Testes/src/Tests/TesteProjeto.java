package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Empresa;
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
		Projeto p = new Projeto("RuneEscape", "002");
		empresa.addProjeto(p);
		assertEquals(p.nome(), "RuneEscape");
		assertEquals(p.id(), "002");
		assertEquals(p, empresa.getProjetoByID("002"));
	}
}
