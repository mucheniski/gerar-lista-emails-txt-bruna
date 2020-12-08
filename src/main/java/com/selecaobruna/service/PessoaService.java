package com.selecaobruna.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.selecaobruna.domain.Pessoa;

@Service
public class PessoaService { 
	
	private static final Logger LOG = LoggerFactory.getLogger(PessoaService.class);
	
	public String gerarArquivoComEmails(List<Pessoa> pessoas) {	
	
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("ddMMyyyy");		
		LocalDate hoje = LocalDate.now();
		
		Charset charset = StandardCharsets.UTF_8;
		Path filePath = Paths.get("listaemails_"+ hoje.format(formatadorData) + System.currentTimeMillis() + "_.txt");
		
		try (BufferedWriter writer = Files.newBufferedWriter(filePath, charset)) {					
			
			for (Pessoa pessoa : pessoas) {
								
				writer.append("\n");
				writer.append("===============================================================================================\n");
				writer.append("Email do contato para ser enviado: " + pessoa.getEmail() + "\n");
				writer.append("===============================================================================================\n");
				writer.append("Olá " + pessoa.getNome()+ "\n");
				writer.append("Como você está?\n");
				writer.append("Gostaria de te agradecer pelo interesse em se candidatar na nossa oportunidade, no momento para a vaga em questão, infelizmente o seu perfil, apesar de ser bom, não foi selecionado, pois tivemos outros candidatos que se adequaram mais ao que foi solicitado para a vaga. Mas gostaria de te avisar que seu currículo continua em nosso banco de dados, surgindo algo que se enquadre no seu perfil entraremos em contato!");							
				writer.append("\n\n");
				writer.append("Agradeço muito o envio do seu currículo e te desejo sorte na busca profissional.");
				writer.append("\n");
				writer.append("Desejo a você um excelente dia.");
				writer.append("\n\n");
				writer.append("Cordialmente");
				writer.append("\n");
				writer.append("Bruna\n");
				writer.append("===============================================================================================");
				writer.append("\n\n");
				
			}
			
			writer.close();			
			LOG.info("Gravado com sucesso em " + filePath.toAbsolutePath());			
			
		} catch (IOException e) {
			LOG.error("Erro ao gerar arquivo:", e.getMessage());
		}
		  
		return "Gravado com sucesso em " + filePath.toAbsolutePath();
	}

}
