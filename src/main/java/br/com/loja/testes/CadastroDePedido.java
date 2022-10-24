package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.*;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDePedido {

    public static void main(String[] args) {

        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Produto produto = produtoDao.buscarPorId(1l);
        Cliente cliente = clienteDao.buscarPorId(1l);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone 14", "Muito legal", new BigDecimal("800"), celulares);

        Cliente cliente = new Cliente("VitorRA", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }

}
