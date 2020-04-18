/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.beans.binding.Bindings.length;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author DELL
 */
    public class Main extends JMenuBar implements ActionListener {
     String[]fileItems=new String[]{"new","open","save","exit"};
     String[]editItems=new String[]{"undo","cut","copy","Paste"};
     
     char[]fileShortcuts={'N','O','S','E'};
     char[]editShortcuts={'Z','X','C','V'};

     Main(){
     JMenu fileMenu=new JMenu("File");
     JMenu editMenu=new JMenu("Edit");
     JMenu otherMenu=new JMenu("Other");
     JMenu subMenu=new JMenu("subMenu");
     JMenu subMenu2=new JMenu("subMenu2");
     
     //file menu
     for(int i=0;i<fileItems.length;i++){
         JMenuItem item=new JMenuItem(fileItems[i], fileShortcuts[i]);
         item.addActionListener(this);
         fileMenu.add(item);
     }
   
      for(int i=0;i <editItems.length; i++){
     JMenuItem item=new JMenuItem(editItems[i]);
     item.setAccelerator(KeyStroke.getKeyStroke(editShortcuts[i]
      ,java.awt.Event.CTRL_MASK,false));
     item.addActionListener(this);
     editMenu.add(item);
     }
      editMenu.insertSeparator(1);
      
      JMenuItem item;
      subMenu2.add(item=new JMenuItem("Extra 2"));
      item.addActionListener(this);
      subMenu.add(item=new JMenuItem("Extra 1"));
      item.addActionListener(this);
      subMenu.add(subMenu2);
   
      otherMenu.add(subMenu);
      otherMenu.add(item=new JCheckBoxMenuItem("check Me"));
      item.addActionListener(this);
      otherMenu.addSeparator();
      ButtonGroup buttonGroup=new ButtonGroup();
      otherMenu.add(item=new JRadioButtonMenuItem("Radio 1"));
      item.addActionListener(this);
      buttonGroup.add(item);
      otherMenu.add(item=new JRadioButtonMenuItem("Radio 2"));
      item.addActionListener(this);
      buttonGroup.add(item);
      
      
      otherMenu.addSeparator();
      otherMenu.add(item=new JMenuItem("java",new ImageIcon("biggrin.png")));
      item.addActionListener(this);
      add(fileMenu);
      add(editMenu);
      add(otherMenu);
      
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Menu["+e.getActionCommand()+"]was checked");
        
    }
     public static void main(String[]args){
      JFrame frame =new JFrame("my Menu");
      frame.setJMenuBar(new Main());
      frame.setSize(500, 500);
      frame.setVisible(true);
     }
}
