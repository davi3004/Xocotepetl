package xocotepetl;


import java.awt.Component;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class CajaDeCobro extends javax.swing.JFrame {


    public CajaDeCobro() {
        initComponents();
        comboProducto();
        mostrar();
        
        lblsubtotal.setText("El total de su compra es de $" + calcularTotalVentas()  + " MXN");
    }
    
   
    private void comboProducto(){
        try {

                Connection con = Conexion_interac.getConexion();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT ID_Producto, Nombre FROM chocolateria");
                while (rs.next()) {
                    listadoProductos.addItem(rs.getString("ID_Producto") + " - " + rs.getString("Nombre"));            
                }
                listadoProductos.setSelectedIndex(-1);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            codigoproducto.setText("");
            productomostrado.setText("");
            precioproducto.setText("");
    }
    
    
    private static double calcularTotalVentas() {
        double totalVentas = 0.0;
        try {
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(Cantidad * Precio) AS TotalVentas FROM ventas");
            if (rs.next()) {
                totalVentas = rs.getDouble("TotalVentas");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return totalVentas;
    }
    
    private void mostrar() {
    tablaventas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    for (int column = 0; column < tablaventas.getColumnCount(); column++)
    {
        TableColumn tableColumn = tablaventas.getColumnModel().getColumn(column);
        int preferredWidth = tableColumn.getMinWidth();
        int maxWidth = tableColumn.getMaxWidth();
        for (int row = 0; row < tablaventas.getRowCount(); row++)
        {
            TableCellRenderer cellRenderer = tablaventas.getCellRenderer(row, column);
            Component c = tablaventas.prepareRenderer(cellRenderer, row, column);
            int width = c.getPreferredSize().width + tablaventas.getIntercellSpacing().width;
            preferredWidth = Math.max(preferredWidth, width);
            if (preferredWidth >= maxWidth)
            {
             preferredWidth = maxWidth;
                break;
            }
        }
        tableColumn.setPreferredWidth(preferredWidth);
    }

    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"ID_Producto", "Nombre", "Precio", "Cantidad"});
    
    try {
        Connection con = Conexion_interac.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT ID_Producto, Nombre, Precio, Cantidad FROM Ventas");
        
        while (rs.next()) {
            Object[] fila = new Object[4];
            fila[0] = rs.getInt("ID_Producto");
            fila[1] = rs.getString("Nombre");
            fila[2] = rs.getDouble("Precio");
            fila[3] = rs.getInt("Cantidad");
            modelo.addRow(fila);
        }
        
        tablaventas.setModel(modelo);
        tablaventas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaventas.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaventas.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaventas.getColumnModel().getColumn(3).setPreferredWidth(50);
        
    } catch (Exception e) {
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        codigoproducto = new javax.swing.JTextField();
        productomostrado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        listadoProductos = new javax.swing.JComboBox<>();
        lblsubtotal = new javax.swing.JLabel();
        cerrarcuenta = new javax.swing.JButton();
        precioproducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(184, 124, 61));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Inventario");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(50, 50, 50))
        );

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 52)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Caja de cobro");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jLabel7.setText("Código");

        jLabel8.setText("Nombre");

        jLabel9.setText("Precio");

        jLabel10.setText("Producto");

        jLabel11.setText("Cantidad");

        codigoproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoproductoActionPerformed(evt);
            }
        });

        productomostrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productomostradoActionPerformed(evt);
            }
        });

        jLabel13.setText("$");

        cantidad.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cantidadInputMethodTextChanged(evt);
            }
        });
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        listadoProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listadoProductosItemStateChanged(evt);
            }
        });
        listadoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoProductosActionPerformed(evt);
            }
        });

        lblsubtotal.setText("El total de su compra es de $0.0 MXN");

        cerrarcuenta.setText("Finalizar compra");
        cerrarcuenta.setToolTipText("");
        cerrarcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarcuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(addproduct)
                                .addGap(18, 18, 18)
                                .addComponent(rmvproduct)
                                .addGap(300, 300, 300)
                                .addComponent(cerrarcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(192, 192, 192))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(listadoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(precioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(productomostrado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productomostrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listadoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsubtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addproduct)
                    .addComponent(rmvproduct)
                    .addComponent(cerrarcuenta))
                .addContainerGap())
        );

        tablaventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaventasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaventas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(223, 223, 223)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(58, 58, 58)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductActionPerformed
        // TODO add your handling code here:
        String vCodigoProducto = codigoproducto.getText();
        String vIngredienteProducto = productomostrado.getText();
        String vPrecio = precioproducto.getText();
        String vCantidad = cantidad.getText();
        int intcantidad = Integer.parseInt(vCantidad);
        Double precio = Double.valueOf(vPrecio);
                
        try {
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            st.execute("INSERT INTO ventas (ID_Producto, Nombre, Precio, Cantidad) "
                    + "values(" + vCodigoProducto + ",'" + vIngredienteProducto + "', " 
                    + vPrecio + "," + vCantidad + ")");
            
            codigoproducto.setText(""); 
            productomostrado.setText(""); 
            precioproducto.setText(""); 
            cantidad.setText("");
            mostrar();
         
            lblsubtotal.setText("El total de su compra es de $" + calcularTotalVentas()  + " MXN");
            JOptionPane.showMessageDialog(null, "Cobro añadido, correctamente"
                    + " \n El total de lo añadido es de $ " + intcantidad*precio + "MXN");
             
            
        } catch (Exception e) {
            System.out.println(e);
        }
        listadoProductos.setSelectedIndex(-1);
        
    }//GEN-LAST:event_addproductActionPerformed

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered

    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       
        try {
            
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();   
            ResultSet resultadoDeConteo = st.executeQuery("select count(*) as count from ventas");
            resultadoDeConteo.next();
            
            int count = resultadoDeConteo.getInt("count");
            
            if (count > 0) {
                st.executeUpdate("delete from ventas");
                System.out.println(count + " registros eliminados de la tabla ventas.");
            } else {
                System.out.println("No existen registros en la tabla ventas.");
            }
            
        } catch (Exception e) {
             System.out.println("\nAlgo ha fallado: " + e.getMessage());
        }

        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
        Inventario inv = new Inventario();
            this.hide();
            inv.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        
    }//GEN-LAST:event_cantidadActionPerformed

    private void listadoProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listadoProductosItemStateChanged
        
    }//GEN-LAST:event_listadoProductosItemStateChanged

    private void listadoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoProductosActionPerformed
                
                String selectedProduct = listadoProductos.getSelectedItem().toString();
                String[] datosProducto = selectedProduct.split(" - ");
                String selectedProductId = datosProducto[0];

                try {
                    Connection con = Conexion_interac.getConexion();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT Precio FROM chocolateria WHERE ID_Producto = " + selectedProductId);
                    if (rs.next()) {
                        String precio = rs.getString("Precio");
                        
                        precioproducto.setText(precio);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                codigoproducto.setText(datosProducto[0]);
                productomostrado.setText(datosProducto[1]);

    }//GEN-LAST:event_listadoProductosActionPerformed

    private void rmvproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvproductActionPerformed
        
        String vCodigoProducto = tablaventas.getValueAt(tablaventas.getSelectedRow(),0).toString();
        String vIngredienteProducto = tablaventas.getValueAt(tablaventas.getSelectedRow(),1).toString();
        String vPrecio = tablaventas.getValueAt(tablaventas.getSelectedRow(),2).toString(); 
        
        try {
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            st.execute("DELETE FROM ventas WHERE ID_Producto = " + vCodigoProducto + " AND "
                    + "Nombre = '" + vIngredienteProducto + "' AND "
                    + "Precio = " + vPrecio); 
            
            mostrar();
            lblsubtotal.setText("El total de su compra es de $" + calcularTotalVentas()  + " MXN");
            JOptionPane.showMessageDialog(null, "Cobro eliminado, correctamente");
        } catch (Exception e) {
            System.out.println(e);
        } 
        listadoProductos.setSelectedIndex(-1);
    }//GEN-LAST:event_rmvproductActionPerformed

    private void cantidadInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cantidadInputMethodTextChanged
       
         
    }//GEN-LAST:event_cantidadInputMethodTextChanged

    private void productomostradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productomostradoActionPerformed
 
    }//GEN-LAST:event_productomostradoActionPerformed

    private void cerrarcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarcuentaActionPerformed

        Ticket ticket = new Ticket();
            this.hide();
            ticket.setVisible(true);
            pasarDatosAVentas();
            
    }//GEN-LAST:event_cerrarcuentaActionPerformed
