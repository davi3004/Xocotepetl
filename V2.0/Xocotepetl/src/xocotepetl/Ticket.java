package xocotepetl;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public final class Ticket extends javax.swing.JFrame {

       public Ticket() {
        initComponents();
        centrarPantalla();
        System.out.println("El total de ventas es: " + calcularTotalVentas() + "\nha comprado " +contarProductosVendidos());
        lblPrecio.setText("Su total ha sido de $" + calcularTotalVentas() + " MXN");
        lblProductosComprados.setText("\nHa comprado " + contarProductosVendidos() + " productos");
    }

 

        private void centrarPantalla(){
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

            Dimension ventana = this.getSize();

            int posX = (pantalla.width - ventana.width) /2;
            int posY = (pantalla.height - ventana.height)/2;

            this.setLocation(posX, posY);
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
    
    private static int contarProductosVendidos() {
        int numProductosVendidos = 0;
        try {
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(Cantidad) AS NumProductosVendidos FROM ventas");
            if (rs.next()) {
                numProductosVendidos = rs.getInt("NumProductosVendidos");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numProductosVendidos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblPrecio = new javax.swing.JLabel();
        lblSalida = new javax.swing.JLabel();
        lblProductosComprados = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        tablaventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaventasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaventas);

        setTitle("Total");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Swis721 BdCnOul BT", 0, 48)); // NOI18N
        jLabel1.setText("Salir");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Swis721 BdCnOul BT", 0, 48)); // NOI18N
        jLabel2.setText("Ticket");

        lblPrecio.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblPrecio.setText("Costo");

        lblSalida.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblSalida.setText("Gracias por su preferencia, ¡Vuelva pronto!");

        lblProductosComprados.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblProductosComprados.setText("Total");

        jLabel3.setFont(new java.awt.Font("Swis721 BdCnOul BT", 0, 48)); // NOI18N
        jLabel3.setText("Regresar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Swis721 BdCnOul BT", 0, 48)); // NOI18N
        jLabel4.setText("Carrito");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                                        .addComponent(lblProductosComprados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductosComprados)
                .addGap(18, 18, 18)
                .addComponent(lblSalida)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
        try {
            pasarDatosAHistorial();
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement(); 
            
            ResultSet resultadoDeConteo = st.executeQuery("select count(*) as count from ventas");
            resultadoDeConteo.next();

            int count = resultadoDeConteo.getInt("count");

            if (count > 0) {
                st.executeUpdate("delete from ventas");
                System.out.println("\n"+count + " registros eliminados de la tabla ventas.");
                try {
                    Connection con2 = Conexion_interac.getConexion();
                    Statement st2 = con2.createStatement();
                    st2.executeUpdate("DELETE FROM ticket"); // Eliminar todas las filas de la tabla "ticket"
                    System.out.println("Se eliminaron todos los datos de la tabla ticket.");
                } catch (Exception e) {
                    System.out.println("Error al eliminar los datos de la tabla ticket: " + e.getMessage());
                }
            } else {
                System.out.println("\nNo existen registros en la tabla ventas.");
            }        
        } catch (Exception e) {
            System.out.println("\nAlgo ha fallado: " + e.getMessage());
        }
        pasarDatosAHistorial();
        System.exit(0);

    }//GEN-LAST:event_jLabel1MouseClicked

    private void pasarDatosAHistorial() {
    final String SELECT_TICKET_QUERY = "SELECT ID_Transaccion, Nombre, Precio, Cantidad, Semitotal FROM ticket";
    final String INSERT_HISTORIAL_QUERY = "INSERT INTO historial(ID_Transaccion, Nombre, Precio, Cantidad, Semitotal) VALUES (?, ?, ?, ?, ?)";
    
    try (Connection con = Conexion_interac.getConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(SELECT_TICKET_QUERY);
         PreparedStatement ps = con.prepareStatement(INSERT_HISTORIAL_QUERY)) {
        
        while (rs.next()) {
            int idTransaccion = rs.getInt("ID_Transaccion");
            String nombre = rs.getString("Nombre");
            double precio = rs.getDouble("Precio");
            int cantidad = rs.getInt("Cantidad");
            double semitotal = rs.getDouble("Semitotal");

            ps.setInt(1, idTransaccion);
            ps.setString(2, nombre);
            ps.setDouble(3, precio);
            ps.setInt(4, cantidad);
            ps.setDouble(5, semitotal);
            ps.addBatch();
        }

        int[] filasInsertadas = ps.executeBatch();
        System.out.println("Filas insertadas en historial: " + filasInsertadas.length);

    } catch (SQLException e) {
        System.out.println("Error al pasar datos a historial: " + e.getMessage());
    }
}

    
    
    
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
  
        CajaDeCobro cj = new CajaDeCobro();
        this.hide();
        cj.setVisible(true);
            try {
                Connection con = Conexion_interac.getConexion();
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM ticket"); // Eliminar todas las filas de la tabla "ticket"
                System.out.println("Se eliminaron todos los datos de la tabla ticket.");
            } catch (Exception e) {
                System.out.println("Error al eliminar los datos de la tabla ticket: " + e.getMessage());
            }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tablaventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaventasMouseClicked

    }//GEN-LAST:event_tablaventasMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
   
        tabladelticket carrito =  new tabladelticket();
        this.hide();
        carrito.setVisible(true);
       
    }//GEN-LAST:event_jLabel4MouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Ticket().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProductosComprados;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JTable tablaventas;
    // End of variables declaration//GEN-END:variables
}
