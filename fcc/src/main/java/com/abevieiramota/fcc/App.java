package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		String provaFilePath = App.class.getClassLoader()
				.getResource("2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();
		
		ExtraiProva ep = new ExtraiProva();
		
		Collection<Questao> questoes = ep.extraiQuestoes(new File(provaFilePath));
		
		String cargoAnalistaTi = "AN JUD - ÁREA APOIO ESP - ESP TEC DA INFORMAÇÃO";
		String gabaritoFilePath = App.class.getClassLoader()
				.getResource("gab-2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf").getFile();
		
		ExtraiGabarito eg = new ExtraiGabarito();
		
		Collection<Gabarito> gabaritos = eg.extraiGabaritos(new File(gabaritoFilePath));
		
		Map<String, Gabarito> gabMap = Maps.uniqueIndex(gabaritos, new Function<Gabarito, String>() {
			public String apply(Gabarito g) {
				return g.getCargo();
			}
		});
		
		Gabarito gabarito = gabMap.get(cargoAnalistaTi);
		
		Iterator<Questao> questoesIter = questoes.iterator();
		
		Character[] itemLabels = new Character[]{'A', 'B', 'C', 'D', 'E'};
		
		for(int i = 1; i < questoes.size() + 1; i++) {
			
			Questao questao = questoesIter.next();
			Character resposta = gabarito.getResposta(i);
			
			System.out.println("----------------------------");
			System.out.println("Questão " + i);
			System.out.println(questao.getEnunciado());
			for(Character itemLabel: itemLabels) {
				
				if(itemLabel.equals(resposta)) {
					
					System.out.print("X ");
				}
				
				System.out.print(itemLabel + ") ");
				System.out.println(questao.getItem(itemLabel));
			}
		}
	}
}
