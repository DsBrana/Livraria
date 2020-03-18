/**
 *
 * @author Júlio Oliveira
 */

package model;
   
import java.math.BigDecimal;

public class adcModel {
   private String codigo;
   private String titulo;
   private String autor;
   private String preco;
   private BigDecimal precoTotal;
   private String quantidade;

    public adcModel() { }   
   
    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getPreco() { return preco; }

    public void setPreco(String preco) { this.preco = preco; }
    
    public BigDecimal getPrecoTotal() { return precoTotal; }

    public void setPrecoTotal(BigDecimal precoTotal) { this.precoTotal = precoTotal; }

    public String getQuantidade() { return quantidade; }

    public void setQuantidade(String quantidade) { this.quantidade = quantidade; }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }  
    
public String toString() {
    return "Livro: "+ titulo +"Autor: " + preco + "Quantidade: " + quantidade;
}          
}
