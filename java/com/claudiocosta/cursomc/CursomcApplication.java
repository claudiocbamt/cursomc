package com.claudiocosta.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.claudiocosta.cursomc.domain.Categoria;
import com.claudiocosta.cursomc.domain.Cidade;
import com.claudiocosta.cursomc.domain.Cliente;
import com.claudiocosta.cursomc.domain.Endereco;
import com.claudiocosta.cursomc.domain.Estado;
import com.claudiocosta.cursomc.domain.ItemPedido;
import com.claudiocosta.cursomc.domain.Pagamento;
import com.claudiocosta.cursomc.domain.PagamentoComBoleto;
import com.claudiocosta.cursomc.domain.PagamentoComCartao;
import com.claudiocosta.cursomc.domain.Pedido;
import com.claudiocosta.cursomc.domain.Produto;
import com.claudiocosta.cursomc.domain.enums.EstadoPagamento;
import com.claudiocosta.cursomc.domain.enums.TipoCliente;
import com.claudiocosta.cursomc.repositories.CategoriaRepository;
import com.claudiocosta.cursomc.repositories.CidadeRepository;
import com.claudiocosta.cursomc.repositories.ClienteRepository;
import com.claudiocosta.cursomc.repositories.EnderecoRepository;
import com.claudiocosta.cursomc.repositories.EstadoRepository;
import com.claudiocosta.cursomc.repositories.ItemPedidoRepository;
import com.claudiocosta.cursomc.repositories.PagamentoRepository;
import com.claudiocosta.cursomc.repositories.PedidoRepository;
import com.claudiocosta.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
  @Autowired
	private CategoriaRepository categoriaRepository;
  @Autowired
	private ProdutoRepository produtoRepository;
  @Autowired
 	private EstadoRepository estadoRepository;
   
  @Autowired
 	private CidadeRepository cidadeRepository;
  @Autowired
	private ClienteRepository clienteRepository;
 
  @Autowired
	private EnderecoRepository enderecoRepository;
  
  @Autowired
	private PedidoRepository pedidoRepository;

@Autowired
	private PagamentoRepository pagamentoRepository;
    
@Autowired
private ItemPedidoRepository itemPedidoRepository;

   
  
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 Categoria cat1 = new Categoria(null, "Informática");
		 Categoria cat2 = new Categoria(null, "Escritorio");
		 Categoria cat3 = new Categoria(null, "Eletrônicos");
		 Categoria cat4 = new Categoria(null, "Jardinagem");
		 Categoria cat5 = new Categoria(null, "Decoração");
		 Categoria cat6 = new Categoria(null, "Eletrodoméstico");
		 Categoria cat7 = new Categoria(null, "Brinquedos");
		 Categoria cat8 = new Categoria(null, "Decoração");
		 
		 
		 Produto p1 = new Produto(null,"Computador", 2000.00);
		 Produto p2 = new Produto(null,"Impressora", 800.00);
		 Produto p3 = new Produto(null,"Mouse", 80.00);
		 cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		 cat2.getProdutos().addAll(Arrays.asList(p2));
		 //cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		 
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat1));
		 
		 Estado est1 = new Estado (null, "Minas Gerais");
		 Estado est2 = new Estado (null, "São Paulo");
		 
		 Cidade c1 = new Cidade(null, "Uberlândia", est1);
		 Cidade c2 = new Cidade(null, "São Paulo", est2);
		 Cidade c3 = new Cidade(null, "Campinas", est2);
		 
		 est1.getCidades().addAll(Arrays.asList(c1));
		 est2.getCidades().addAll(Arrays.asList(c2,c3)); 
		 
		 
		 categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7,cat8));
		 produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		 
		 estadoRepository.saveAll(Arrays.asList(est1, est2));
		 cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		 Cliente cli1 = new Cliente(null, "Claudio Pereira da Costa", "claudiocbamt@gmail.com", "54259401149", TipoCliente.PESSOAFISICA );
	     cli1.getTelefones().addAll( Arrays.asList("992281544","32270683"));
		 
		 Endereco e1 = new Endereco(null, "Rua das Flores", "300","Aptº 303 ", "Jardim", "76821045", cli1, c1);
		 Endereco e2 = new Endereco(null, "Av Calama", "773","casa 05 ", "Planalto", "76815800", cli1, c2);
		 cli1.getEnderecos().addAll( Arrays.asList(e1,e2));
		 
		 clienteRepository.saveAll(Arrays.asList(cli1));
		 enderecoRepository.saveAll(Arrays.asList(e1,e2));
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		 Pedido ped1 = new Pedido (null,sdf.parse("27/07/2017 23:00"),cli1,e1);
		 Pedido ped2 = new Pedido (null,sdf.parse("27/07/2017 23:00"),cli1,e1);
		 
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO, ped1, 6);
	    ped1.setPagamento(pagto1);
		 
	    Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 19:00"), sdf.parse("20/10/2017 19:00"));
	    ped2.setPagamento(pagto2);
	    
	    cli1.getPedidos().addAll( Arrays.asList(ped1,ped2));
	    
	     pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		 pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		 
		 ItemPedido ip1 = new ItemPedido(ped1,p1, 0.0, 1, 2000.00);
		 ItemPedido ip2 = new ItemPedido(ped1,p3, 0.0, 2, 80.00);
		 ItemPedido ip3 = new ItemPedido(ped2,p2, 100.00, 1, 800.00);
		 ped1.getItens().addAll( Arrays.asList(ip1,ip2));
		 ped2.getItens().addAll( Arrays.asList(ip3));
		 p1.getItens().addAll( Arrays.asList(ip1));
		 p2.getItens().addAll( Arrays.asList(ip3));
		 p3.getItens().addAll( Arrays.asList(ip2));
		 
		 itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

	
	
	
}
