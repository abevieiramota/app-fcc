package com.abevieiramota.fcc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestExtrairProva {
	
	@Test
	public void testQuantidadeDeGruposTrtAp() throws IOException {
		

		String filePath = TestExtrairProva.class.getClassLoader()
				.getResource("2015-tre-ap-analista-judiciario-analise-de-sistemas.pdf").getFile();
		
		ExtraiProva ep = new ExtraiProva();
		
		Collection<Questao> questoes = ep.extraiQuestoes(new File(filePath));
		
		assertEquals(60, questoes.size());
		
		for(Questao q: questoes) {
			
			System.out.println("Enunciado:");
			System.out.println(q.getEnunciado());
			System.out.println("Item A:");
			System.out.println(q.getItemA());
			System.out.println("Item B:");
			System.out.println(q.getItemB());
			System.out.println("Item C:");
			System.out.println(q.getItemC());
			System.out.println("Item D:");
			System.out.println(q.getItemD());
			System.out.println("Item E:");
			System.out.println(q.getItemE());
		}
	}
	
	@Test
	public void testQuantidadeDeGruposTrtRoAc() throws IOException {
		

		String filePath = TestExtrairProva.class.getClassLoader()
				.getResource("2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();
		
		ExtraiProva ep = new ExtraiProva();
		
		Collection<Questao> questoes = ep.extraiQuestoes(new File(filePath));
		
		assertEquals(60, questoes.size());
		
		for(Questao q: questoes) {
			
			System.out.println("Enunciado:");
			System.out.println(q.getEnunciado());
			System.out.println("Item A:");
			System.out.println(q.getItemA());
			System.out.println("Item B:");
			System.out.println(q.getItemB());
			System.out.println("Item C:");
			System.out.println(q.getItemC());
			System.out.println("Item D:");
			System.out.println(q.getItemD());
			System.out.println("Item E:");
			System.out.println(q.getItemE());
		}
	}
}
