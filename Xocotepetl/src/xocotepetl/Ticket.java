package xocotepetl;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblPrecio = new javax.swing.JLabel();
        lblSalida = new javax.swing.JLabel();
        lblProductosComprados = new javax.swing.JLabel();

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
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(lblProductosComprados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblProductosComprados)
                .addGap(18, 18, 18)
                .addComponent(lblSalida)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
        try {
            
            Connection con = Conexion_interac.getConexion();
            Statement st = con.createStatement();   
            ResultSet resultadoDeConteo = st.executeQuery("select count(*) as count from ventas");
            resultadoDeConteo.next();
            
            int count = resultadoDeConteo.getInt("count");
            
            if (count > 0) {
                st.executeUpdate("delete from ventas");
                System.out.println("\n"+count + " registros eliminados de la tabla ventas.");
            } else {
                System.out.println("\nNo existen registros en la tabla ventas.");
            }
            
        } catch (Exception e) {
             System.out.println("\nAlgo ha fallado: " + e.getMessage());
        }

        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProductosComprados;
    private javax.swing.JLabel lblSalida;
    // End of variables declaration//GEN-END:variables
}
