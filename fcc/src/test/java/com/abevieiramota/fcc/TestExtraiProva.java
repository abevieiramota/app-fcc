package com.abevieiramota.fcc;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestExtraiProva {
	
	private static Prova provaTRT2016ROAC;

	@BeforeClass
	public static void beforeClass() throws Exception {

		String filepathProvaTRT2016ROAC = TestExtraiProva.class.getClassLoader()
				.getResource("prova/2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();
		File fileProvaTRT2016ROAC = new File(filepathProvaTRT2016ROAC);
		
		String cargoAnalistaTi = "AN JUD - ÁREA APOIO ESP - ESP TEC DA INFORMAÇÃO";
		String filePath = TestExtraiQuestoes.class.getClassLoader()
				.getResource("gabarito/gab-2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();
		File fileGabaritoTRT2016ROAC = new File(filePath);

		ExtraiProva ep = new ExtraiProva();

		provaTRT2016ROAC = ep.extraiProva(fileProvaTRT2016ROAC, fileGabaritoTRT2016ROAC, cargoAnalistaTi);
	}

	@Test
	public void testExtraiProvaTrtRoAc() {
		
		assertEquals(60, provaTRT2016ROAC.size());
	}

}
