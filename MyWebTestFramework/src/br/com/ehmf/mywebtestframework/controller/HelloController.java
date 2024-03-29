package br.com.ehmf.mywebtestframework.controller;

import br.com.ehmf.mywebtestframework.model.Produto;
import br.com.ehmf.mywebtestframework.service.IService;
import br.com.ehmf.webframework.annotations.WebframeworkBody;
import br.com.ehmf.webframework.annotations.WebframeworkController;
import br.com.ehmf.webframework.annotations.WebframeworkDeleteMethod;
import br.com.ehmf.webframework.annotations.WebframeworkGetMethod;
import br.com.ehmf.webframework.annotations.WebframeworkInject;
import br.com.ehmf.webframework.annotations.WebframeworkPathVariable;
import br.com.ehmf.webframework.annotations.WebframeworkPostMethod;
import br.com.ehmf.webframework.annotations.WebframeworkPutMethod;

@WebframeworkController
public class HelloController {

	@WebframeworkInject
	private IService iService;
	
	@WebframeworkGetMethod("/hello")
	public String returnHelloWorld() {
		return "Return Hello world!!!";
	}	
	
	@WebframeworkGetMethod("/produto")
	public Produto exibirProduto() {
		Produto p = new Produto(1,"Nome1",5432.1,"teste.jpg");
		return p;
	}
	
	@WebframeworkPostMethod("/produto")
	public Produto cadastrarProduto(@WebframeworkBody Produto produtoNovo) {
		System.out.println(produtoNovo);
		return produtoNovo;
	}
	
	@WebframeworkGetMethod("/teste")
	public String teste() {
		return "Testes";
	}
	
	@WebframeworkGetMethod("/injected")
	public String chamadaCustom() {
		return iService.chamadaCustom("Hello injected");
	}
	
	//http://localhost:8080/retornavalor/OI == Retornando o valor de parametro: 22222
	@WebframeworkGetMethod("/retornavalor/{valor}")
	public String retornoValor(@WebframeworkPathVariable Double valor) {
		return "Retornando o valor de parametro: " + valor;
	}

	//http://localhost:8080//testeput/22222 == Retornando o valor de parametro: 22222
	@WebframeworkPutMethod("/testeput")
	public String testePut(@WebframeworkBody Produto produtoNovo) {
		return iService.criarProduto(produtoNovo);
	}

	//http://localhost:8080/testedelete/OI == Retornando o valor de parametro: 22222
	@WebframeworkDeleteMethod("/testedelete/{valor}")
	public String testeDelete(@WebframeworkPathVariable int valor) {
		return iService.excluirProduto(valor);
	}
	
	@WebframeworkGetMethod("/produtos")
	public String listarProduto() {
		return iService.listarProduto();
	}
}
