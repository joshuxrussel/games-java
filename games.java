import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class games implements ActionListener{    
    JFrame f;   JComboBox cb; JButton b,b1; JLabel l;
    games(){    
        f=new JFrame("games");    
        
        String country[]={"flames","x-o","Number puzzle"};  
        b=new JButton("PLAY");
        l=new JLabel("CHOOSE ANY ONE GAME");
        f.add(l);
        l.setBounds(100,50,200,25);
        l.setOpaque(true);
        l.setBackground(Color.GRAY);
        b1=new JButton("EXIT");
        f.getContentPane().setBackground(Color.BLACK);
        b.setBounds(150, 200, 100, 40); 
        b1.setBounds(150,250,100,40);     
         cb=new JComboBox<>(country);    
        cb.setBounds(125, 100,150,20);    
        f.add(cb);        
        f.setLayout(null);    
        f.setSize(400,500);    
        f.setVisible(true);
         f.add(b);f.add(b1);
         f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
b.addActionListener(this);b1.addActionListener(this);
    }    
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==b){
        if(cb.getItemAt(cb.getSelectedIndex())=="flames"){
                new Flames1();
      
    }
        if(cb.getItemAt(cb.getSelectedIndex())=="x-o"){
            new TTT1();
        }
        if(cb.getItemAt(cb.getSelectedIndex())=="Number puzzle"){
          new puzzle();
        }
    }
    if(e.getSource()==b1){
      f.dispose();
    }
    }
    public static void main(String[] args) {    
        new games();         
    }    
    } 
    class Flames1 extends JFrame implements ActionListener{
        JLabel lbl1 = new JLabel("Name 1");
        JLabel lbl2 = new JLabel("Name 2");
        JTextField fld1 = new JTextField();
        JTextField fld2 = new JTextField();;
        JButton btn = new JButton("Submit");
        JLabel rlt = new JLabel("");
        Flames1(){
         super("Flames1");
         setLayout(null);
         setVisible(true);
        
         getContentPane().setBackground(Color.LIGHT_GRAY);
         setBounds(100, 100, 300, 300);
         lbl1.setBounds(50, 40, 100, 40);
         lbl2.setBounds(50, 100, 100, 40);
         fld1.setBounds(120, 40, 150, 30);
         fld2.setBounds(120, 100, 150, 30);
         btn.setBounds(110,150,100,30);
         rlt.setBounds(80,200,200,30);
         rlt.setFont(new Font("Courier New", Font.BOLD, 18));
         rlt.setForeground(Color.RED);
         add(btn);
         add(lbl1);
         add(lbl2);
         add(fld1);
         add(fld2);
         add(rlt);
         btn.addActionListener(this);
        }
         
         public void actionPerformed(ActionEvent e) {
        rlt.setText("");
        String name1 = fld1.getText().toUpperCase();
        String name2 = fld2.getText().toUpperCase();
        if(name1 ==null || name1.equals("")) {
         JOptionPane.showMessageDialog(null, "Name 1 must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(name2 ==null || name2.equals("")) {
         JOptionPane.showMessageDialog(null, "Name 2 must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(name1.equals(name2)) {
         JOptionPane.showMessageDialog(null, "Name 1 and Name 2 must not be same.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
         rlt.setText(getFlames1(name1, name2));
        }
         }
         public String getFlames1(String name1, String name2)  {
           String result = "";
           char[] f = { 'F', 'L', 'A', 'M', 'E', 'S' };
           char[] n1 = name1.toCharArray();
           char[] n2 = name2.toCharArray();
           int len = 0;
           for (int i = 0; i < n1.length; i++) {
             for (int j = 0; j < n2.length; j++) {
               if (n1[i] == n2[j])  {
                 n1[i] = '0';
                 n2[j] = '0';
                 break;
               }
             }
           }
           for (int i = 0; i < n1.length; i++) {
             if (n1[i] != '0') {
               len++;
             }
           }
           for (int i = 0; i < n2.length; i++) {
             if (n2[i] != '0') {
               len++;
             }
           }
           int k = 1;int l = 0;int c = 1;
           for (;;)  {
             if (k == len)  {
               if (f[l] != '0')  {
                 f[l] = '0';
                 k = 1;
                 l++;
                 c++;
                 if (l >= 6) {
                   l = 0;
                 }
                 if (c == 6) {
                   break;
                 }
               } else {
                 l++;
                 if (l >= 6) {
                   l = 0;
                 }
               }
             } else  {
               if (f[l] != '0') {
                 k++;
               }
               l++;
               if (l >= 6) {
                 l = 0;
               }
             }
           }
           for (int i = 0; i < f.length; i++) {
             if (f[i] != '0') {
               if (f[i] == 'F') {
                 result = "FRIEND";
               } else if (f[i] == 'L') {
                 result = "LOVE";
               } else if (f[i] == 'A') {
                 result = "AFFECTION";
               } else if (f[i] == 'M') {
                 result = "MARRIAGE";
               } else if (f[i] == 'E') {
                 result = "ENEMY";
               } else if (f[i] == 'S') {
                 result = "SISTER";
               }
             }
           }
           return result;
         }
       }
class TTT1 implements ActionListener 
{  
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] bton = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean pl1_chance;
    
    
    TTT1() 
    {
        
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(250, 184, 97));
        frame.setTitle("X-O");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0,0,0));
        textfield.setForeground(new Color(255,0,0));
        textfield.setFont(new Font("Serif", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("X-O");
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(0, 0, 0));

        for (int i = 0; i < 9; i++) 
        {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
            bton[i].setFont(new Font("Serif", Font.BOLD, 120));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
            bton[i].setBackground(Color.cyan);
        }
        
        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);

        startGame();
    }
    
    
    public void startGame() 
    {
        try 
        {
            textfield.setText("Loading....");
            Thread.sleep(4000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        int chance=random.nextInt(100);

        if (chance%2 == 0) 
        {
            pl1_chance = true;
            textfield.setText("Player X turn");
        } 
        else 
        {
            pl1_chance = false;
            textfield.setText("Player O turn");
        }
    }
    
    public void gameOver(String s)
    {
        chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if(n==0)
        {
            frame.dispose();
            new TTT1();
        }
        else
        {
            frame.dispose();
        }
    
    }

  
    public void matchCheck() 
    {
        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) 
        {
            xWins(0, 1, 2);
        }
        else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) 
        {
            xWins(0, 4, 8);
        }
        else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) 
        {
            xWins(0, 3, 6);
        }
        else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) 
        {
            xWins(1, 4, 7);
        }
        else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) 
        {
            xWins(2, 4, 6);
        }
        else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) 
        {
            xWins(2, 5, 8);
        }
       else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) 
       {
            xWins(3, 4, 5);
        }
       else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) 
       {
            xWins(6, 7, 8);
        }
      
        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) 
        {
            oWins(0, 1, 2);
        }
        else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) 
        {
            oWins(0, 3, 6);
        }
        else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) 
        {
            oWins(0, 4, 8);
        }
        else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) 
        {
            oWins(1, 4, 7);
        }
        else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) 
        {
            oWins(2, 4, 6);
        }
        else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) 
        {
            oWins(2, 5, 8);
        }
        else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) 
        {
            oWins(3, 4, 5);
        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) 
        {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9) 
        {
            textfield.setText("Game Draw!!");
             gameOver("Game Draw!!");
        }
    }

    
    public void xWins(int x1, int x2, int x3) 
    {
    	bton[x1].setBackground(Color.YELLOW);
        bton[x2].setBackground(Color.YELLOW);
        bton[x3].setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++) 
        {
            bton[i].setEnabled(false);
        }
        textfield.setText("Player X wins");
        gameOver("Player X Wins");
    }

   
    public void oWins(int x1, int x2, int x3) 
    {
        bton[x1].setBackground(Color.YELLOW);
        bton[x2].setBackground(Color.YELLOW);
        bton[x3].setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++) 
        {
            bton[i].setEnabled(false);
        }
        textfield.setText("Player O Wins");
        gameOver("Player O Wins");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == bton[i]) 
            {
                if (pl1_chance) 
                {
                    if (bton[i].getText() == "") 
                    {
                        bton[i].setForeground(new Color(0, 188, 255));
                        bton[i].setText("X");
                        pl1_chance = false;
                        textfield.setText("O turn");
                        chance_flag++;
                        matchCheck();
                    }
                } 
                else 
                {
                    if (bton[i].getText() == "") 
                    {
                        bton[i].setForeground(new Color(0, 255, 9));
                        bton[i].setText("O");
                        pl1_chance = true;
                        textfield.setText("X turn");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
}
      
 class puzzle extends JFrame implements ActionListener{  
  JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,retry;  
  puzzle(){  
  super("Puzzle Game - JavaTpoint");  
   b1=new JButton("6");  
   b2=new JButton("4");  
   b3=new JButton("7");  
   b4=new JButton("8");  
   b5=new JButton("5");  
   b6=new JButton(" ");  
   b7=new JButton("3");  
   b8=new JButton("2");  
   b9=new JButton("1");  
   retry=new JButton("retry");  
    
  b1.setBounds(10,30,50,40);  
  b2.setBounds(70,30,50,40);  
  b3.setBounds(130,30,50,40);  
  b4.setBounds(10,80,50,40);  
  b5.setBounds(70,80,50,40);  
  b6.setBounds(130,80,50,40);  
  b7.setBounds(10,130,50,40);  
  b8.setBounds(70,130,50,40);  
  b9.setBounds(130,130,50,40);  
  retry.setBounds(70,200,100,40);  
      
  add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9); add(retry);  
  b1.addActionListener(this);  
  b2.addActionListener(this);  
  b3.addActionListener(this);  
  b4.addActionListener(this);  
  b5.addActionListener(this);  
  b6.addActionListener(this);  
  b7.addActionListener(this);  
  b8.addActionListener(this);  
  b9.addActionListener(this);  
  retry.addActionListener(this);  
    
  retry.setBackground(Color.black);  
  retry.setForeground(Color.green);  
  setSize(250,300);  
  setLayout(null);  
  setVisible(true);  
  
  }
    
  public void actionPerformed(ActionEvent e){  
  if(e.getSource()==retry){  
   this.dispose();
  new puzzle();
  repaint();  
  }  
  if(e.getSource()==b1){  
  String s=b1.getText();  
  if(b2.getText().equals(" ")){ b2.setText(s); b1.setText(" ");}  
  else if(b4.getText().equals(" ")){ b4.setText(s); b1.setText(" ");}  
   }
    
  if(e.getSource()==b3){  
  String s=b3.getText();  
  if(b2.getText().equals(" ")){ b2.setText(s); b3.setText(" ");}  
  else if(b6.getText().equals(" ")){ b6.setText(s); b3.setText(" ");}  
   }  
    
  if(e.getSource()==b2){  
  String s=b2.getText();  
  if(b1.getText().equals(" ")){ b1.setText(s); b2.setText(" ");}  
  else if(b3.getText().equals(" ")){ b3.setText(s); b2.setText(" ");}  
  else if(b5.getText().equals(" ")){ b5.setText(s); b2.setText(" ");}  
   } 
    
  if(e.getSource()==b4){  
  String s=b4.getText();  
  if(b1.getText().equals(" ")){ b1.setText(s); b4.setText(" ");}  
  else if(b7.getText().equals(" ")){ b7.setText(s); b4.setText(" ");}  
  else if(b5.getText().equals(" ")){ b5.setText(s); b4.setText(" ");}  
   } 
    
  if(e.getSource()==b5){  
  String s=b5.getText();  
  if(b2.getText().equals(" ")){ b2.setText(s); b5.setText(" ");}  
  else if(b4.getText().equals(" ")){ b4.setText(s); b5.setText(" ");}  
  else if(b6.getText().equals(" ")){ b6.setText(s); b5.setText(" ");}  
  else if(b8.getText().equals(" ")){ b8.setText(s); b5.setText(" ");}  
   } 
    
  if(e.getSource()==b6){  
    
  String s=b6.getText();  
  if(b9.getText().equals(" ")){ b9.setText(s); b6.setText(" ");}  
  else if(b3.getText().equals(" ")){ b3.setText(s); b6.setText(" ");}  
  else if(b5.getText().equals(" ")){ b5.setText(s); b6.setText(" ");}  
    
   }
    
  if(e.getSource()==b7){  
  String s=b7.getText();  
  if(b4.getText().equals(" ")){ b4.setText(s); b7.setText(" ");}  
  else if(b8.getText().equals(" ")){ b8.setText(s); b7.setText(" ");}  
    
   } 
    
  if(e.getSource()==b8){  
  String s=b8.getText();  
  if(b7.getText().equals(" ")){ b7.setText(s); b8.setText(" ");}  
  else if(b9.getText().equals(" ")){ b9.setText(s); b8.setText(" ");}  
  else if(b5.getText().equals(" ")){ b5.setText(s); b8.setText(" ");}  
    
   }
    
  if(e.getSource()==b9){  
  String s=b9.getText();  
  if(b6.getText().equals(" ")){ b6.setText(s); b9.setText(" ");}  
  else if(b8.getText().equals(" ")){ b8.setText(s); b9.setText(" ");}  
    
  if(b1.getText().equals("1")&&b2.getText().equals("2")&&b3.getText()  
  .equals("3")&&b4.getText().equals("4")&&b5.getText().equals("5")  
  &&b6.getText().equals("6")&&b7.getText().equals("7")&&b8.getText()  
  .equals("8")&&b9.getText().equals(" ")){   
  JOptionPane.showMessageDialog(puzzle.this,"!!!you won!!!");  
  }  
   }
    
  } 
     
    
  }