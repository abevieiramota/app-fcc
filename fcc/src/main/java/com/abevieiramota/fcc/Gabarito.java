package com.abevieiramota.fcc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gabarito {
	
	private String cargo;
	private List<Character> respostas;
	
	public Gabarito() {
		
		this.respostas = new ArrayList<Character>();
	}

	public void setCargo(String cargo) {

		this.cargo = cargo;
	}
	
	public String getCargo() {
		
		return this.cargo;
	}
	
	public void addResposta(char questaoResposta) {

		this.respostas.add(questaoResposta);
	}
	
	public char getResposta(int i) {
		
		return this.respostas.get(i - 1);
	}
	
	@Override
	public boolean equals(Object o) {

		if(o == null || !(o instanceof Gabarito)) {
			
			return false;
		}
		
		Gabarito other = (Gabarito) o;
		
		if(this.cargo == null) {
			
			return other.cargo == null;
		}
		
		return this.cargo.equals(other.cargo);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(this.cargo);
	}

	public int size() {
		
		return respostas.size();
	}
}
