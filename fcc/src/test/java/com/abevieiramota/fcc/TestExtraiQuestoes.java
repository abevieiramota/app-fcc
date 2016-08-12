package com.abevieiramota.fcc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestExtraiQuestoes {

	private static List<Questao> questoesTRE2015AP;
	private static List<Questao> questoesTRT2016ROAC;

	@BeforeClass
	public static void beforeClass() throws IOException {

		String filepathTRE2015AP = TestExtraiQuestoes.class.getClassLoader()
				.getResource("prova/2015-tre-ap-analista-judiciario-analise-de-sistemas.pdf").getFile();

		ExtraiQuestoes eq = new ExtraiQuestoes();

		questoesTRE2015AP = eq.extraiQuestoes(new File(filepathTRE2015AP));

		String filePathTRT2016ROAC = TestExtraiQuestoes.class.getClassLoader()
				.getResource("prova/2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();

		questoesTRT2016ROAC = eq.extraiQuestoes(new File(filePathTRT2016ROAC));

	}
	
	// TRE 2015 AP

	@Test
	public void testQuantidadeDeQuestoesTrtAp() throws IOException {

		assertEquals(60, questoesTRE2015AP.size());
	}

	// TRT 2016 RO AC
	@Test
	public void testQuantidadeDeQuestoesTrtRoAc() throws IOException {

		assertEquals(60, questoesTRT2016ROAC.size());

	}

	@Test
	public void testQuestao1() {

		Questao questao1 = questoesTRT2016ROAC.get(0);

		assertEquals(
				"Entre os graves equívocos que podem se incluir na relação entre um homem e uma mulher destaca-se, no texto,",
				questao1.getEnunciado());
		assertEquals(
				"a natural subserviência que a mulher prefere demonstrar a seu parceiro violento, em vez de confrontá-lo.",
				questao1.getItem('A'));
		assertEquals(
				"a falta da discriminação masculina entre o que seja uma demonstração de amor e uma iniciativa intimidadora.",
				questao1.getItem('B'));
		assertEquals("o exagero de se avaliar como violentas algumas iniciativas masculinas tão somente carinhosas.",
				questao1.getItem('C'));
		assertEquals(
				"o fato de a moral dominante classificar como hipócrita toda e qualquer iniciativa amorosa do homem machista.",
				questao1.getItem('D'));
		assertEquals(
				"o fato de a mulher relutante tomar como amorosa a violência da sedução a que se atira seu namorado.",
				questao1.getItem('E'));
	}

	@Test
	public void testQuestao10() {

		Questao questao10 = questoesTRT2016ROAC.get(9);

		assertEquals(
				"Atente para as seguintes afirmações:\nI. No 1º parágrafo, à advertência Ledo engano segue-se a convicção de que a atração das crianças por histórias contadas\ndiretamente a elas não é menor do que a que sentem pelas desenvolvidas com recursos eletrônicos.\nII. No 2º parágrafo, a expressão caloroso laço de vozes e de palavras reafirma a importância já ressaltada pela afirmação de\nque a presença do narrador faz toda a diferença.\nIII. No 3º parágrafo, depreende-se que a analogia entre a narrativa oral e a arte do teatro ocorre por força de um elemento\ncomum: a interpretação pessoal e atualizada que se pode dar a narrativas tradicionais.\nEm relação ao texto, está correto o que se afirma em",
				questao10.getEnunciado());
		assertEquals(
				"I, II e III.",
				questao10.getItem('A'));
		assertEquals(
				"I e II, apenas.",
				questao10.getItem('B'));
		assertEquals("I e III, apenas.",
				questao10.getItem('C'));
		assertEquals(
				"II e III, apenas.",
				questao10.getItem('D'));
		assertEquals(
				"II, apenas.",
				questao10.getItem('E'));
	}

}
