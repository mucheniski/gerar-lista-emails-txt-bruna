package com.selecaobruna.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.selecaobruna.domain.Pessoa;
import com.selecaobruna.service.PessoaService;



@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping("/gerar-arquivo-emails-por-json")
	public String gerarArquivoComEmailsJson(@RequestBody List<Pessoa> pessoas) {
		return pessoaService.gerarArquivoComEmails(pessoas);
	}
	
	@PostMapping("/gerar-arquivo-emails-por-csv")
	public String gerarArquivoComEmailsCsv(@RequestParam("arquivoCsv") MultipartFile arquivoCsv) {
		
		String conteudo = arquivoCsv.getContentType();
		try {
			InputStream inputStream = arquivoCsv.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
