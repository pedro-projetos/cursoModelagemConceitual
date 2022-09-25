package com.pedroartur.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedroartur.cursomc.domain.Categoria;
import com.pedroartur.cursomc.domain.Cidade;
import com.pedroartur.cursomc.domain.Cliente;
import com.pedroartur.cursomc.domain.Endereco;
import com.pedroartur.cursomc.domain.Estado;
import com.pedroartur.cursomc.domain.Pagamento;
import com.pedroartur.cursomc.domain.PagamentoBoleto;
import com.pedroartur.cursomc.domain.PagamentoCartao;
import com.pedroartur.cursomc.domain.Pedido;
import com.pedroartur.cursomc.domain.Produto;
import com.pedroartur.cursomc.domain.enums.EstadoPagamento;
import com.pedroartur.cursomc.domain.enums.TipoCliente;
import com.pedroartur.cursomc.repositories.CategoriaRepository;
import com.pedroartur.cursomc.repositories.CidadeRepository;
import com.pedroartur.cursomc.repositories.ClienteRepository;
import com.pedroartur.cursomc.repositories.EnderecoRepository;
import com.pedroartur.cursomc.repositories.EstadoRepository;
import com.pedroartur.cursomc.repositories.PagamentoRepository;
import com.pedroartur.cursomc.repositories.PedidoRepository;
import com.pedroartur.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		
	Categoria categoria1 = new Categoria(null,"Informática");
	Categoria categoria2 = new Categoria(null, "Escritório");
	Produto produto1 = new Produto(null,"Computador",2000.00);
	Produto produto2 = new Produto(null,"Impressora",800.00);
	Produto produto3 = new Produto(null,"Mouse",80.00);
	
	categoria1.getProdutos().addAll(Arrays.asList(produto1,produto3));
	categoria2.getProdutos().addAll(Arrays.asList(produto2));
	
	produto1.getCategorias().addAll(Arrays.asList(categoria1));
	produto2.getCategorias().addAll(Arrays.asList(categoria2));
	produto3.getCategorias().addAll(Arrays.asList(categoria1));
	
	categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
	produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
	
	Estado estado1 = new Estado(null, "Minas Gerais");
	Estado estado2 = new Estado(null, "São Paulo");
	
	Cidade cidade1 = new Cidade(null,"Uberlândia", estado1);
	Cidade cidade2 = new Cidade(null,"São Paulo", estado2);
	
	estado1.getCidades().addAll(Arrays.asList(cidade1));
	estado2.getCidades().addAll(Arrays.asList(cidade2));
	
	estadoRepository.saveAll(Arrays.asList(estado1,estado2));
	cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2));
	
	Cliente cliente1 = new Cliente(null,"Maria Silva","maria@gmail.com","367.108.964-89",TipoCliente.PessoaFísica);
	cliente1.getTelefones().addAll(Arrays.asList("31 9 9546-1789", "31 9 9456-1788"));
	Endereco endereco1 = new Endereco(null,"Rua Flores","300","Apto 302","Jardim","342020-600",cliente1,cidade1);
	Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "342022-603", cliente1, cidade2);
	
	cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));
	
	clienteRepository.saveAll(Arrays.asList(cliente1));
	enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
	
	SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyy hh:mm");
	
	Pedido pedido1 = new Pedido(null, simple.parse("30/09/2017 10:32"), cliente1, endereco1);
	Pedido pedido2 = new Pedido(null, simple.parse("10/10/2017 14:35"), cliente1, endereco2);
	
	Pagamento pagamento1 = new PagamentoCartao(null, EstadoPagamento.Quitado, pedido1, 6);
	pedido1.setPagamento(pagamento1);
	
	Pagamento pagamento2 = new PagamentoBoleto(null, EstadoPagamento.Pendente, pedido2, simple.parse("20/10/2017 00:00"), null);
	pedido2.setPagamento(pagamento2);
	
	cliente1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));
	
	pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
	pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2));
	
	}

}
