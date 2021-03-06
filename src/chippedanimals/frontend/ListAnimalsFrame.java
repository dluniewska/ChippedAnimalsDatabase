/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chippedanimals.frontend;

import chippedanimals.backend.ChippedAnimal;
import chippedanimals.backend.Database;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author lunie
 */
public class ListAnimalsFrame extends javax.swing.JFrame {

    /**
     * Creates new form ListAnimalsFrame
     */
    public ListAnimalsFrame() {
        initComponents();
        aa = new AddAnimalFrame();
        aa.setTitle("Add new chipped animal to database");
        aa.setSize(640, 480);
        ListsTable.setEnabled(false);

        ea = new EditAnimalFrame();
        ea.setTitle("Edit animal in database");
        ea.setSize(640, 480);

        db = new Database();
        modelString = new String[]{"ID", "Name", "Kind", "Chip", "Phone", "Email"};

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bAll = new javax.swing.JButton();
        bCats = new javax.swing.JButton();
        bDogs = new javax.swing.JButton();
        lAll = new javax.swing.JLabel();
        lCats = new javax.swing.JLabel();
        lDogs = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListsTable = new javax.swing.JTable();
        InputID = new javax.swing.JTextField();
        bDelete = new javax.swing.JButton();
        lDelete = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        bExcel = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        mbExit = new javax.swing.JMenu();
        mExit = new javax.swing.JMenuItem();
        mbActions = new javax.swing.JMenu();
        mAddNew = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));

        bAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bAll.setText("Select All");
        bAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAllActionPerformed(evt);
            }
        });

        bCats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCats.setText("Select Cats");
        bCats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCatsActionPerformed(evt);
            }
        });

        bDogs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bDogs.setText("Select Dogs");
        bDogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDogsActionPerformed(evt);
            }
        });

        lAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lAll.setText("List All Chipped Animals");

        lCats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lCats.setText("List All Chipped Cats");

        lDogs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lDogs.setText("List All Chipped Dogs");

        ListsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Name", "Kind", "Chip", "Phone", "Email"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    ListsTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ListsTableMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(ListsTable);

    InputID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

    bDelete.setBackground(new java.awt.Color(255, 0, 0));
    bDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    bDelete.setForeground(new java.awt.Color(255, 255, 255));
    bDelete.setText("DELETE");
    bDelete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bDeleteActionPerformed(evt);
        }
    });

    lDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    lDelete.setText("Delete Animal at ID");

    lid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    lid.setText("ID");

    bExcel.setBackground(new java.awt.Color(0, 0, 255));
    bExcel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    bExcel.setForeground(new java.awt.Color(255, 255, 255));
    bExcel.setText("Export data to Excel");
    bExcel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bExcelActionPerformed(evt);
        }
    });

    mbExit.setText("File");

    mExit.setText("Exit");
    mExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mExitActionPerformed(evt);
        }
    });
    mbExit.add(mExit);

    jMenuBar.add(mbExit);

    mbActions.setText("Actions");

    mAddNew.setText("Add New");
    mAddNew.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mAddNewActionPerformed(evt);
        }
    });
    mbActions.add(mAddNew);

    jMenuItem1.setText("Edit Animal");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    mbActions.add(jMenuItem1);

    jMenuBar.add(mbActions);

    setJMenuBar(jMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bDogs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAll, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lAll)
                        .addComponent(lCats)
                        .addComponent(lDogs)))
                .addComponent(lDelete)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lid)
                    .addGap(18, 18, 18)
                    .addComponent(InputID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(bExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(96, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(58, 58, 58)
            .addComponent(jScrollPane2)
            .addGap(64, 64, 64))
        .addGroup(layout.createSequentialGroup()
            .addGap(104, 104, 104)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bAll)
                .addComponent(lAll))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bCats)
                .addComponent(lCats))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bDogs)
                .addComponent(lDogs))
            .addGap(27, 27, 27)
            .addComponent(lDelete)
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(InputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bDelete)
                .addComponent(lid))
            .addGap(35, 35, 35)
            .addComponent(bExcel)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mExitActionPerformed

    private void bAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAllActionPerformed
        // TODO add your handling code here:
        try {
            ListsTable.setModel(new DefaultTableModel(null, modelString));
            ChippedAnimal[] list = db.getAnimals();
            show_animals(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong...", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bAllActionPerformed

    private void mAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddNewActionPerformed
        // TODO add your handling code here:
        aa.setVisible(true);
    }//GEN-LAST:event_mAddNewActionPerformed

    private void bCatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCatsActionPerformed
        // TODO add your handling code here:
        try {
            ListsTable.setModel(new DefaultTableModel(null, modelString));
            ChippedAnimal[] list = db.animalsbyKind("Cat");
            show_animals(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong...", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bCatsActionPerformed

    private void bDogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDogsActionPerformed
        // TODO add your handling code here:
        try {
            ListsTable.setModel(new DefaultTableModel(null, modelString));
            ChippedAnimal[] list = db.animalsbyKind("Dog");
            show_animals(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong...", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bDogsActionPerformed

    private void ListsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListsTableMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ea.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        db.delete(Integer.parseInt(InputID.getText()));
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcelActionPerformed
        // TODO add your handling code here:
        TableModel model = ListsTable.getModel();
        db.downloadExcel(model);
    }//GEN-LAST:event_bExcelActionPerformed

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
            java.util.logging.Logger.getLogger(ListAnimalsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListAnimalsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListAnimalsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListAnimalsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListAnimalsFrame().setVisible(true);
            }
        });
    }

    public void show_animals(ChippedAnimal[] List) {
        DefaultTableModel model = (DefaultTableModel) ListsTable.getModel();
        Object row[] = new Object[6];
        for (int i = 0; i < List.length; i++) {
            row[0] = List[i].getId();
            row[1] = List[i].getName();
            row[2] = List[i].getKind();
            row[3] = List[i].getChip();
            row[4] = List[i].getPhone();
            row[5] = List[i].getEmail();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputID;
    private javax.swing.JTable ListsTable;
    private javax.swing.JButton bAll;
    private javax.swing.JButton bCats;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bDogs;
    private javax.swing.JButton bExcel;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAll;
    private javax.swing.JLabel lCats;
    private javax.swing.JLabel lDelete;
    private javax.swing.JLabel lDogs;
    private javax.swing.JLabel lid;
    private javax.swing.JMenuItem mAddNew;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenu mbActions;
    private javax.swing.JMenu mbExit;
    // End of variables declaration//GEN-END:variables
    private AddAnimalFrame aa;
    private Database db;
    private String[] modelString;
    private EditAnimalFrame ea;
}
