package timer_cal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
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
    private JTextPane CalTextPane;
    private JLabel LabelCal;
    private JPanel PanelCal;
    private JButton ButtonPaus;
    private JLabel label_test;
    private JTextPane UserTextPane;
    private JButton button_users;
    private JLabel users_label;

    private Timer myTimer;
    private TimerTask mMyTimerTask;
    public String[] stringArr_form;
    public String[] stringArr_form_new;
    private File file;






    public form() {
        setContentPane(contentPane);
        setModal(true);

        file = new File("E:\\политех\\3 курс\\2 семестр\\Технологии разработки качественного программного обеспечения\\Технологии разработки качественного программного обеспечения Лабараторные\\37\\src\\timer_cal\\save.txt");



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


                stringArr_form_new = new String[stringArr_form.length+2];
                for (int i=0; i<stringArr_form.length; i++){
                    stringArr_form_new[i]=stringArr_form[i];
                }
                System.out.println(stringArr_form_new.length);

                stringArr_form_new[stringArr_form_new.length-2]=textField1.getText();
                stringArr_form_new[stringArr_form_new.length-1]="0";

                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(file, "UTF-8");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                for (int i=0; i<stringArr_form_new.length; i++){
                    writer.println(stringArr_form_new[i]);

                }
                writer.close();

                stringArr_form = new String[stringArr_form_new.length];
                for (int i=0; i<stringArr_form.length; i++){
                    stringArr_form[i]=stringArr_form_new[i];
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
                cal = calories.view_trening(view_tren);
                spen_cal = calories.spent_calories(cal, sec_all);
                for (int i=0; i<stringArr_form.length; i++){
                    if(stringArr_form[i]==users_label.getText()){
                        spen_cal=Integer.parseInt(stringArr_form[i+1])+spen_cal;
                        stringArr_form[i+1]=Integer.toString(spen_cal);
                    }
                }
                LabelCal.setText(" "+spen_cal+" ");
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(file, "UTF-8");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                for (int i=0; i<stringArr_form.length; i++){
                    writer.println(stringArr_form[i]);

                }
                writer.close();

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
        button_users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                users_label.setText(comboBox1.getSelectedItem().toString());


                for (int i=0; i<stringArr_form.length; i++){
                    if(stringArr_form[i]==users_label.getText()){
                        LabelCal.setText(stringArr_form[i+1]);
                    }
                }

                System.out.println(comboBox1.getSelectedItem());
                System.out.println();


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
                    }
                }
                catch (InterruptedException er){
                    er.printStackTrace();
                }
            }
        }
        };

    public static void main(String[] args) throws IOException {

        String[] stringArr;
        stringArr= main.open_fail();
        form dialog = new form();
        for(int i=0; i<stringArr.length;i++){
            if(i==0 | i%2==0){
                dialog.comboBox1.addItem(stringArr[i]);
            }
        }
        dialog.stringArr_form=stringArr;

        dialog.users_label.setText(stringArr[0]);
        dialog.LabelCal.setText(stringArr[1]);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }


}

