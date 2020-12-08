package com.selecaobruna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selecaobruna.domain.Pessoa;
import com.selecaobruna.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping("/gerar-arquivo-emails")
	public String gerarArquivoComEmails(@RequestBody List<Pessoa> pessoas) {
		return pessoaService.gerarArquivoComEmails(pessoas);
	}
	
}
