package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtraiGabarito {

	/**
	 * Ao extrair para texto, as descrições dos cargos, por página, ficam todas
	 * no topo, seguidas das questões com respostas. Para extrair os gabaritos,
	 * leio primeiro as descrições dos cargos; depois leio os gabaritos,
	 * assumindo que eles vêm na mesma ordem que as descrições dos cargos.
	 * 
	 * @param gabaritoFile
	 * @return
	 * @throws IOException
	 */
	public List<Gabarito> extraiGabaritos(File gabaritoFile) throws IOException {

		PDFTextStripper stripper = new PDFTextStripper();
		stripper.setLineSeparator(System.lineSeparator());

		List<Gabarito> gabaritos = new ArrayList<Gabarito>();

		try (PDDocument doc = PDDocument.load(gabaritoFile)) {

			String pdfAsText = stripper.getText(doc);

			String regexCargo = "^Cargo\\ ou\\ opção\\ \\w\\d{2}\\ -\\ (.*?)\\nTipo\\ gabarito\\ \\d";
			Pattern pCargo = Pattern.compile(regexCargo, Pattern.MULTILINE | Pattern.UNIX_LINES | Pattern.DOTALL);
			Matcher mCargo = pCargo.matcher(pdfAsText);

			while (mCargo.find()) {

				Gabarito gabarito = new Gabarito();
				String cargo = mCargo.group(1).replace(System.lineSeparator(), "").trim();

				gabarito.setCargo(cargo);
				gabaritos.add(gabarito);
			}

			String regexGabarito = "^(\\d{3})\\ -\\ (\\w)";
			Pattern pGabarito = Pattern.compile(regexGabarito, Pattern.MULTILINE | Pattern.UNIX_LINES | Pattern.DOTALL);
			Matcher mGabarito = pGabarito.matcher(pdfAsText);

			Iterator<Gabarito> gabaritosIter = gabaritos.iterator();

			Gabarito gabaritoAtual = null;
			while (mGabarito.find()) {

				int numeroQuestao = Integer.parseInt(mGabarito.group(1));
				char questaoResposta = mGabarito.group(2).charAt(0);

				if (numeroQuestao == 1) {

					gabaritoAtual = gabaritosIter.next();
				}

				gabaritoAtual.addResposta(questaoResposta);
			}

		}

		return gabaritos;
	}

}
