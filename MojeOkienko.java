import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MojeOkienko extends JFrame implements ActionListener {

    JButton  b1_do_sth;
    JButton  b2_exit;
    JLabel out_sth;

    public MojeOkienko(){
        setSize(500,300);
        setTitle("My WINDOW MINE!!! NOT YOURS!!");
        setLayout(null);
        b1_do_sth = new JButton("do something...");
        b1_do_sth.setBounds(150, 100, 200,20);
        add(b1_do_sth);
        b1_do_sth.addActionListener(this);

        out_sth = new JLabel("I AM NOT DOING ANYTHING");
        out_sth.setBounds(150,130,200,20);
        out_sth.setForeground(new Color(255,0,0));
        out_sth.setFont(new Font("SansSerif",Font.BOLD, 14));
        add(out_sth);

        b2_exit = new JButton("Exit");
        b2_exit.setBounds(150, 160, 200,20);
        add(b2_exit);
        b2_exit.addActionListener(this);
    }

    public static void main(String[] args){
        MojeOkienko window1 = new MojeOkienko();
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source ==  b1_do_sth) {
            out_sth.setText("I AM DOING STH XDDD");
            out_sth.setForeground(new Color(0,0,255));
           // System.out.println("I AM DOING STH");
        }
        if (source ==  b2_exit) dispose();
    }
}
