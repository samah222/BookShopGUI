package com.learning.gui;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public class OrderGUI extends javax.swing.JFrame {

    private ArrayList<String> itemsName ;
    private ArrayList<String> customerName;
    Order order ;
    Vector<Vector> tableData;
    Vector<Vector> customerData;
    DateFormat format = new SimpleDateFormat("MM/dd/YYYY");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    DefaultTableModel model ;
    
    public OrderGUI() {    
        itemsName = new ArrayList<String>();
        customerName = new ArrayList<String>();
        
        initComponents();
        model = (DefaultTableModel) orderItems.getModel();
        dateTF.setText(""+format.format(date));
        setResizable(false); 
        setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        
        try{
            FileInputStream file = new FileInputStream("items-file.bin");
            ObjectInputStream input = new ObjectInputStream(file);
            tableData = (Vector<Vector>)input.readObject();
            file.close();
            input.close();         
            for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
                itemsName.add((String) row.get(1));
            }
            itemsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(itemsName.toArray(new String[0])));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        // get customer names
        try{
            FileInputStream fileCustomer = new FileInputStream("customers-file.bin");
            ObjectInputStream inputCustomer = new ObjectInputStream(fileCustomer);
            customerData = (Vector<Vector>)inputCustomer.readObject();
            fileCustomer.close();
            inputCustomer.close();         
            for(int i=0; i<customerData.size(); i++){
                Vector row = customerData.get(i);
                customerName.add(row.get(0).toString());
            }
            customerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(customerName.toArray(new String[0])));
        }
        catch(Exception ex){
            ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        itemsComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderItems = new javax.swing.JTable();
        dateLabel = new javax.swing.JLabel();
        dateTF = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        payment = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        totalBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        orderId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order Management");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clipboard32.png"))); // NOI18N
        jLabel1.setText("Order Management");

        jPanel2.setOpaque(false);

        itemsComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Select Item");

        quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantity.setText("1");

        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        AddBtn.setText("Add ");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eraser.png"))); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Quantity");

        status.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        status.setForeground(new java.awt.Color(255, 0, 0));
        status.setText("       ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Select Customer");

        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(itemsComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(AddBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearBtn)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(13, 13, 13)
                .addComponent(customerComboBox, 0, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn)
                    .addComponent(clearBtn))
                .addGap(53, 53, 53)
                .addComponent(status)
                .addGap(12, 12, 12))
        );

        orderItems.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item name", "Item Quantity", "Item Price"
            }
        ));
        jScrollPane1.setViewportView(orderItems);

        dateLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dateLabel.setText("Date");

        dateTF.setEditable(false);
        dateTF.setText("  ");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bin.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        total.setEditable(false);
        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setText("0");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        payment.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        payment.setText("Card Payment");
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(102, 0, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Checkout");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setText("Cash Payment");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        totalBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        totalBtn.setForeground(new java.awt.Color(102, 0, 102));
        totalBtn.setText("Create Order ");
        totalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Order Id");

        orderId.setEditable(false);
        orderId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(totalBtn)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(orderId)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(payment))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalBtn)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(orderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton4)
                            .addComponent(payment))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsComboBoxActionPerformed
        Object selectedItem = itemsComboBox.getSelectedItem();
        for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
                if(selectedItem.equals(row.get(1))){
                    quantity.setText(String.valueOf(row.get(3)));
                }
                //System.out.println(row.get(1));                           
            }
    }//GEN-LAST:event_itemsComboBoxActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        
        //if any textfield is null or blank 
        if(quantity.getText() ==null || quantity.getText().isBlank() || !Utilities.isNumeric(quantity.getText())){
            status.setText("Please write a valid number for quantity");
            return;
        }
        
        //if quantity <= 0
        if(Integer.parseInt(quantity.getText()) <= 0){
             status.setText("Please, enter a valid quanity ");
             return;
        }
        
        // get the selectItem 
        Object selectedItem = itemsComboBox.getSelectedItem();
        Double itemQuantity = 0.0;
        
        // search for this selected item in the loaded tableData
        for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
                if(selectedItem.equals(row.get(1))){
                     itemQuantity = Double.valueOf(row.get(3).toString()); 
                }
                //System.out.println(row.get(1));                           
            }
               
        if(Integer.valueOf(quantity.getText())> itemQuantity.intValue() ){
            status.setText("You exceed the avialable item quantity");
            quantity.setText("");
        }
        else {
                Object price = null;
                for(int i=0; i<tableData.size(); i++){
                    Vector row = tableData.get(i);
                    if(selectedItem.equals(row.get(1))){
                        price = row.get(2);
                    }                                           
                }
                    
                DefaultTableModel model = (DefaultTableModel) orderItems.getModel();
                model.addRow(new Object[]{ itemsComboBox.getSelectedItem(), quantity.getText(), price});

                for(int i=0; i<tableData.size(); i++){
                        Vector row = tableData.get(i);
                        if(selectedItem.equals(row.get(1))){
                            Integer newQuantity = Integer.parseInt(row.get(3).toString()) - Integer.valueOf(quantity.getText()); 
                            
                            row.set(3, newQuantity);
                        }                                                 
                    }
                status.setText("Item is added successfully");
        }          
    }//GEN-LAST:event_AddBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = orderItems.getSelectedRow();
        if(row <0 ){
            JOptionPane.showMessageDialog(this, "Please select row", "OK", JOptionPane.ERROR_MESSAGE );
        }
        else {
            model = (DefaultTableModel) orderItems.getModel();
            model.removeRow(row);
            status.setText("Order item is deleted successfully");
        }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        quantity.setText("");
        status.setText("");
        total.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        if(order ==null){
             JOptionPane.showMessageDialog(this, "Please make order first", "OK", JOptionPane.ERROR_MESSAGE );
             return;
        }
        new CardGUI(order).setVisible(true);
    }//GEN-LAST:event_paymentActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
       DefaultTableModel model = (DefaultTableModel) orderItems.getModel();
        Vector<Vector> tableData = model.getDataVector();
        double orderTotal = 0;
        ArrayList<Integer> items = new ArrayList<Integer>();
        for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
               // Intger itemQuantity = row.get(i)
                //itemQuantity = Integer.valueOf((String)row.get(2)); 
                
                //System.out.println("inside totalActionPerformed : " + row.get(2)); 
                orderTotal += Double.valueOf((String) row.get(2)) ;
            }
        total.setText(String.valueOf(orderTotal));
    }//GEN-LAST:event_totalActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        /*DefaultTableModel model = (DefaultTableModel) orderItems.getModel();
        Vector<Vector> tableData = model.getDataVector();
        FileOutputStream file;
        try {
            file = new FileOutputStream("orders-file.bin");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(tableData);
        }
        catch (Exception ex) {
            //ex.printStackTrace();
            System.out.print("Exception in OrderGUI : formWindowClosed");
        }*/
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       /* try{
            FileInputStream file = new FileInputStream("orders-file.bin");
            ObjectInputStream input = new ObjectInputStream(file);
            Vector<Vector> tableData = (Vector<Vector>)input.readObject();
            file.close();
            input.close();
            
            DefaultTableModel model = (DefaultTableModel) orderItems.getModel();
            for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
                model.addRow(new Object[]{row.get(0), row.get(1), row.get(2)});
            }
        }
        catch(Exception ex){
            System.out.print("Exception in OrderGUI : formWindowOpened");
            //ex.printStackTrace();
        }*/
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       /*  DefaultTableModel model = (DefaultTableModel) orderItems.getModel();
        Vector<Vector> tableData = model.getDataVector();
        FileOutputStream file;
        try {
            file = new FileOutputStream("orders-file.bin");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(tableData);
        }
        catch (Exception ex) {
            //ex.printStackTrace();
            System.out.print("Exception in OrderGUI : formWindowClosing");
        }*/
    }//GEN-LAST:event_formWindowClosing

    private void totalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderItems.getModel();
        Vector<Vector> tableData = model.getDataVector();
        double orderTotal = 0;
        List<Item> orderItems = new ArrayList<Item>();
        ArrayList<Integer> items = new ArrayList<Integer>();
        for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
               // Intger itemQuantity = row.get(i)
                //itemQuantity = Integer.valueOf((String)row.get(2)); 
                
                //System.out.println("inside totalActionPerformed : " + row.get(2));
                // multiply the price  with quantity
                orderItems.add(new Item(row.get(0).toString(), Double.parseDouble(row.get(2).toString()), Integer.parseInt(row.get(1).toString())));
                orderTotal +=  Integer.valueOf(row.get(1).toString()) * Double.valueOf( row.get(2).toString()) ;
            }
        order = new Order();
        order.setItems(orderItems);
        order.getTotal();
        total.setText(String.valueOf(orderTotal));
        orderId.setText(String.valueOf(order.getOrderId()));
        String selectedCustomer =  customerComboBox.getSelectedItem().toString();
        if(selectedCustomer != null && !selectedCustomer.isBlank()){
            Customer customer = new Customer();
            customer.setName(selectedCustomer);
            for(int i=0; i<tableData.size(); i++){
                    Vector row = customerData.get(i);
                    if(row.get(0).equals(customerComboBox.getSelectedItem())){
                        customer.setLoyaltyPoints(Integer.valueOf(row.get(2).toString()));
                        customer.setPhone(row.get(1).toString());
                    }
            }
            status.setText("The order is created successfuly");
        }
        
    }//GEN-LAST:event_totalBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if(order ==null){
             JOptionPane.showMessageDialog(this, "Please make order first", "OK", JOptionPane.ERROR_MESSAGE );
             return;
        }
        CashGUI cashGUI = new CashGUI(Double.valueOf(total.getText()));
        cashGUI.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void customerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboBoxActionPerformed
        Object selectedItem = customerComboBox.getSelectedItem();
        for(int i=0; i<tableData.size(); i++){
                Vector row = tableData.get(i);
                if(selectedItem.equals(row.get(1))){
                    quantity.setText(String.valueOf(row.get(3)));
                }
                //System.out.println(row.get(1));                           
            }
    }//GEN-LAST:event_customerComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<String> customerComboBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTF;
    private javax.swing.JComboBox<String> itemsComboBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orderId;
    private javax.swing.JTable orderItems;
    private javax.swing.JButton payment;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel status;
    private javax.swing.JTextField total;
    private javax.swing.JButton totalBtn;
    // End of variables declaration//GEN-END:variables
}