package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroProduto {

	public static void main(String[] args) {

		Produto celular = new Produto("Xiaomi Redmi 10",
				"Smartphone Android de 6.5 polegadas e de 2400x1080 pixels. "
						+ "Conectividade lte 4G, Wi-Fi e gps, leitor multimídia, rádio, "
						+ "videoconferência e Bluetooth. Memória interna de 128 gb, "
						+ "câmera traseira de 50 megapixels. Com apenas 8.9 milímetros de espessura.",
						new BigDecimal("800"), Categoria.CELULARES);

		EntityManager entityManager = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(entityManager);

		entityManager.getTransaction().begin();
		produtoDao.cadastrar(celular);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
