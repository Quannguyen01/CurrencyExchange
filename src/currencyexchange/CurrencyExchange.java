/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package currencyexchange;

import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Quan Nguyen
 */
public class CurrencyExchange extends javax.swing.JFrame {

    private final CurrencyUnit[] currency = JSONCurrency.getCurrencyUnitsJSON().toArray(new CurrencyUnit[JSONCurrency.getCurrencyUnitsJSON().size()]);
    private CurrencyRate rates = new CurrencyRate("./res/rates.ser", currency);
    private double rate = 1;
    /**
     * Creates new form CurrencyExchange
     */
    public CurrencyExchange() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exchangeRes = new javax.swing.JLabel();
        exchangeAmt = new javax.swing.JFormattedTextField();
        exchangeUnit = new javax.swing.JComboBox();
        resultUnit = new javax.swing.JComboBox();
        exchangeRate = new javax.swing.JLabel();
        resultAmt = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        update = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClosingWindowListener(evt);
            }
        });

        exchangeAmt.setColumns(20);
        exchangeAmt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        exchangeAmt.setToolTipText("");
        exchangeAmt.setPreferredSize(new java.awt.Dimension(171, 20));
        exchangeAmt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                exchangeAmtkeyUp(evt);
            }
        });

        exchangeUnit.setModel(new javax.swing.DefaultComboBoxModel(currency));
        exchangeUnit.setSelectedIndex(0);
        exchangeUnit.setPreferredSize(new java.awt.Dimension(180, 20));
        exchangeUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencyActionListener(evt);
            }
        });

        resultUnit.setModel(new javax.swing.DefaultComboBoxModel(currency));
        resultUnit.setSelectedIndex(0);
        resultUnit.setMinimumSize(new java.awt.Dimension(171, 20));
        resultUnit.setPreferredSize(new java.awt.Dimension(180, 20));
        resultUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencyActionListener(evt);
            }
        });

        exchangeRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exchangeRate.setText("AED/AED = 1.0");

        resultAmt.setEditable(false);
        resultAmt.setColumns(20);
        resultAmt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        resultAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        resultAmt.setText("0.00");
        resultAmt.setPreferredSize(new java.awt.Dimension(171, 20));

        jMenu1.setMnemonic('M');
        jMenu1.setText("Menu");
        jMenu1.setToolTipText("");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        jMenu1.add(about);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jMenu1.add(update);
        jMenu1.add(jSeparator1);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exchangeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exchangeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resultAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(exchangeRes))
                            .addComponent(resultUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(exchangeRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {exchangeAmt, exchangeUnit});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {resultAmt, resultUnit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultAmt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exchangeAmt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exchangeRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(exchangeUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exchangeRate)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_exitActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"<html>This program converts currency!"+
                                           "<br/>Created by Quan Nguyen</html>",
                                           "About", 
                                           JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutActionPerformed

    private void exchangeAmtkeyUp(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exchangeAmtkeyUp
        // TODO add your handling code here:
        if (evt.getKeyChar() != evt.VK_ENTER){
            try{
                double amountExchange = Double.valueOf(exchangeAmt.getText());
                double amountResult = amountExchange * rate;
                resultAmt.setValue(new Double(amountResult));
            } catch (NumberFormatException ex) {
                resultAmt.setText("0.00");
            }
        }
    }//GEN-LAST:event_exchangeAmtkeyUp

    private void CurrencyActionListener(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrencyActionListener
        // TODO add your handling code here:
        CurrencyUnit fromCurrency = ((CurrencyUnit)exchangeUnit.getSelectedItem());
        CurrencyUnit toCurrency = ((CurrencyUnit)resultUnit.getSelectedItem());
        
        rate = rates.getRate(fromCurrency,toCurrency);
        
        if (rate != 0)
            exchangeRate.setText(toCurrency.getCurrencyUnit() + "/" 
                                  + fromCurrency.getCurrencyUnit() + 
                                    " = " + Double.toString(rate));
        else
            exchangeRate.setText("No available rates");
        
        double amountExchange = Double.valueOf(exchangeAmt.getText());
        double amountResult = amountExchange * rate;
        resultAmt.setValue(new Double(amountResult));
    }//GEN-LAST:event_CurrencyActionListener

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        //exchangeRate.setText("Please wait for updating...");
        
        rates.updateTable();
    }//GEN-LAST:event_updateActionPerformed

    private void onClosingWindowListener(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClosingWindowListener
        rates.saveTable();
    }//GEN-LAST:event_onClosingWindowListener

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
            java.util.logging.Logger.getLogger(CurrencyExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrencyExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrencyExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrencyExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyExchange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JFormattedTextField exchangeAmt;
    private javax.swing.JLabel exchangeRate;
    private javax.swing.JLabel exchangeRes;
    private javax.swing.JComboBox exchangeUnit;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JFormattedTextField resultAmt;
    private javax.swing.JComboBox resultUnit;
    private javax.swing.JMenuItem update;
    // End of variables declaration//GEN-END:variables
}
