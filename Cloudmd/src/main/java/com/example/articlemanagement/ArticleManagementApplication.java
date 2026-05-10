package com.example.articlemanagement;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticleManagementApplication {

	public static void main(String[] args) {
		loadEnvFromDotEnvFile();
		SpringApplication.run(ArticleManagementApplication.class, args);
	}

	private static void loadEnvFromDotEnvFile() {
		Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMissing().load();
		applyIfMissingFromOsEnv("SPRING_DATASOURCE_URL", "spring.datasource.url", dotenv);
		applyIfMissingFromOsEnv("SPRING_DATASOURCE_USERNAME", "spring.datasource.username", dotenv);
		applyIfMissingFromOsEnv("SPRING_DATASOURCE_PASSWORD", "spring.datasource.password", dotenv);
		applyIfMissingFromOsEnv("JWT_SECRET", "jwt.secret", dotenv);
	}

	private static void applyIfMissingFromOsEnv(String envKey, String springPropertyKey, Dotenv dotenv) {
		String fromOs = System.getenv(envKey);
		if (fromOs != null && !fromOs.isBlank()) {
			return;
		}
		if (System.getProperty(springPropertyKey) != null) {
			return;
		}
		String fromFile = dotenv.get(envKey);
		if (fromFile != null && !fromFile.isBlank()) {
			System.setProperty(springPropertyKey, fromFile);
		}
	}
}
