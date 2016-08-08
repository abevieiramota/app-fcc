package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtraiProva {

	public Collection<Questao> extraiQuestoes(File prova) throws IOException {

		PDFTextStripper stripper = new PDFTextStripper();

		PDDocument doc = PDDocument.load(prova);

		String pdfAsText = stripper.getText(doc);

		String regex = "^\\d{1,2}\\.(.*?)\\(A\\)(.*?)\\(B\\)(.*?)\\(C\\)(.*?)\\(D\\)(.*?)\\(E\\)(.*?)(?=(\\d{1,2}\\.)|(Caderno\\ de\\ Prova))";

		Pattern p = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNIX_LINES | Pattern.DOTALL);

		Matcher m = p.matcher(pdfAsText);
		
		List<Questao> questoes = new ArrayList<Questao>();
		
		while(m.find()) {
			
			Questao questao = new Questao();
			questao.setEnunciado(m.group(1));
			questao.setItemA(m.group(2));
			questao.setItemB(m.group(3));
			questao.setItemC(m.group(4));
			questao.setItemD(m.group(5));
			questao.setItemE(m.group(6));
			
			questoes.add(questao);
		}

		return questoes;
	}

}
