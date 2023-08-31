package mitarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class miframe extends javax.swing.JFrame {
    DefaultTableModel modelo;
    Connection con;
    int id;
    public miframe() {
            initComponents();
            mostrartodos();
            //limpiar();
            //bloquear();
    }
    
    void limpiar(){
        txtnombre.setText("");
        txtapellidos.setText("");
        txtcedula.setText("");
        txtemail.setText("");
    }
    
    void bloquear(){
        txtnombre.setEnabled(false);
        txtapellidos.setEnabled(false);
        txtcedula.setEnabled(false);
        txtemail.setEnabled(false);
        btnnuevo.setEnabled(false);
        btnguardar.setEnabled(false);
        btneditar.setEnabled(false);
    }
    
    void desbloquear(){
        txtnombre.setEnabled(true);
        txtapellidos.setEnabled(true);
        txtcedula.setEnabled(true);
        txtemail.setEnabled(true);
        btnnuevo.setEnabled(false);
        btnguardar.setEnabled(true);
    }

    void mostrartodos(){
        String titulos[]={"id","nombre","apellido","cedula","email"};
        String registros[]= new String[5];
        String query="select * From usuarios";
        modelo = new DefaultTableModel(null, titulos);
        PreparedStatement pst;
        Statement st;
        try {
            con = conexion.open();
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                registros[0]=rs.getString("id");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("cedula");
                registros[4]=rs.getString("email");
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
            con.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }

    void cargardatos() {
    int fila;
    fila = tabla.getSelectedRow();
    if (fila >=0) { 
        id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
        txtnombre.setText(tabla.getValueAt(fila, 1).toString());
        txtapellidos.setText(tabla.getValueAt(fila, 2).toString());
        txtcedula.setText(tabla.getValueAt(fila, 3).toString());
        txtemail.setText(tabla.getValueAt(fila, 4).toString());
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
    }
}

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CRUD REGISTRO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("APELLIDOS:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CEDULA:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("EMAIL:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Cedula", "Email"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcedula)
                                    .addComponent(txtemail)
                                    .addComponent(txtnombre)
                                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1)))
                .addGap(161, 376, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditar)
                    .addComponent(btneliminar)
                    .addComponent(btnlimpiar))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void miframe() {
    btneliminar.setText("ELIMINAR");
    btneliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btneliminarActionPerformed(evt);
        }
    });

    // ... (más código generado por NetBeans)
}

    
    
    
    
    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
      
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      String nom,ape,ced,ema;
       nom = txtnombre.getText().trim();
       ape = txtapellidos.getText().trim();
       ced = txtcedula.getText().trim();
       ema = txtemail.getText().trim();
       
        if (nom.equals("")||ape.equals("")||ced.equals("")||ema.equals("")) {
            JOptionPane.showMessageDialog(this,"LOS CAMPOS SON OBLIGATORIOS");
            
        }else {
            String query = "insert into usuarios(nombre,apellido,cedula,email) values(?,?,?,?)";
        try {
            con = conexion.open();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, ced);
            pst.setString(4, ema);
            int rs = pst.executeUpdate();
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "registro exitoso");
                mostrartodos();
            } else {
                JOptionPane.showMessageDialog(null, "registro fallido");
            }
            con .close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        }
         
       
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
cargardatos();
    }//GEN-LAST:event_tablaMouseClicked

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
       String nom,ape,ced,ema;
       nom = txtnombre.getText();
       ape = txtapellidos.getText();
       ced = txtcedula.getText();
       ema = txtemail.getText();
       
       String query = "update usuarios set nombre=?,apellido=?,cedula=?,email=?";
        try {
            con = conexion.open();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setString(3, ced);
            pst.setString(4, ema);
            pst.setInt(5, id);
            
            int rs = pst.executeUpdate();
            if(rs>0) {
                JOptionPane.showMessageDialog(null, "registro actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Actualizacion fallida");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
     if (txtcedula.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(this, "DEBE INGRESAR NUMERO DE CEDULA");
    }else {
         String ced = txtcedula.getText();
         try {
             
             con = conexion.open();
             String query;
             query = "Delete from usuarios where cedula=?";
             PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1, ced);
             
             int op = JOptionPane.showConfirmDialog(this, "¿DESEA ELIMINAR DEL REGISTRO?");
             if(op == 0) {
                boolean rta = pst.execute();
             if (rta == false) {
                 JOptionPane.showMessageDialog(this, "SE ELIMINO CORRECTAMENTE");
                 mostrartodos();
             } else {
                 JOptionPane.showMessageDialog(this, "NO SE PUDO ELIMIMNAR");
             } 
             } else {
                 JOptionPane.showMessageDialog(this, "ELIMINACION CANCELADA");
             }
             
             con.close();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.toString());
         }
     } 
     
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
 limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
limpiar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
         if (txtbuscar.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(this, "DEBE INGRESAR NUMERO DE CEDULA");
    }else {
         String ced = txtbuscar.getText();
         try {
             
             con = conexion.open();
             String query;
             query = "select * from usuarios where cedula=?";
             PreparedStatement pst = con.prepareStatement(query);
             pst.setString(1, ced);
 
            
                ResultSet rta;
                rta= pst.executeQuery();
                rta.next();
                txtnombre.setText(rta.getString("nombre"));
                txtapellidos.setText(rta.getString("apellido"));
                txtcedula.setText(rta.getString("cedula"));
                txtemail.setText(rta.getString("email"));
             con.close();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.toString());
         }
     } 
    }//GEN-LAST:event_btnbuscarActionPerformed


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
            java.util.logging.Logger.getLogger(miframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(miframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(miframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(miframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new miframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
