package br.com.ehmf.mywebtestframework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.ehmf.mywebtestframework.model.Produto;
import br.com.ehmf.webframework.annotations.WebframeworkService;

@WebframeworkService
public class ServiceImplementation implements IService {
	public static List<Produto> produtos = new ArrayList<Produto>();
	@Override
	public String chamadaCustom(String mensagem) {
		return "Teste chamada servico: " + mensagem;
	}

	@Override
	public String criarProduto( Produto p) {
		// TODO Auto-generated method stub
		produtos.add(p);
		return "Produto "+p.toString()+ " Cadastrado com sucesso.";
	}

	@Override
	public String excluirProduto(int id) {
		String retorno = produtos.get(id).toString();
		produtos.remove(id);
		return "Produto "+retorno+" excluido com sucesso.";
	}

	@Override
	public String listarProduto() {
		return produtos.toString();
		
	}

}
