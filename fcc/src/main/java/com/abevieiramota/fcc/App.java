package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		// extrai
		PDFTextStripper stripper = new PDFTextStripper();

		String filePath = App.class.getClassLoader()
				.getResource("2015-tre-ap-analista-judiciario-analise-de-sistemas.pdf").getFile();
		PDDocument doc = PDDocument.load(new File(filePath));

		String pdfAsText = stripper.getText(doc);
		
		String regex = "/^\\d{1,2}\\.(.*)\\(A\\)(.*)\\(B\\)(.*)\\(C\\)(.*)\\(D\\)(.*)\\(E\\)(.*)\\s{1,2}\\n/msU";

		Pattern p = Pattern
				.compile(regex, Pattern.MULTILINE | Pattern.UNIX_LINES);
		
		Matcher m = p.matcher(pdfAsText);
		
		while(m.find()) {
			
			System.out.println(m.group(1));
		}

	}
}
