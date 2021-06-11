/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chippedanimals.backend;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.swing.*;
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
public class Database {
    
    public Database() {
        
    }
//    private JTextArea t;
//    public Database(JTextArea t){
//        this.t=t;
//    }
    public void save(String name, String kind, Integer chip, Integer phone, String email) {
        
        ChippedAnimal animal = new ChippedAnimal(name, kind, chip, phone, email);
        //skojarzenie encji z utworzoną JPA (EntityManagerFactory)
        EntityManager em = getEntityManager();
                //uruchomić transakcj e (begin())
        em.getTransaction().begin();
        //zapisac obiekt w bazie (metoda persist())
        try {
            em.persist(animal);
            //zatwierdzic transakcje
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Animal was saved!","Animal Database Response", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            System.err.print("Error " + e.getMessage());
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error " +e.getMessage(), "Error connecting to database", JOptionPane.ERROR_MESSAGE);
        }
        finally 
        {
            em.close();
        }
  }
    public void edit(Integer Id, String name, String kind, Integer chip, Integer phone, String email) {
        EntityManager em = getEntityManager();
        ChippedAnimal animal = em.find(ChippedAnimal.class, Id);
        em.getTransaction().begin();
        if(name != null) {animal.setName(name);} else {animal.setName(animal.getName());}; 
        if(kind != null) {animal.setKind(kind);}
        if(chip != null) {animal.setChip(chip);}
        if(phone != null) {animal.setPhone(phone);}
        if(email != null) {animal.setEmail(email);}

        try {
            em.persist(animal);
            //zatwierdzic transakcje
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Animal was edited!","Animal Database Response", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            System.err.print("Error " + e.getMessage());
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error " +e.getMessage(), "Error connecting to database", JOptionPane.ERROR_MESSAGE);
        }
        finally 
        {
            em.close();
        }        
    }
    
    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        ChippedAnimal animal = em.find(ChippedAnimal.class, id);
        em.getTransaction().begin();
        em.remove(animal);
        try {
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Animal was deleted!","Animal Database Response", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            System.err.print("Error " + e.getMessage());
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error " +e.getMessage(), "Error connecting to database", JOptionPane.ERROR_MESSAGE);
        }
        finally 
        {
            em.close();
        }       
        
    }
    
  public EntityManagerFactory emf;
  public EntityManager getEntityManager() {
      if (emf == null) emf=Persistence.createEntityManagerFactory("ChippedAnimalsPU");
      return emf.createEntityManager();
  }
  
  public ChippedAnimal[] getAnimals() {
    EntityManager em = getEntityManager();
    try {
        //Query q = em.createQuery("select c from ChippedAnimal as c");
        TypedQuery<ChippedAnimal> q = em.createNamedQuery("ChippedAnimal.findAll", ChippedAnimal.class); 
        ChippedAnimal[] chippedAnimals =(ChippedAnimal[])q.getResultList().toArray(new ChippedAnimal[0]);
//        for(int i=0; i<chippedAnimals.length; i++) {
//            t.append("" + chippedAnimals[i].toString() +"\n");
//        }
        return chippedAnimals;
        }
        finally {
            em.close();
        }
    }
  
  public ChippedAnimal getAnimal(Integer Id) {
      EntityManager em = getEntityManager();
      ChippedAnimal animal = em.find(ChippedAnimal.class, Id);
      return animal;
  }
  
  
  public ChippedAnimal[] animalsbyKind(String kind) {
      EntityManager em = getEntityManager();  
      try {
        TypedQuery<ChippedAnimal> q = em.createNamedQuery("ChippedAnimal.findByKind", ChippedAnimal.class); 
        q.setParameter("kind", kind); 
        ChippedAnimal[] chippedAnimals =(ChippedAnimal[])q.getResultList().toArray(new ChippedAnimal[0]);
//        for(int i=0; i<chippedAnimals.length; i++) {
//            t.append("" + chippedAnimals[i].toString() +"\n");
//        }
        return chippedAnimals;
        }
        finally {
            em.close();
        }
    }
    
  public void downloadExcel(TableModel model) {
        JFileChooser excelFile = new JFileChooser();
        excelFile.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFile.setFileFilter(fnef);
        int excelChooser = excelFile.showSaveDialog((null));

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook excelJTableExporter = new XSSFWorkbook();
            XSSFSheet excelSheet = excelJTableExporter.createSheet("Chipped Animals");
            if (model != null) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is nothing in table!", "Non existing data", JOptionPane.ERROR_MESSAGE);
            }

            FileOutputStream excelFOU = null;
            BufferedOutputStream excelBOU = null;

            try {
                excelFOU = new FileOutputStream(excelFile.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong...", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong...", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                    JOptionPane.showMessageDialog(null,"File was saved!","Animal Database Response", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong...", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
  }
}
