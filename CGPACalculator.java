package cgpa.calculator;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


class CGPACalculator extends JFrame
{
    
    private Container c;
    private JLabel subjectl, gradel, creditl, cglabel;
    private JTextField tf1,tf2,tf3, tf4;
    private JButton bt1, bt2, bt3;
    private JTextArea display;
    private JScrollPane scbar;
    
    
    CGPACalculator()
    {
        UI();
        
    }
    public void UI()
    {
        
        c = this.getContentPane();
        c.setLayout(null);
        //labels
        subjectl = new JLabel();
        subjectl.setText("Subject: ");
        subjectl.setBounds(60, 30, 120, 40);
        c.add(subjectl);
        
        gradel = new JLabel();
        gradel.setText("Grade(0-4): ");
        gradel.setBounds(60,60,120,40);
        c.add(gradel);
        
        creditl = new JLabel();
        creditl.setText("Credits: ");
        creditl.setBounds(60,90,120,40);
        c.add(creditl);
        
        cglabel = new JLabel();
        cglabel.setText("CGPA :");
        cglabel.setBounds(190,300, 50,30);
        c.add(cglabel);
        
        
        //text field
        tf1 = new JTextField();
        tf1.setBounds(180, 40, 100, 20);
        c.add(tf1);
        
        tf2 = new JTextField();
        tf2.setBounds(180, 70, 100, 20);
        c.add(tf2);
        
        tf3 = new JTextField();
        tf3.setBounds(180, 100, 100, 20);
        c.add(tf3);
        
        tf4 = new JTextField();
        tf4.setBounds(240, 300, 70, 30);
        tf4.setEditable(false);
        c.add(tf4);
        
        
        
        //Text area
        display = new JTextArea();
        display.setLineWrap(true); //by default stays off; now it wraps the line to net row
        display.setWrapStyleWord(true);// now wraps word by word not char by char
        display.setEditable(false);// textarea cant be edited from UI
       
        
        scbar = new JScrollPane(display);// text area is now in scrollpane and now we set the size in scrollpane so that is also set to the bounds as TexArea
        scbar.setBounds(110,140,400,150);
        c.add(scbar);// gets everything in text area to display
        
        
        
        //BUttons 
        bt1 = new JButton();
        bt1.setBounds(100, 340, 120,20);
        bt1.setText("Add Subject");
        c.add(bt1);
        
        bt2 = new JButton();
        bt2.setBounds(225, 340, 120,20);
        bt2.setText("Remove");
        c.add(bt2);
        
     
        bt3 = new JButton();
        bt3.setText("Calcualte CGPA");
        bt3.setBounds(350, 340, 150, 20);
        c.add(bt3);
        
        
        
        
        
        //Events
        //Add
        bt1.addActionListener(new ActionListener()
        {
            @Override
            
            public void actionPerformed(ActionEvent e)
            {
               String name = tf1.getText().trim();
               String grade = tf2.getText().trim();
               String credit = tf3.getText().trim();
               
               if(!name.isEmpty() && !grade.isEmpty() && !credit.isEmpty())
               {
                   try
                   {
                       double Grade = Double.parseDouble(grade);
                       int Credit = Integer.parseInt(credit);
                       
                       if(Grade<0 || Grade>4)
                       {
                           JOptionPane.showMessageDialog(null, "Grade must be from 0 to 4");
                           return;
                       }
                       if(Credit <= 0)
                       {
                           JOptionPane.showMessageDialog(null, "Credit can't be zero or negative");
                           return;
                       }
                       
                       display.append("SUBJECT : "+name+" | GRADE: "+Grade+" | CREDITS: "+Credit+ "\n");//No set text cz it would put the next value there too so using append to connect them or link them
               
                       tf1.setText("");
                       tf2.setText("");// clears texfield on every entry
                       tf3.setText("");
                       
                   }
                   catch(NumberFormatException ex)
                   {
                     JOptionPane.showMessageDialog(null, "Credit and Grade must be numbers");
                   }
               }
               
            }
            
        });
        
        //Remove
        bt2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                display.setText("");
                    
            }
        });
        
        
        //calculation
        bt3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                   String allsubs = display.getText().trim();
                   
                   //if display is empty
                   if(allsubs.isEmpty())
                   {
                       JOptionPane.showMessageDialog(null, "Add some info first!");
                       return;
                   }
                   
                   String[] slines = allsubs.split("\n"); // splitting into lines
                   
                   double sumGradeCredits = 0;
                   int totalCredits = 0;
                   
                   for(String lines : slines)
                   {
                       if(!lines.isEmpty())
                       {
                           try
                           {
                               int StartGrade = lines.indexOf("GRADE: ")+7; //start point from the index of char G + 7 
                               int EndGrade = lines.indexOf(" |", StartGrade);// from G+7 till the separator as in the string
                               String gradeStart = lines.substring(StartGrade, EndGrade); // slices the text from start point till the separator
                               double grade = Double.parseDouble(gradeStart); //converting string to numeric values
                               
                               int creditStart = lines.indexOf("CREDITS: ")+9; // same as grades but + 9 because CREDITS: is of char 9
                               String creditStri = lines.substring(creditStart); // no end point explicitly needed to stops as the string ends
                               int credits = Integer.parseInt(creditStri); // parsing to numeric
                               
                               sumGradeCredits += grade * credits;
                               totalCredits += credits;
                                         
                           }
                           catch(Exception ex)
                           {
                               JOptionPane.showMessageDialog(null, "Calculation Error");
                               return;
                           }
                           
                       }
                   }
                   if(totalCredits > 0)
                   {
                       double cgpa = sumGradeCredits / totalCredits;
                       tf4.setText(String.format("%.4f", cgpa));
                   }
            }
        });        
}
    public static void main(String[] args)
    {
        CGPACalculator frame = new CGPACalculator ();
        frame.setVisible(true);
        frame.setBounds(100,80,600,400);
        frame.setTitle("CGPA CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
}
