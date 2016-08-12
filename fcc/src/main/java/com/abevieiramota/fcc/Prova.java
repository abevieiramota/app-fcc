package com.abevieiramota.fcc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Prova {
	
	private Map<Integer, Questao> questoes;
	private Map<Integer, Character> gabarito;
	
	public Prova() {
		
		this.questoes = new HashMap<Integer, Questao>();
		this.gabarito = new HashMap<Integer, Character>();
	}
	
	public Collection<Integer> getQuestoesNumero() {
		
		return this.questoes.keySet();
	}
	
	public Questao getQuestao(Integer numero) {
		
		return this.questoes.get(numero);
	}
	
	public Character getResposta(Integer numero) {
		
		return this.gabarito.get(numero);
	}
	
	public void addQuestao(Integer numero, Questao questao) {
		
		this.questoes.put(numero, questao);
	}
	
	public void addGabarito(Integer numero, char resposta) {
		
		this.gabarito.put(numero, resposta);
	}

	public int size() {

		return questoes.size();
	}

}
