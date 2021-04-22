package timer_cal;

import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;


public class form extends JDialog {
    private JPanel contentPane;
    private JRadioButton RadioButton1;
    private JRadioButton RadioButton3;
    private JRadioButton RadioButton2;
    private JButton ButtonStart;
    private JComboBox comboBox1;
    private JButton ButtonCreateProf;
    private JButton ButtonEnd;
    private JButton ButtonDelete;
    private JLabel labelTime;
    private JTextField textField1;
    private JTextPane потраченоКалорийTextPane;
    private JLabel LabelCal;
    private JPanel PanelCal;
    private JButton ButtonPaus;
    private JLabel label_test;

    private Timer myTimer;
    private TimerTask mMyTimerTask;


    public form() {
        setContentPane(contentPane);
        setModal(true);


        ButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                labelTime.setText(textField1.getText());
                Thread thread = new Thread(run_timer);
                thread.start();

            }
        });
        ButtonCreateProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textField1.getText()!= " ") {
                    comboBox1.addItem(textField1.getText());
                }
            }
        });
        ButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //comboBox1.removeItem();
            }
        });




        ButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                labelTime.setText(minut + " : " + sec);
                time_stop=true;
                if(RadioButton1.isSelected()==true){
                    view_tren = RadioButton1.getText();
                }
                if(RadioButton2.isSelected()==true){
                    view_tren = RadioButton2.getText();
                }
                if(RadioButton3.isSelected()==true) {
                    view_tren = RadioButton3.getText();
                }
                RadioButton1.setEnabled(false);
                RadioButton2.setEnabled(false);
                RadioButton3.setEnabled(false);
                ButtonStart.setEnabled(false);

            }
        });



        ButtonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                time_stop=false;
                labelTime.setText(minut + " : " + sec);
                //LabelCal.setText(""+sec_all+"");
                cal = calories.view_trening(view_tren);
                spen_cal = calories.spent_calories(cal, sec_all);
                LabelCal.setText(" "+spen_cal+" ");

                sec = 0;
                minut = 0;
                sec_all = 0;
                spen_cal = 0;
                cal = 0;
                ButtonStart.setEnabled(true);
                RadioButton1.setEnabled(true);
                RadioButton2.setEnabled(true);
                RadioButton3.setEnabled(true);

            }
        });
        ButtonPaus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                time_stop=false;
                labelTime.setText(minut + " : " + sec);
                ButtonStart.setEnabled(true);
            }
        });
    }

    int sec = 0;
    int minut = 0;
    int sec_all = 0;
    int cal = 0;
    int spen_cal = 0;
    String view_tren = "";
    boolean time_stop = false;

    Runnable run_timer = new Runnable() {
        @Override
        public void run() {
            while (true){
                try{
                    Thread.sleep(1000);
                    if (time_stop == true) {
                        sec = sec + 1;
                        sec_all = sec_all + 1;
                        if (sec == 60) {
                            minut++;
                            sec = 0;
                        }
                        labelTime.setText(minut + " : " + sec);
                        /*
                        if(RadioButton1.isSelected()==true){
                            label_test.setText(" Присидания1");
                        }
                        if(RadioButton2.isSelected()==true){
                            label_test.setText(" Присидания2");
                        }
                        if(RadioButton3.isSelected()==true){
                            label_test.setText(" Присидания3");
                        }*/
                    }
                }
                catch (InterruptedException er){
                    er.printStackTrace();
                }
            }
        }
        };

    public static void main(String[] args) {
        form dialog = new form();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