private void pasarDatosAVentas() {
    final String SELECT_VENTAS_QUERY = "SELECT Nombre, Precio, Cantidad FROM Ventas";
    final String INSERT_TICKET_QUERY = "INSERT INTO ticket(ID_Transaccion, Nombre, Precio, Cantidad, Semitotal) VALUES (?, ?, ?, ?, ?)";
    
    try (Connection con = Conexion_interac.getConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(SELECT_VENTAS_QUERY);
         PreparedStatement ps = con.prepareStatement(INSERT_TICKET_QUERY)) {
        
        while (rs.next()) {
            String nombre = rs.getString("Nombre");
            double precio = rs.getDouble("Precio");
            int cantidad = rs.getInt("Cantidad");
            double semitotal = precio * cantidad;
            int idTransaccion = (int) (Math.random() * 900) + 100;

            ps.setInt(1, idTransaccion);
            ps.setString(2, nombre);
            ps.setDouble(3, precio);
            ps.setInt(4, cantidad);
            ps.setDouble(5, semitotal);
            ps.addBatch();
        }

        int[] filasInsertadas = ps.executeBatch();
        System.out.println("Filas insertadas en ticket: " + filasInsertadas.length);

    } catch (SQLException e) {
        System.out.println("Error al pasar datos a ventas: " + e.getMessage());
    }
}





    private void codigoproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoproductoActionPerformed

    }//GEN-LAST:event_codigoproductoActionPerformed

    private void tablaventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaventasMouseClicked
       
        if (evt.getClickCount() == 2) {
            int vFilaSeleccionada = tablaventas.getSelectedRow();
            codigoproducto.setText(tablaventas.getValueAt(vFilaSeleccionada, 0).toString());
            productomostrado.setText(tablaventas.getValueAt(vFilaSeleccionada, 1).toString());
            precioproducto.setText(tablaventas.getValueAt(vFilaSeleccionada, 2).toString());
            cantidad.setText(tablaventas.getValueAt(vFilaSeleccionada, 3).toString());
        } 
    }//GEN-LAST:event_tablaventasMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Historial_Ventas hv = new Historial_Ventas();
            this.hide();
            hv.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CajaDeCobro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addproduct;
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton cerrarcuenta;
    private javax.swing.JTextField codigoproducto;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JComboBox<String> listadoProductos;
    private javax.swing.JTextField precioproducto;
    private javax.swing.JTextField productomostrado;
    private javax.swing.JButton rmvproduct;
    private javax.swing.JTable tablaventas;
    // End of variables declaration//GEN-END:variables
}
