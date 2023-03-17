package xocotepetl;

import java.awt.Component; 
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Inventario extends javax.swing.JFrame {

    Connection con;
    
    public Inventario() {
        
        this.con = Conexion_interac.getConexion();
        System.out.println("Cargando tabla");
        initComponents();
        mostrar();
        
    }

   
    private void mostrar() {
    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
    for (int column = 0; column < tabla.getColumnCount(); column++)
    {
        TableColumn tableColumn = tabla.getColumnModel().getColumn(column);
        int preferredWidth = tableColumn.getMinWidth();
        int maxWidth = tableColumn.getMaxWidth();
        for (int row = 0; row < tabla.getRowCount(); row++)
        {
            TableCellRenderer cellRenderer = tabla.getCellRenderer(row, column);
            Component c = tabla.prepareRenderer(cellRenderer, row, column);
            int width = c.getPreferredSize().width + tabla.getIntercellSpacing().width;
            preferredWidth = Math.max(preferredWidth, width);
            if (preferredWidth >= maxWidth)
            {
             preferredWidth = maxWidth;
                break;
            }
        }
        tableColumn.setPreferredWidth(preferredWidth);
    }

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
                return false;
        }
    };
    
    modelo.setColumnIdentifiers(new String[]{"ID_Producto", "Nombre", "Descripcion", "Precio"});
 
    try {
        Connection con = Conexion_interac.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT ID_Producto, Nombre, Descripcion, Precio FROM chocolateria");
          
        
        while (rs.next()) { 
        Productos filaProducto = new Productos(rs.getInt("ID_Producto"),rs.getString("Nombre"),rs.getString("Descripcion"), rs.getFloat("Precio"));
            
        Object producto[] = {filaProducto.getIDproducto(),filaProducto.getNombre(),filaProducto.getDescripcion(),filaProducto.getPrecio()};
            
        modelo.addRow(producto); 
    }
        
        tabla.setModel(modelo);
        int vAnchoColumna = 0;
        int vNuevoAnchoColumna = 0;
        
        for (int col = 0; col < tabla.getColumnCount(); col++) {
            vAnchoColumna = 0;
            for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                if (tabla.getValueAt(fila, col).toString().length() > 47) {
                    vNuevoAnchoColumna = 435;
                } else {                
                    vNuevoAnchoColumna = 10 * tabla.getValueAt(fila, col).toString().length();
                }
                if (vNuevoAnchoColumna>vAnchoColumna) {
                    vAnchoColumna = vNuevoAnchoColumna;
                } else {
                    vAnchoColumna = vAnchoColumna;
                }
            }
            tabla.getColumnModel().getColumn(col).setPreferredWidth(vAnchoColumna);
            
        }
        tabla.getColumnModel().getColumn(0).setMinWidth(30);
        tabla.getColumnModel().getColumn(1).setMinWidth(45);
        tabla.getColumnModel().getColumn(2).setMinWidth(60);
        tabla.getColumnModel().getColumn(3).setMinWidth(30);

        
    } catch (SQLException e) {
        System.out.println(e);
        
    }
}
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addproduct = new javax.swing.JButton();
        rmvproduct = new javax.swing.JButton();
        editproduct = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombreproducto = new javax.swing.JTextField();
        descripcionproducto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        codepr = new javax.swing.JLabel();
        ID_Productoin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(184, 124, 61));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Inventario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Salir");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("Caja de cobro");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("Historial de ventas");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(25, 25, 25))
        );

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 52)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inventario");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setToolTipText("Producto");

        addproduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addproduct.setText("Añadir");
        addproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductActionPerformed(evt);
            }
        });

        rmvproduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rmvproduct.setText("Eliminar");
        rmvproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvproductActionPerformed(evt);
            }
        });

        editproduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editproduct.setText("Editar");
        editproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editproductActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre");

        jLabel9.setText("Precio");

        jLabel10.setText("Descripción");

        nombreproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproductoActionPerformed(evt);
            }
        });

        descripcionproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionproductoActionPerformed(evt);
            }
        });

        jLabel13.setText("$");

        codepr.setText("Código");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descripcionproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rmvproduct))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codepr, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_Productoin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editproduct, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addproduct, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(addproduct)
                    .addComponent(codepr))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(editproduct)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ID_Productoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descripcionproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rmvproduct))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(51, 51, 51)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductActionPerformed

        String vID_Producto = ID_Productoin.getText();
        String vNombreProducto = nombreproducto.getText();
        String vDescripcionProducto = descripcionproducto.getText();
        String vPrecio = precio.getText();
        
        try {
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            st.execute("INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES ("+ vID_Producto +",'"+ vNombreProducto + "','" + vDescripcionProducto +"', " + vPrecio +")");
            ID_Productoin.setText("");
            nombreproducto.setText("");
            descripcionproducto.setText("");
            precio.setText("");
            mostrar();
            
            JOptionPane.showMessageDialog(null, "Producto añadido, correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_addproductActionPerformed

    private void editproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editproductActionPerformed

        String vID_Producto = ID_Productoin.getText();
        String vNombreProducto = nombreproducto.getText();
        String vDescripcionProducto = descripcionproducto.getText();
        String vPrecio = precio.getText();
        
        try {
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            st.execute("UPDATE chocolateria SET Nombre = '" + vNombreProducto + "', Descripcion = '" + vDescripcionProducto + "', Precio = " + vPrecio + " WHERE ID_Producto = " + vID_Producto );
            ID_Productoin.setText("");
            nombreproducto.setText("");
            descripcionproducto.setText("");
            precio.setText("");
            mostrar();
            JOptionPane.showMessageDialog(null, "Producto editado, correctamente");
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_editproductActionPerformed

    private void descripcionproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionproductoActionPerformed

    }//GEN-LAST:event_descripcionproductoActionPerformed

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered

    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        CajaDeCobro cj = new CajaDeCobro();
        this.hide();
        cj.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void nombreproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproductoActionPerformed
        String nombre = nombreproducto.getText();
        System.out.println("El nombre del producto es \n"+nombre);
    }//GEN-LAST:event_nombreproductoActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
        if (evt.getClickCount() == 2) {
            int vFilaSeleccionada = tabla.getSelectedRow();
            ID_Productoin.setText(tabla.getValueAt(vFilaSeleccionada, 0).toString());
            nombreproducto.setText(tabla.getValueAt(vFilaSeleccionada, 1).toString());
            descripcionproducto.setText(tabla.getValueAt(vFilaSeleccionada, 2).toString());
            precio.setText(tabla.getValueAt(vFilaSeleccionada, 3).toString());
        } 
    }//GEN-LAST:event_tablaMouseClicked

    private void rmvproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvproductActionPerformed
       
        try {
            int vFilaSeleccionada = tabla.getSelectedRow();
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            st.execute("DELETE FROM `Chocolateria` WHERE ID_Producto = " + tabla.getValueAt(vFilaSeleccionada, 0));
            ID_Productoin.setText("");
            nombreproducto.setText("");
            descripcionproducto.setText("");
            precio.setText("");
            mostrar();
            JOptionPane.showMessageDialog(null, "Producto eliminado, correctamente");
            System.out.println("\nSe ha borrado un producto exitosamenre \n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_rmvproductActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Historial_Ventas hv = new Historial_Ventas();
        this.hide();
        hv.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_Productoin;
    private javax.swing.JButton addproduct;
    private javax.swing.JLabel codepr;
    private javax.swing.JTextField descripcionproducto;
    private javax.swing.JButton editproduct;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreproducto;
    private javax.swing.JTextField precio;
    private javax.swing.JButton rmvproduct;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

}
