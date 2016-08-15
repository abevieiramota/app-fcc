package com.abevieiramota.fcc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CarregaProva {

	private static final String SQL_INSERT_QUESTAO = "insert into questoes_question (enunciado, \"itemA\", \"itemB\", \"itemC\", \"itemD\", \"itemE\", resposta, \"temErro\", created, publish, updated, status) values (?, ?, ?, ?, ?, ?, ?, false, now(), now(), now(), 'draft')";

	public static void main(String[] args) throws Exception {

		// Prova
		String filepathProvaTRT2016ROAC = CarregaProva.class.getClassLoader()
				.getResource("prova/2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf")
				.getFile();
		String filePathGabaritoTRT2016ROAC = CarregaProva.class.getClassLoader()
				.getResource("gabarito/gab-2016-trt-14-regiao-ro-e-ac-analista-judiciario-tecnologia-da-informacao.pdf")
				.getFile();
		String cargoAnalistaTi = "AN JUD - ÁREA APOIO ESP - ESP TEC DA INFORMAÇÃO";
		ExtraiProva ep = new ExtraiProva();

		File fileProvaTRT2016ROAC = new File(filepathProvaTRT2016ROAC);
		File fileGabaritoTRT2016ROAC = new File(filePathGabaritoTRT2016ROAC);

		Prova provaTRT = ep.extraiProva(fileProvaTRT2016ROAC, fileGabaritoTRT2016ROAC, cargoAnalistaTi);

		// DB
		Properties jdbcProperties = new Properties();

		try (InputStream is = CarregaProva.class.getClassLoader().getResourceAsStream("jdbc.properties")) {

			jdbcProperties.load(is);
		}

		String jdbcUrl = jdbcProperties.getProperty("JDBC_URL");
		String jdbcUser = jdbcProperties.getProperty("JDBC_USER");
		String jdbcPassword = jdbcProperties.getProperty("JDBC_PASSWORD");

		try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {

			try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT_QUESTAO)) {

				for (Integer numeroQuestao : provaTRT.getQuestoesNumero()) {

					Questao questao = provaTRT.getQuestao(numeroQuestao);
					Character resposta = provaTRT.getResposta(numeroQuestao);

					ps.setString(1, questao.getEnunciado());
					ps.setString(2, questao.getItem('A'));
					ps.setString(3, questao.getItem('B'));
					ps.setString(4, questao.getItem('C'));
					ps.setString(5, questao.getItem('D'));
					ps.setString(6, questao.getItem('E'));
					ps.setString(7, resposta.toString());

					try {
						ps.execute();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
