/**
 *
 * @author Júlio Oliveira
 */

package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.adcModel;

public class adcData {
    Conexao conex = new Conexao();
    adcModel mod = new adcModel();
    
    public void Insert ( adcModel mod ) {
        conex.conexao();
        
        try {
            PreparedStatement ps = conex.con.prepareStatement ( " insert into Estoque ( titulo, autor, preco, quantidade ) values (?, ?, ?, ?)" );
            ps.setString ( 1, mod.getTitulo() );
            ps.setString ( 2, mod.getAutor() );
            ps.setString ( 3, mod.getPreco() );
            ps.setString ( 4, mod.getQuantidade() );
            ps.execute();
            
            JOptionPane.showMessageDialog ( null, "Dados inseridos com Sucesso!" );
            
        } catch (SQLException ins ) {
            JOptionPane.showMessageDialog ( null, "Erro ao adicionar este dado! Erro: " + ins );
        }
        conex.desconexao();
    }
    
    public void Delete (adcModel mod) {
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from estoque where ID=?" );
            pst.setString (1, mod.getCodigo() );
            pst.execute();
            JOptionPane.showMessageDialog ( null, "Dado excluido com sucesso!" );
        } catch (SQLException del ) {
            JOptionPane.showMessageDialog ( null, "Não foi possivel excluir este dado! Erro: " + del );
        }
        conex.desconexao();
    }
    
public adcModel pesquisa ( adcModel mod ) {
    conex.conexao();
    conex.exeSql ( "select*from estoque where id like '%" + mod.getCodigo()+"%'" );
    
    try {
        conex.rs.first();
        mod.setTitulo ( conex.rs.getString ( "titulo") );
        mod.setTitulo ( conex.rs.getString ( "autor") );
        mod.setTitulo ( conex.rs.getString ( "preco") );
        mod.setTitulo ( conex.rs.getString ( "quantidade") );
        
    } catch (SQLException sel ) {
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar este dado! Erro: " + sel );
    }
        return mod;
}    
    
public void update (adcModel mod) {
    conex.conexao();
    
        try {
            PreparedStatement pst = conex.con.prepareStatement ("update estoque set titulo=?, autor=?, preco=?, quantidade=? where id=?" );
            pst.setString (1, mod.getTitulo() );
            pst.setString (2, mod.getAutor() );
            pst.setString (3, mod.getPreco() );
            pst.setString (4, mod.getQuantidade() );
            pst.setString (5, mod.getCodigo() );
            pst.execute();
            JOptionPane.showMessageDialog (null, "Dados alterados com sucesso!" );
        } catch (SQLException upd) {
            JOptionPane.showMessageDialog (null, "Erro ao alterar dados! Erros: " + upd );
        }
        conex.desconexao();
}
    
}
