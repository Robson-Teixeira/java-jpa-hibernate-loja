package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroProduto {

	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi 10");
		celular.setDescricao("Smartphone Android de 6.5 polegadas e de 2400x1080 pixels. "
				+ "Conectividade lte 4G, Wi-Fi e gps, leitor multimídia, rádio, "
				+ "videoconferência e Bluetooth. Memória interna de 128 gb, "
				+ "câmera traseira de 50 megapixels. Com apenas 8.9 milímetros de espessura.");
		celular.setPreco(new BigDecimal("800"));

		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("java-jpa-hibernate-loja");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(celular);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}