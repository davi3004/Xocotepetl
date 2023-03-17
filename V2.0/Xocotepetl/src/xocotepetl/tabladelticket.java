package xocotepetl;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;


public class tabladelticket extends javax.swing.JFrame {


    public tabladelticket() {
        initComponents();
        mostrarticket();
        centrarPantalla();
    }

    private void centrarPantalla(){
    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension ventana = this.getSize();

    int posX = (pantalla.width - ventana.width) /2;
    int posY = (pantalla.height - ventana.height)/2;

    this.setLocation(posX, posY);
    }
    public void mostrarticket() {
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    modelo.setColumnIdentifiers(new String[]{"ID_Transaccion", "Nombre", "Precio", "Cantidad", "Semitotal"});

    try {
        Connection con = Conexion_interac.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT ID_Transaccion, Nombre, Precio, Cantidad, Semitotal FROM ticket");

        while (rs.next()) { 
            Object fila[] = new Object[5];
            fila[0] = rs.getInt("ID_Transaccion");
            fila[1] = rs.getString("Nombre");
            fila[2] = rs.getDouble("Precio");
            fila[3] = rs.getInt("Cantidad");
            fila[4] = rs.getDouble("Semitotal");
            modelo.addRow(fila); 
 
        }
        
        tablaticket.setModel(modelo);
        tablaticket.getColumnModel().getColumn(0).setMinWidth(30);
        tablaticket.getColumnModel().getColumn(1).setMinWidth(45);
        tablaticket.getColumnModel().getColumn(2).setMinWidth(60);
        tablaticket.getColumnModel().getColumn(3).setMinWidth(30);
        tablaticket.getColumnModel().getColumn(4).setMinWidth(60);
        
    } catch (SQLException e) {

    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaticket = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        volver.setFont(new java.awt.Font("Swis721 BdCnOul BT", 0, 48)); // NOI18N
        volver.setText("Regresar");
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton(evt);
            }
        });

        jScrollPane1.setViewportView(tablaticket);

        jLabel2.setFont(new java.awt.Font("Swis721 BdCnOul BT", 0, 48)); // NOI18N
        jLabel2.setText("Carrito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volver)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton
        // TODO add your handling code here:
        Ticket ticket = new Ticket();
            this.hide();
            ticket.setVisible(true);

            
    }//GEN-LAST:event_boton

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tabladelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabladelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabladelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabladelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabladelticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaticket;
    private javax.swing.JLabel volver;
    // End of variables declaration//GEN-END:variables
}
