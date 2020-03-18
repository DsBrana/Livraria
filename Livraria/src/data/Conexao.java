/**
 *
 * @author Júlio Oliveira
 */

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    public static Statement stm;
    public static ResultSet rs;
    
    private String driver = "com.mysql.jdbc.Driver";
    
    private String URL = "jdbc:mysql://localhost:3306/livraria";
    private String USUARIO = "root";
    private String SENHA = "123456";
    
    
    public Connection con;
    
    public void conexao() {
        try {
            System.setProperty ( "jdbc.Drivers", driver );
            con = DriverManager.getConnection ( URL, USUARIO, SENHA );
            
            //JOptionPane.showMessageDialog ( null, "Conexão com sucesso!" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog ( null, "Erro na Conexão " + "Erro: " + ex );
        }
    }
    
    public void exeSql ( String sql ) {
        try {
            stm = con.createStatement ( rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY );
            rs = stm.executeQuery ( sql );
        } catch ( SQLException ex ) {
            JOptionPane.showMessageDialog ( null, "Erro na Execução SQL " + "Erro: " + ex );
        }       
    }
    
    public void desconexao() {
        try {
            con.close();
        } catch ( SQLException ex ) {
            JOptionPane.showMessageDialog ( null, "Erro na Desconexao " + "Erro: " + ex );
        }
    }
}
