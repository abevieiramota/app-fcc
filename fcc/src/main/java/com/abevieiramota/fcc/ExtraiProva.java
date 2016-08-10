package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtraiProva {

	public List<Questao> extraiQuestoes(File provaFile) throws IOException {

		PDFTextStripper stripper = new PDFTextStripper();

		PDDocument doc = PDDocument.load(provaFile);

		String pdfAsText = stripper.getText(doc);

		String regex = "^\\d{1,2}\\.(.*?)\\(A\\)(.*?)\\(B\\)(.*?)\\(C\\)(.*?)\\(D\\)(.*?)\\(E\\)(.*?)(?=(\\d{1,2}\\.)|(Caderno\\ de\\ Prova))";

		Pattern p = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNIX_LINES | Pattern.DOTALL);

		Matcher m = p.matcher(pdfAsText);
		
		List<Questao> questoes = new ArrayList<Questao>();
		
		while(m.find()) {
			
			Questao questao = new Questao();
			questao.setEnunciado(m.group(1).trim());
			questao.setItem('A', m.group(2).trim());
			questao.setItem('B', m.group(3).trim());
			questao.setItem('C', m.group(4).trim());
			questao.setItem('D', m.group(5).trim());
			questao.setItem('E', m.group(6).trim());
			
			questoes.add(questao);
		}

		return questoes;
	}

}
