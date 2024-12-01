package produto;

import produto.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoVestuario extends Produto {
    private String tamanho;
    private String cor;
    private String material;

    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    @Override
    public void salvar() {
        super.salvar();
        String sql = "INSERT INTO ProdutoVestuario (produto_id, tamanho, cor, material) " +
                     "VALUES ((SELECT id FROM Produto WHERE nome = ?), ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setString(2, this.tamanho);
            stmt.setString(3, this.cor);
            stmt.setString(4, this.material);
            stmt.executeUpdate();
            System.out.println("Produto de vestuário " + getNome() + " salvo no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters e setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
