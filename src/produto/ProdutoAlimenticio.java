package produto;

import produto.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoAlimenticio extends Produto {
    private String dataValidade;
    private String informacoesNutricionais;

    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
        super(nome, precoCusto, precoVenda);
        this.dataValidade = dataValidade;
        this.informacoesNutricionais = informacoesNutricionais;
    }

    @Override
    public void salvar() {
        super.salvar();
        String sql = "INSERT INTO ProdutoAlimenticio (produto_id, data_validade, informacoes_nutricionais) " +
                     "VALUES ((SELECT id FROM Produto WHERE nome = ?), ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setString(2, this.dataValidade);
            stmt.setString(3, this.informacoesNutricionais);
            stmt.executeUpdate();
            System.out.println("Produto alimentício " + getNome() + " salvo no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters e setters
    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getInformacoesNutricionais() {
        return informacoesNutricionais;
    }

    public void setInformacoesNutricionais(String informacoesNutricionais) {
        this.informacoesNutricionais = informacoesNutricionais;
    }
}
