import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This program converting temperature in all other temperature. So if you will type in Kelvin value, then
// temperature in celcius and fahrenfait will appear;
public class CelciusBoxWithouListener extends JFrame implements ActionListener {

    private JButton b_convert;
    private JLabel l_celcius, l_fahren, l_Kelvin;
    private JTextField t_celcius, t_fahren, t_Kelvin;
    private double temp_C, temp_F, temp_K;
    private JCheckBox cold_hot;

    public CelciusBoxWithouListener(){

        setSize(400,200);
        setTitle("Calculator of temperature");
        setLayout(null);

        l_celcius = new JLabel("Celcius degree: ");
        l_celcius.setBounds(20,20,120,20);
        add(l_celcius);

        t_celcius = new JTextField("");
        t_celcius.setBounds(150, 20, 120,20);
        add(t_celcius);
        t_celcius.addActionListener(this);

        l_fahren = new JLabel("Farenheit degree: ");
        l_fahren.setBounds(20,50,120,20);
        add(l_fahren);

        t_fahren = new JTextField("");
        t_fahren.setBounds(150, 50, 120,20);
        add(t_fahren);
        t_fahren.addActionListener(this);

        l_Kelvin = new JLabel("Kelvin degree: ");
        l_Kelvin.setBounds(20,80,120,20);
        add(l_Kelvin);

        t_Kelvin = new JTextField("");
        t_Kelvin.setBounds(150, 80, 120,20);
        add(t_Kelvin);
        t_Kelvin.addActionListener(this);

        cold_hot = new JCheckBox("Hot/Cold");
        cold_hot.setBounds(130, 119, 150, 20);
        add(cold_hot);
       // cold_hot.addActionListener(this);

        b_convert = new JButton("Convert");
        b_convert.setBounds(20, 120, 100, 20);
        add(b_convert);
        b_convert.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == b_convert || source==t_celcius || source == t_fahren || source == t_Kelvin) {

            if (t_celcius.getText().equals("") == false) {
                temp_C = Double.parseDouble(t_celcius.getText());
                temp_F = 32.0 + (9.0 / 5.0) * temp_C;
                t_fahren.setText(String.valueOf(temp_F));
                temp_K = temp_C + 273.15;
                t_Kelvin.setText(String.valueOf(temp_K));

                t_fahren.setFont(new Font("SansSerif", Font.BOLD, 13));
                t_Kelvin.setFont(new Font("SansSerif", Font.BOLD, 13));
            }

            else if (t_fahren.getText().equals("") == false) {
                temp_F = Double.parseDouble(t_fahren.getText());
                temp_C = (temp_F - 32) * (5.0/9.0);
                t_celcius.setText(String.valueOf(temp_C));
                temp_K = temp_C + 273.15;
                t_Kelvin.setText(String.valueOf(temp_K));

                t_celcius.setFont(new Font("SansSerif", Font.BOLD, 13));
                t_Kelvin.setFont(new Font("SansSerif", Font.BOLD, 13));
            }

            else if(t_Kelvin.getText().equals("") == false) {
                temp_K = Double.parseDouble(t_Kelvin.getText());
                temp_C = temp_K - 273.15;
                t_celcius.setText(String.valueOf(temp_C));
                temp_F = 32.0 + (9.0 / 5.0) * temp_C;
                t_fahren.setText(String.valueOf(temp_F));

                t_fahren.setFont(new Font("SansSerif", Font.BOLD, 13));
                t_celcius.setFont(new Font("SansSerif", Font.BOLD, 13));
            }

            if(cold_hot.isSelected()==true) {
                if(temp_C > 0) {
                    t_celcius.setForeground(new Color(255, 0, 0));
                    t_fahren.setForeground(new Color(255, 0, 0));
                    t_Kelvin.setForeground(new Color(255, 0, 0));
                }
                if(temp_C < 0){
                    t_celcius.setForeground(new Color(0, 0, 255));
                    t_fahren.setForeground(new Color(0, 0, 255));
                    t_Kelvin.setForeground(new Color(0, 0, 255));
                }
            }
            else{
                t_celcius.setForeground(new Color(0, 0, 0));
                t_fahren.setForeground(new Color(0, 0, 0));
                t_Kelvin.setForeground(new Color(0, 0, 0));
            }
        }
    }

    public static void main (String [] args){


        CelsiusToFarenheit apk = new CelsiusToFarenheit();
        apk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apk.setVisible(true);
        System.out.println("bAAFGADFASDASFASDFASD");
    }
}
