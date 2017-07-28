/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CellRendered;

import Persons.Pilkarz;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Dominik Deja
 */
public class CellRenderFootbaler extends DefaultListCellRenderer implements ListCellRenderer<Object>{

    private String ZdjeciePilkarza = "C:\\Users\\Dominik Deja\\messiIcon.png";
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try {
            Pilkarz is=(Pilkarz) value;
            
            setText(is.getImie()+" "+is.getNazwisko());
            Image image = ImageIO.read(new File(ZdjeciePilkarza));
            Icon icon = new ImageIcon(image);
            setIcon(icon);
            
            
            //SET BACKGROUND AND FOREGROUND COLORS TO CUSTOM LIST ROW
            if(isSelected)
            {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }else
            {
                
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            
            setEnabled(true);
            setFont(list.getFont());
            
             //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(CellRenderFootbaler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
}
