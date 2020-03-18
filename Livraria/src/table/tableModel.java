/**
 *
 * @author Júlio Oliveira
 */

package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tableModel extends AbstractTableModel {
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
public tableModel ( ArrayList lin, String[] col ) {
    setLinhas ( lin );
    setColunas ( col );
}
    
    
public void setLinhas(ArrayList linhas) { this.linhas = linhas; }

public void setColunas(String[] colunas) { this.colunas = colunas; }

public ArrayList getLinhas() { return linhas; }

public String[] getColunas() { return colunas; }

      
public int getRowCount() { return linhas.size(); }

public int getColumnCount() { return colunas.length; }

public String getColumnName ( int numCol ) {
    return colunas[numCol];
}

public Object getValueAt(int nLinhas, int nColunas) {
        Object[] linha = (Object[]) getLinhas().get ( nLinhas );
        return linha[nColunas];
    }  
}
