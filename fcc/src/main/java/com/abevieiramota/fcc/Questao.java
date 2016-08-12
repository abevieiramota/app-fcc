package com.abevieiramota.fcc;

import java.util.HashMap;
import java.util.Map;

public class Questao {

	private String enunciado;
	private Map<Character, String> items;

	public Questao() {

		this.items = new HashMap<Character, String>();
	}

	public String getItem(char itemLabel) {

		return this.items.get(itemLabel);
	}

	public void setItem(char itemLabel, String itemValor) {

		this.items.put(itemLabel, itemValor);
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
}
