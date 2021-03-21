import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RównanieGUI extends JFrame implements ActionListener {

    private JTextField ta, tb, tc, tSolution;
    private JLabel la, lb, lc;
    private JButton bsolve;

    public RównanieGUI(){
        setSize(400,400);
        setTitle("Quadratic equation");
        setLayout(null);

        la = new JLabel("Type a:");
        la.setBounds(20, 20, 70, 20);
        add(la);
        ta = new JTextField();
        ta.setBounds(80,20,60,20);
        ta.setToolTipText("Type aaajjjjjjjjjj");
        add(ta);

        lb= new JLabel("Type b:");
        lb.setBounds(20, 50, 70, 20);
        add(lb);
        tb = new JTextField();
        tb.setBounds(80,50,60,20);
        tb.setToolTipText("Type biiiiiiiiiii");
        add(tb);

        lc = new JLabel("Type c:");
        lc.setBounds(20, 80, 70, 20);
        add(lc);
        tc = new JTextField();
        tc.setBounds(80,80,60,20);
        tc.setToolTipText("Type ciiiiiiiiii");
        add(tc);

        bsolve = new JButton("Solve");
        bsolve.setBounds(150, 110, 100, 40);
        add(bsolve);
        bsolve.addActionListener(this);

        tSolution = new JTextField();
        tSolution.setBounds(20, 160, 346, 20);
        add(tSolution);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bsolve)
        {
            double a = Double.parseDouble(ta.getText());
            double b = Double.parseDouble(tb.getText());
            double c = Double.parseDouble(tc.getText());

            RównanieKwadratowe equation = new RównanieKwadratowe(a,b,c);
            String solution = equation.result();
            tSolution.setText(solution);
        }
    }


    public static void main (String[] args)
    {
        RównanieGUI apk = new RównanieGUI();
        apk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apk.setVisible(true);
    }

}
