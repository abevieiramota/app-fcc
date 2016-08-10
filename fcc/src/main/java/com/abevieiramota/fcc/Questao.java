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

	private String itemA;
	private String itemB;
	private String itemC;
	private String itemD;
	private String itemE;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getItemA() {
		return itemA;
	}

	public void setItemA(String itemA) {
		this.itemA = itemA;
	}

	public String getItemB() {
		return itemB;
	}

	public void setItemB(String itemB) {
		this.itemB = itemB;
	}

	public String getItemC() {
		return itemC;
	}

	public void setItemC(String itemC) {
		this.itemC = itemC;
	}

	public String getItemD() {
		return itemD;
	}

	public void setItemD(String itemD) {
		this.itemD = itemD;
	}

	public String getItemE() {
		return itemE;
	}

	public void setItemE(String itemE) {
		this.itemE = itemE;
	}

}
