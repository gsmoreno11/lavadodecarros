package Controlador;
import Vista.*;
import Modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    DefaultTableModel modeloTabla;
    private InterfaceUno vista;
    private InterfaceDos vistaDos;
    private Modelo modelo;
    private String tipoS;
    private String tipoVh;
    private String[][]infoTabla;
    

    public Controlador(InterfaceUno vista,InterfaceDos vistaDos, Modelo modelo) {
        this.vista = vista;
        this.vistaDos = vistaDos;
        this.modelo = modelo;
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.vista.jButton3.addActionListener(this);
        
        this.vistaDos.jButton1.addActionListener(this) ;
        this.vistaDos.jButton2.addActionListener(this);
        this.vistaDos.jButton3.addActionListener(this);
        this.vistaDos.jButton4.addActionListener(this);
        //this.vistaDos.jButton5.addActionListener(this);
        
        modeloTabla=new DefaultTableModel();
        modeloTabla.addColumn("Funcionario");
        modeloTabla.addColumn("Vehiculo");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Servicio");
        modeloTabla.addColumn("Precio");
        vista.jTable1.setModel(modeloTabla);
    }
    
     public void Iniciar(){
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
     }
     
    public void actionPerformed(ActionEvent e) {
           
        if(vista.jButton1==e.getSource()){
            
            if(vista.jDateChooser1.getDateFormatString().length()==0){
               JOptionPane.showMessageDialog(null, "Ingrese todos los valores"); 
            }else{
                vista.jButton2.setVisible(true);
                String tip=(String) vista.jComboBox2.getSelectedItem();
            if(tip.equals("Combos")){
                tipoS=(String) vista.jComboBox3.getSelectedItem();    
            }else{
                tipoS=(String) vista.jComboBox2.getSelectedItem();  
            }
                modelo.setTipo(tipoS);
                tipoVh=(String) vista.jComboBox1.getSelectedItem();
                modelo.setTipoVehiculo(tipoVh);
                modelo.getTipoVehiculo();
                modelo.CostolavadoAuto();
                vista.jLabel9.setText(modelo.mostrarvalor());
            }
            
        }else if(vista.jButton2==e.getSource()){
            
                vista.jButton3.setVisible(true);
                
                if(vista.jDateChooser1.getDateFormatString().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingrese todos los valores");
                }else{
                    String[]info =new String[5];

                    info[0]=(String) vista.jComboBox4.getSelectedItem();
                    info[1]=(String) vista.jComboBox1.getSelectedItem();
                    info[2]=Integer.toString(vista.jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
                    info[2]+="/"+Integer.toString(vista.jDateChooser1.getCalendar().get(Calendar.MONTH)+1);
                    info[2]+="/"+Integer.toString(vista.jDateChooser1.getCalendar().get(Calendar.YEAR));
                    
                    if(vista.jComboBox2.getSelectedItem().equals("Combos")){
                        info[3]=(String) vista.jComboBox3.getSelectedItem();
                    }else{
                        info[3]=(String) vista.jComboBox2.getSelectedItem();
                    }
                    info[4]=vista.jLabel9.getText();
                    modeloTabla.addRow(info);
                    vista.jLabel9.setText("");
                }
                
        }else if(vista.jButton3==e.getSource()){
            int totRegistros=vista.jTable1.getRowCount();
            infoTabla=new String[totRegistros][5];
            for(int i=0;i<totRegistros;i++){
                infoTabla[i][0]=(String) vista.jTable1.getValueAt(i,0);
                infoTabla[i][1]=(String) vista.jTable1.getValueAt(i,1);
                infoTabla[i][2]=(String) vista.jTable1.getValueAt(i,2);  
                infoTabla[i][3]=(String) vista.jTable1.getValueAt(i,3); 
                infoTabla[i][4]=(String) vista.jTable1.getValueAt(i,4); 
            }
          
          vista.dispose();
          vistaDos.setVisible(true);  
          
        }
        modelo.setRegistros(infoTabla);
        if(vistaDos.jButton1==e.getSource()){
              vistaDos.jTextArea1.setText(modelo.mostrarfuncionario((String) vistaDos.jComboBox1.getSelectedItem()));
        }else if(vistaDos.jButton2==e.getSource()){
              vistaDos.jTextArea2.setText(modelo.mostrarservicio((String) vistaDos.jComboBox2.getSelectedItem()));
        }else if(vistaDos.jButton3==e.getSource()){
              String fech="";
              fech=Integer.toString(vistaDos.jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
              fech+="/"+Integer.toString(vistaDos.jDateChooser1.getCalendar().get(Calendar.MONTH)+1);
              fech+="/"+Integer.toString(vistaDos.jDateChooser1.getCalendar().get(Calendar.YEAR));
              vistaDos.jTextArea3.setText(modelo.mostrarfecha(fech));
          }else if(vistaDos.jButton4==e.getSource()){
              vista.setVisible(true);
        }else if(vistaDos.jButton5==e.getSource()){
              vistaDos.dispose();
        }
    }
}