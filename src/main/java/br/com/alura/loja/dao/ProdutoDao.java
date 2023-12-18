package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager entityManager;

	public ProdutoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.entityManager.merge(produto);
	}

	public void remover(Produto produto) {
		produto = this.entityManager.merge(produto);
		this.entityManager.remove(produto);
	}

	public Produto buscarPorId(Long id) {
		return this.entityManager.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p"; // JPQL referencia a classe
		return this.entityManager.createQuery(jpql, Produto.class).getResultList();
	}

}
