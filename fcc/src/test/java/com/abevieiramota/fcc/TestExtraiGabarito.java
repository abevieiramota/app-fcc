package com.abevieiramota.fcc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

@RunWith(JUnit4.class)
public class TestExtraiGabarito {
	
	@Test
	public void testQuantidadeDeGabaritos() throws IOException {
		
		String cargoAnalistaTi = "AN JUD - ÁREA APOIO ESP - ESP TEC DA INFORMAÇÃO";
		String filePath = TestExtraiQuestoes.class.getClassLoader()
				.getResource("gabarito/gab-2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();
		
		ExtraiGabarito eg = new ExtraiGabarito();
		
		Collection<Gabarito> gabaritos = eg.extraiGabaritos(new File(filePath));
		
		assertEquals(5, gabaritos.size());
		
		Map<String, Gabarito> gabMap = Maps.uniqueIndex(gabaritos, new Function<Gabarito, String>() {
			public String apply(Gabarito g) {
				return g.getCargo();
			}
		});
		
		assertTrue(gabMap.containsKey(cargoAnalistaTi));
		
		Gabarito gabarito = gabMap.get(cargoAnalistaTi);
		
		assertEquals(60, gabarito.size());
		
		assertEquals('B', gabarito.getResposta(1));
		assertEquals('C', gabarito.getResposta(17));
		assertEquals('A', gabarito.getResposta(36));
		assertEquals('A', gabarito.getResposta(46));
		assertEquals('A', gabarito.getResposta(56));
		assertEquals('D', gabarito.getResposta(60));
	}

}
