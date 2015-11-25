package com.thumbcash.windows;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import com.thumbcash.helpers.DBHelper;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ViewUsers extends JDialog {
    
    public ViewUsers(Frame parent, boolean modal) {
        super(parent, modal);
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception e) {}
        initComponents();
        populateTable();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblUsers.getModel());
        tblUsers.setRowSorter(sorter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        pnlUsers = new javax.swing.JPanel();
        scrollUsers = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        btnDelUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thumbcash - Usuarios Registrados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlUsers.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsers.setRowSelectionAllowed(false);
        tblUsers.getTableHeader().setReorderingAllowed(false);
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        scrollUsers.setViewportView(tblUsers);

        javax.swing.GroupLayout pnlUsersLayout = new javax.swing.GroupLayout(pnlUsers);
        pnlUsers.setLayout(pnlUsersLayout);
        pnlUsersLayout.setHorizontalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlUsersLayout.setVerticalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        btnDetails.setText("Ver detalles...");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnDelUser.setText("Eliminar");
        btnDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelUser)
                        .addGap(0, 243, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails)
                    .addComponent(btnDelUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
       
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        row = tblUsers.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblUsersMouseClicked

    private void btnDelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelUserActionPerformed
        String name = tblUsers.getValueAt(row, 0).toString();
        String apellido = tblUsers.getValueAt(row, 1).toString();
        try {
            Connection conn = helper.conectar();
            PreparedStatement pst = conn.prepareStatement("DELETE FROM usuarios WHERE nombre = ? AND apellido = ?;");
            pst.setString(1, name);
            pst.setString(2, apellido);
            pst.execute();
            conn.close();
            populateTable();
        } catch (Exception e){}
    }//GEN-LAST:event_btnDelUserActionPerformed
    
    public void populateTable() {
        try {
            Connection conn = helper.conectar();
            PreparedStatement pst = conn.prepareStatement("SELECT nombre AS 'Nombre(s)', apellido as 'Apellido(s)', direccion AS 'Dirección', telefono AS 'Telefono', ciudad_edo AS 'Ciudad y Estado', creditos AS 'Credito disponible' FROM usuarios;");
            ResultSet rs = pst.executeQuery();
            tblUsers.setModel(DbUtils.resultSetToTableModel(rs));
            conn.close();
        } catch (Exception e){}
    }

    DBHelper helper = new DBHelper();
    int row = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelUser;
    private javax.swing.JButton btnDetails;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel pnlUsers;
    private javax.swing.JScrollPane scrollUsers;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables
}
