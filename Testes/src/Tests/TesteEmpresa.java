package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Empresa;
import Main.Funcionario;

public class TesteEmpresa {

	Empresa empresa;
	
	@BeforeEach
	public void beforeEach() {
		empresa = new Empresa();
	}
	
	
	@Test
	void testFuncionarios() throws Exception {
		
		Funcionario Godofredo = new Funcionario("Godofredo","0000001");
		empresa.addFuncionario(Godofredo);
		assertNotNull(empresa.funcionarios());
		assertEquals(empresa.getFuncionarioByID("0000001"), Godofredo);
	}
}
