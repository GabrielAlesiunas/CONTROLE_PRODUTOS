package produto;

import produto.Produto;
import produto.ProdutoAlimenticio;
import produto.ProdutoVestuario;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de Produto
        Produto produto = new Produto("Farinha", 3.50, 7.00);
        System.out.println("Lucro do produto: R$" + produto.calcularLucro());
        produto.salvar(); // Salva no banco de dados

        // Criando uma instância de ProdutoAlimenticio
        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio("Queijo", 12.50, 22.50, "2024-12-01", "1 fatia por dia");
        System.out.println("Lucro do produto alimentício: R$" + produtoAlimenticio.calcularLucro());
        produtoAlimenticio.salvar(); // Salva no banco de dados

        // Criando uma instância de ProdutoVestuario
        ProdutoVestuario produtoVestuario = new ProdutoVestuario("Chinelo", 25.00, 60.00, "41", "Branco", "Borracha");
        System.out.println("Lucro do produto de vestuário: R$" + produtoVestuario.calcularLucro());
        produtoVestuario.salvar(); // Salva no banco de dados

        System.out.println("Testes de inserção concluídos.");
    }
}
