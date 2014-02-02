package fancy.fuzzy.wuzzy.s.logic;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Javier Segovia @jota_Segovia
 */
public class Tabla {
    
public static void Agregar(javax.swing.JTable tabla, Object[] rowData)
{
DefaultTableModel model = (DefaultTableModel) tabla.getModel();
model.addRow(rowData);
tabla.setModel(model);
}

public static void removeSelectedRow(javax.swing.JTable tabla, int row)
{
DefaultTableModel model = (DefaultTableModel) tabla.getModel();
model.removeRow(row);
tabla.setModel(model);
}

public static void Clear(javax.swing.JTable tabla)
{
    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    while(model.getRowCount() > 0){model.removeRow(0);}
    tabla.setModel(model);
}

public static void setColumns(javax.swing.JTable tabla, String[] columnas)
{
    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    model.setColumnCount(0);
    for (int i = 0; i < (columnas.length); i++) {
        model.addColumn(columnas[i]);
    }
    tabla.setModel(model);
}
    
}
