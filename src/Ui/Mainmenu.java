
package Ui;

import javax.swing.JDialog;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Models.User;
import Models.User.UserRoles;

import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author slavi
 */
public class Mainmenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public Mainmenu() {
        initComponents();
        sortComponents();
//        Pnl_Order.setVisible(false);
//        btn_AddOrder.setVisible(false);
//        btn_Cancelorder.setVisible(false);
        Tbl_Inventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Tbl_Stock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        System.out.println("Welcome " + User.currentUser.getUserName());
//        if(role = staff){
//       Btn_Createuser.setVisible(false);
//       Btn_Deleteuser.setVisible(false);
//       Btn_Addorder.setVisible(false);
//       Btn_Cancelorder.setVisible(false);
//    }
           
    }

    private void sortComponents() {
    	//Default configuration
    	Pnl_Inventory.setVisible(true);
    	Pnl_Order.setVisible(false);
    	btn_AddOrder.setVisible(false);
    	btn_CancelOrder.setVisible(false);

    	UserRoles currentRole = UserRoles.valueOf(User.currentUser.getUserRole());
    	switch (currentRole) {
		case MANAGER: {
			System.out.println("Manager Role");
			
			break;
		}
		case STAFF: {
			System.out.println("Staff Role");
			Pnl_Inventory.setVisible(true);
			btn_AddInventory.setVisible(false);
			btn_AddStock.setVisible(true);
			btn_EditStock.setVisible(true);
			btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			btn_CreateUser.setVisible(false);
			btn_DeleteUser.setVisible(false);
			break;
		}
		case SUPPLIER: {
			System.out.println("Supplier Role");
			Pnl_Inventory.setVisible(false);
			btn_ViewInventory.setVisible(false);
			btn_AddInventory.setVisible(false);
			btn_AddStock.setVisible(false);
			btn_EditStock.setVisible(false);
	    	Pnl_Order.setVisible(true);
	    	btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			btn_CreateUser.setVisible(false);
			btn_DeleteUser.setVisible(false);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentRole.toString());
		}
    }
    
    private void sortInventoryComponents() {
    	Pnl_Inventory.setVisible(true);
    	btn_AddStock.setVisible(true);
		btn_EditStock.setVisible(true);
		Pnl_Order.setVisible(false);
		btn_AddOrder.setVisible(false);
		btn_CancelOrder.setVisible(false);
    	UserRoles currentRole = UserRoles.valueOf(User.currentUser.getUserRole());
    	switch (currentRole) {
		case MANAGER: {
			System.out.println("Manager Role");
			btn_AddInventory.setVisible(true);
			btn_CreateUser.setVisible(true);
			btn_DeleteUser.setVisible(true);
			break;
		}
		case STAFF: {
			System.out.println("Staff Role");
			btn_AddInventory.setVisible(false);
			btn_CreateUser.setVisible(false);
			btn_DeleteUser.setVisible(false);
			
			break;
		}
		case SUPPLIER: {
			System.out.println("Supplier Role");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentRole.toString());
		}
    }
    
    private void sortOrdersComponents() {
    	Pnl_Inventory.setVisible(false);
    	btn_AddInventory.setVisible(false);
    	btn_AddStock.setVisible(false);
    	btn_EditStock.setVisible(false);
    	Pnl_Order.setVisible(true);
    	btn_CreateUser.setVisible(false);
    	btn_DeleteUser.setVisible(false);
        
    	UserRoles currentRole = UserRoles.valueOf(User.currentUser.getUserRole());
    	switch (currentRole) {
		case MANAGER: {
			System.out.println("Manager Role");
			btn_AddOrder.setVisible(true);
			btn_CancelOrder.setVisible(true);
			break;
		}
		case STAFF: {
			System.out.println("Staff Role");
			btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			break;
		}
		case SUPPLIER: {
			System.out.println("Supplier Role");
			btn_AddOrder.setVisible(false);
			btn_CancelOrder.setVisible(false);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentRole.toString());
		}
    }
    
