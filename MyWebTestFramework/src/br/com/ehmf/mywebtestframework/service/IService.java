package br.com.ehmf.mywebtestframework.service;

import br.com.ehmf.mywebtestframework.model.Produto;

public interface IService {
	public String chamadaCustom(String mensagem);
	public String criarProduto (Produto p);
	public String excluirProduto (int id);
	public String listarProduto ();
}
