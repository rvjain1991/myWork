/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital;

import Business.DrugPackage.Drug;
import Business.EcoSystem;
import Business.EnterprisePackage.Enterprise;
import Business.EnterprisePackage.HospitalEnterprise;
import Business.UserAccountPackage.UserAccount;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rishabh
 */
public class DispenserManagerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DispenserManagerJPanel
     */
    JPanel userProcessContainer;
    HospitalEnterprise hospitalEnterprise;
    UserAccount account;
    EcoSystem business;
   public DispenserManagerJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, EcoSystem business) {
         initComponents();
         this.business = business;
         this.userProcessContainer=userProcessContainer;
         this.account=account;
         hospitalEnterprise=(HospitalEnterprise)enterprise;
         lblDrugManagerName.setText("Dsepenser Manager Name is : " + account.getEmployee().getFirstName());
        
        
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        lblDate.setText(dateNow);
        Refresh();
    }
public void Refresh() {
        int rowCount=tblHospitalDrugDirectory.getRowCount();
        DefaultTableModel dtm=(DefaultTableModel)tblHospitalDrugDirectory.getModel();
        for(int i=rowCount-1;i>=0;i--){
            
            dtm.removeRow(i);
        }
        for (Drug drug : hospitalEnterprise.getDrugDirectory().getDrugDirectory()) {
            Object row[] = new Object[6];
            row[0] = drug.getDrugId();
            row[1] = drug.getDrugName();
            row[2] = drug.getExpiryDate();
            row[3] = drug.getManufacturerName();
            row[4] = drug.getNoOfUnits();
            row[5] = drug.getUnitPrice();

            if (!(drug.getNoOfUnits()== 0)) {
                dtm.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDrugManagerName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHospitalDrugDirectory = new javax.swing.JTable();
        btnViewAllOrders1 = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Dispenser Manager Work Area");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Hospital Drug Directory");

        tblHospitalDrugDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Drug ID", "Drug Name", "ExpiryDate", "Manufacturer Name", "Number Of Units", "Price Of Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHospitalDrugDirectory);

        btnViewAllOrders1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewAllOrders1.setText("View All Orders");
        btnViewAllOrders1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllOrders1ActionPerformed(evt);
            }
        });

        btnPlaceOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPlaceOrder.setText("Place An Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDrugManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewAllOrders1)
                    .addComponent(btnPlaceOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDrugManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(btnViewAllOrders1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlaceOrder)
                .addGap(91, 91, 91))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAllOrders1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllOrders1ActionPerformed

        DispenserViewAllOrderJPanel dispenserPanel = new DispenserViewAllOrderJPanel(userProcessContainer, hospitalEnterprise, account,business);
        userProcessContainer.add("View Dispenser's All Orders", dispenserPanel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewAllOrders1ActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed

        DispPlaceOrderToWareManagerJPanel placePanel = new DispPlaceOrderToWareManagerJPanel(userProcessContainer, hospitalEnterprise, account, business);
        userProcessContainer.add("Place Order To Warehouse Manager", placePanel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlaceOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnViewAllOrders1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDrugManagerName;
    private javax.swing.JTable tblHospitalDrugDirectory;
    // End of variables declaration//GEN-END:variables
}
