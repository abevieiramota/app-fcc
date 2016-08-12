package com.abevieiramota.fcc;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class ExtraiProva {

	public Prova extraiProva(File fileProva, File fileGabarito, String cargoDesc) throws Exception {

		ExtraiQuestoes eq = new ExtraiQuestoes();
		ExtraiGabarito eg = new ExtraiGabarito();

		List<Questao> questoes = eq.extraiQuestoes(fileProva);
		List<Gabarito> gabaritos = eg.extraiGabaritos(fileGabarito);

		Collection<Gabarito> gabaritosDoCargo = Collections2.filter(gabaritos, new Predicate<Gabarito>() {
			@Override
			public boolean apply(Gabarito g) {
				return cargoDesc.equals(g.getCargo());
			}
		});

		if (gabaritosDoCargo.isEmpty()) {

			throw new Exception("Não foi encontrado gabarito para o cargo informado: " + cargoDesc);
		}

		if (gabaritosDoCargo.size() > 1) {

			throw new Exception("Foi encontrado mais de um gabarito para o cargo informado: " + cargoDesc);
		}

		Gabarito gabaritoDoCargo = gabaritosDoCargo.iterator().next();

		if (questoes.size() != gabaritoDoCargo.size()) {

			throw new Exception(String.format("Há %d questões na prova e % questões no gabarito.", questoes.size(),
					gabaritoDoCargo.size()));
		}

		Prova prova = new Prova();

		for (int i = 0; i < questoes.size(); i++) {

			Questao questao = questoes.get(i);
			int numeroDaQuestao = i + 1;
			char resposta = gabaritoDoCargo.getResposta(numeroDaQuestao);

			prova.addQuestao(numeroDaQuestao, questao);
			prova.addGabarito(numeroDaQuestao, resposta);

		}

		return prova;
	}

}