//    private void sortComponents() {
//    	String s = UserRoles.MANAGER.toString();
//    	switch (User.currentUser.getUserRole()) {
//		case UserRoles.MANAGER.toString(): {
//			System.out.println("Manager Role");
//		}
//		case UserRoles.STAFF.toString(): {
//			System.out.println("Staff Role");
//		}
//		case UserRoles.SUPPLIER.toString(): {
//			System.out.println("Supplier Role");
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + User.currentUser.getUserRole().toString());
//		}
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        btn_ViewInventory = new javax.swing.JButton();
        btn_ViewOrders = new javax.swing.JButton();
        btn_Logout = new javax.swing.JButton();
        btn_CancelOrder = new javax.swing.JButton();
        btn_AddInventory = new javax.swing.JButton();
        btn_DeleteUser = new javax.swing.JButton();
        btn_EditStock = new javax.swing.JButton();
        btn_CreateUser = new javax.swing.JButton();
        btn_AddOrder = new javax.swing.JButton();
        btn_AddStock = new javax.swing.JButton();
        Layer = new javax.swing.JLayeredPane();
        Pnl_Order = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Order = new javax.swing.JTable();
        Pnl_Inventory = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Inventory = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tbl_Stock = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ViewInventory.setText("View Inventory");
        btn_ViewInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ViewInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 224, 39));

        btn_ViewOrders.setText("View Orders");
        btn_ViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OrdersActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ViewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, 224, 39));

        btn_Logout.setText("Logout");
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 40));

        btn_CancelOrder.setText("Cancel Order");
        btn_CancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CancelorderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 114, 39));

        btn_AddInventory.setText("Add Inventory");
        btn_AddInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddinventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 39));

        btn_DeleteUser.setText("Delete User");
        btn_DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteuserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_DeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 110, 39));

        btn_EditStock.setText("Edit Stock");
        btn_EditStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EditActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EditStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 114, 39));

        btn_CreateUser.setText("Create User");
        btn_CreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CreateuserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CreateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 39));

        btn_AddOrder.setText("Add Order");
        btn_AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddorderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 114, 39));

        btn_AddStock.setText("Add Stock");
        btn_AddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddstockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AddStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 110, 39));

        Tbl_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Supplier"
            }
        ));
        jScrollPane2.setViewportView(Tbl_Order);
        if (Tbl_Order.getColumnModel().getColumnCount() > 0) {
            Tbl_Order.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout Pnl_OrderLayout = new javax.swing.GroupLayout(Pnl_Order);
        Pnl_Order.setLayout(Pnl_OrderLayout);
        Pnl_OrderLayout.setHorizontalGroup(
            Pnl_OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        Pnl_OrderLayout.setVerticalGroup(
            Pnl_OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_OrderLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tbl_Inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tbl_Inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_InventoryMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Tbl_InventoryMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(Tbl_Inventory);

        Tbl_Stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Serial Number", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tbl_Stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_StockMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Tbl_StockMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(Tbl_Stock);

        javax.swing.GroupLayout Pnl_InventoryLayout = new javax.swing.GroupLayout(Pnl_Inventory);
        Pnl_Inventory.setLayout(Pnl_InventoryLayout);
        Pnl_InventoryLayout.setHorizontalGroup(
            Pnl_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_InventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        Pnl_InventoryLayout.setVerticalGroup(
            Pnl_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_InventoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        Layer.setLayer(Pnl_Order, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Layer.setLayer(Pnl_Inventory, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayerLayout = new javax.swing.GroupLayout(Layer);
        Layer.setLayout(LayerLayout);
        LayerLayout.setHorizontalGroup(
            LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Pnl_Inventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LayerLayout.setVerticalGroup(
            LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(LayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Pnl_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(Layer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 500, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InventoryActionPerformed
        // TODO add your handling code here:
        
//        if(role = staff){
//       Btn_Createuser.setVisible(false);
//       Btn_Deleteuser.setVisible(false);
//       Btn_Addorder.setVisible(false);
//       Btn_Cancelorder.setVisible(false);
//       Btn_Addinventory.setvisible(false);
//                Btn_Addstock.setVisible(true);
//                Btn_Edit.setVisible(true);
//                Pnl_Order.setVisible(false);
//                Pnl_Inventory.setVisible(true);
//    } else
           
        
//    	Pnl_Inventory.setVisible(true);
//        btn_AddInventory.setVisible(true);
//        btn_AddStock.setVisible(true);
//        btn_EditStock.setVisible(true);
//        Pnl_Order.setVisible(false);
//        btn_AddOrder.setVisible(false);
//        btn_Cancelorder.setVisible(false);
    	sortInventoryComponents();
    }//GEN-LAST:event_Btn_InventoryActionPerformed

    private void Btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LogoutActionPerformed
     Login Login = new Login();
        setVisible(false);
       Login.setVisible(true);
    }//GEN-LAST:event_Btn_LogoutActionPerformed

    private void Btn_AddinventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddinventoryActionPerformed
        Addinventory Addinventory = new Addinventory();
      
       Addinventory.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_Btn_AddinventoryActionPerformed

    public static void Addinventorytotable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)Tbl_Inventory.getModel();
        model.addRow(dataRow);
    }
    
    private void Btn_CancelorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CancelorderActionPerformed
        
    }//GEN-LAST:event_Btn_CancelorderActionPerformed

    private void Btn_DeleteuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteuserActionPerformed
         Deleteuser Deleteuser = new Deleteuser();
       Deleteuser.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_Btn_DeleteuserActionPerformed

    private void Btn_OrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OrdersActionPerformed

//        if(role = staff){
//       Btn_Createuser.setVisible(false);
//       Btn_Deleteuser.setVisible(false);
//       Btn_Addorder.setVisible(false);
//       Btn_Cancelorder.setVisible(false);
//       Btn_Addinventory.setvisible(false);
//                Btn_Addstock.setVisible(false);
//                Btn_Edit.setVisible(false);
//                Pnl_Order.setVisible(true);
//                Pnl_Inventory.setVisible(false);
//    } else
        
        
//        btn_AddInventory.setVisible(false);
//        btn_AddStock.setVisible(false);
//        btn_EditStock.setVisible(false);
//        btn_Cancelorder.setVisible(true);
//        btn_AddOrder.setVisible(true);
//        Pnl_Inventory.setVisible(false);
//        Pnl_Order.setVisible(true);
        sortOrdersComponents();
    }//GEN-LAST:event_Btn_OrdersActionPerformed

    private void Btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EditActionPerformed
 EditStock EditStock = new EditStock();
       EditStock.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_Btn_EditActionPerformed

    private void Btn_CreateuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CreateuserActionPerformed
        Adduser Adduser = new Adduser();
       Adduser.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_Btn_CreateuserActionPerformed

    private void Btn_AddorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddorderActionPerformed
        Addorder Addorder = new Addorder();
       Addorder.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_Btn_AddorderActionPerformed

    private void Btn_AddstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddstockActionPerformed
       Addstock Addstock = new Addstock();
       Addstock.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_Btn_AddstockActionPerformed

    private void Tbl_InventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_InventoryMouseClicked
     
        
    
    }//GEN-LAST:event_Tbl_InventoryMouseClicked

    private void Tbl_StockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_StockMouseClicked
          
    }//GEN-LAST:event_Tbl_StockMouseClicked

    private void Tbl_StockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_StockMousePressed
         if(Tbl_Stock.getSelectionModel().isSelectionEmpty()){
        System.out.println("stock is empty");
    } else{
            Tbl_Inventory.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_Tbl_StockMousePressed

    private void Tbl_InventoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_InventoryMousePressed
       if(Tbl_Inventory.getSelectionModel().isSelectionEmpty()){
        System.out.println("inventory is selected");
    } else{
            Tbl_Stock.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_Tbl_InventoryMousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddInventory;
    private javax.swing.JButton btn_AddOrder;
    private javax.swing.JButton btn_AddStock;
    private javax.swing.JButton btn_CancelOrder;
    private javax.swing.JButton btn_CreateUser;
    private javax.swing.JButton btn_DeleteUser;
    private javax.swing.JButton btn_EditStock;
    private javax.swing.JButton btn_ViewInventory;
    private javax.swing.JButton btn_Logout;
    private javax.swing.JButton btn_ViewOrders;
    private javax.swing.JLayeredPane Layer;
    private javax.swing.JPanel Pnl_Inventory;
    private javax.swing.JPanel Pnl_Order;
    private static javax.swing.JTable Tbl_Inventory;
    private javax.swing.JTable Tbl_Order;
    private javax.swing.JTable Tbl_Stock;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
