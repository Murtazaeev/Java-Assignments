import javax.swing.*;

public class CelsiusToFarenheit extends JFrame {

    public CelsiusToFarenheit(){

        JLabel l_celcius, l_fahren;
        JTextField t_celcius, t_fahren;

        setSize(300,200);
        setTitle("Calculator of temperature");
        setLayout(null);

        l_celcius = new JLabel("Celcius degree: ");
        l_celcius.setBounds(100,0,100,20);
        add(l_celcius);

    }

    public static void main (String [] args){


        CelsiusToFarenheit apk = new CelsiusToFarenheit();
        apk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apk.setVisible(true);
    }
}
