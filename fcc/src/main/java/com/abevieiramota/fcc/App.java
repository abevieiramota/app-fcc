package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		Character[] itemLabels = new Character[] { 'A', 'B', 'C', 'D', 'E' };

		String provaFolderPath = App.class.getClassLoader().getResource("prova/").getFile();
		File folder = new File(provaFolderPath);
		File[] provas = folder.listFiles();

		ExtraiProva ep = new ExtraiProva();

		for (File prova : provas) {
			
			String provaExtraidaFilename = prova.getName().split("\\.")[0] + ".txt";
			File provaExtraida = new File(provaExtraidaFilename);
			if(provaExtraida.exists()) {
				
				provaExtraida.delete();
			}
			List<Questao> questoes = ep.extraiQuestoes(prova);

			int n = 1;
			for (Questao q : questoes) {

				Files.append("Questao " + n++ + "\n", provaExtraida, Charsets.UTF_8);
				Files.append(q.getEnunciado() + "\n", provaExtraida, Charsets.UTF_8);

				for (Character itemLabel : itemLabels) {

					Files.append(itemLabel + ") ", provaExtraida, Charsets.UTF_8);
					Files.append(q.getItem(itemLabel) + "\n\n", provaExtraida, Charsets.UTF_8);
				}
				
				Files.append("\n", provaExtraida, Charsets.UTF_8);
			}

		}

	}
}
