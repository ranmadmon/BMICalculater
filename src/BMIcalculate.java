import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

public class BMIcalculate extends JPanel implements ActionListener {
    private TextField ageText;
    private TextField weightText;

    private TextField nameText;
    private TextField familyNameText;
    private  JComboBox<String> comboBoxSex;
    private JSlider slider;
    private String gender="Man";
    private String[] manAndWomen={"Man","Women"};
    private JLabel heightLabel;
    private ImageIcon background;
    private JLabel backgroundLabel;
    private JButton printButton;
    private int height=165;
    private float weight;
    private String familyName;
    private float age;
    private String name;
    private String weightStatus;
    private double bmi;



    public BMIcalculate(){
        this.setLayout(null);
        this.setBounds(0,0,600,450);
        this.addName();
        this.addFamilyName();
        this.addAge();
        this.addSex();
        this.addSlider();
        this.stateChanged();
        this.addWeight();
        this.addButton();
        this.addBackgroundImage();



    }
    private void addBackgroundImage(){
        this.background=new ImageIcon("src/Images/backgroundImage.png");
        this.backgroundLabel=new JLabel(this.background);
        backgroundLabel.setBounds(0,0,600,450);
        this.add(backgroundLabel);
    }
    public void addName(){
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(30, 60, 100 , 30);
        labelName.setForeground(Color.green);
        labelName.setFont(new Font("Serif",Font.BOLD,20));
        this.add(labelName);

        this.nameText = new TextField("");
        nameText.setBounds(150, 60, 100, 30);
        this.add(nameText);
        nameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    name = nameText.getText();
                    for (int i=0;i<name.length();i++){
                        if (name.charAt(i)<65||name.charAt(i)>122){
                            System.out.println("you need to enter Letters");
                            nameText.setText("");
                            name = nameText.getText();
                        }
                    }
                    System.out.println("Name is "+name);
                } catch (Exception exception) {
                    System.out.println("Please enter Letters");
                    nameText.setText("");
                }
            }
        });
    }
    public void addFamilyName(){
        JLabel labelFamilyName = new JLabel("Family Name");
        labelFamilyName.setBounds(30, 130, 110 , 30);
        labelFamilyName.setForeground(Color.green);
        labelFamilyName.setFont(new Font("Serif",Font.BOLD,19));

        this.add(labelFamilyName);
        this.familyNameText = new TextField("");
        familyNameText.setBounds(150, 130, 100, 30);
        this.add(familyNameText);
        familyNameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    familyName = familyNameText.getText();
                    for (int i=0;i<familyName.length();i++){
                        if ((familyName.charAt(i)<65||familyName.charAt(i)>122)||(familyName.charAt(i)>90&&familyName.charAt(i)<97)){
                            System.out.println("you need to enter Letters");
                            familyNameText.setText("");
                            familyName = familyNameText.getText();
                        }
                    }
                    System.out.println("Family Name is "+familyName);
                } catch (Exception exception) {
                    System.out.println("Please enter Letters");
                    familyNameText.setText("");
                }
            }
        });
    }
    public void addAge(){
        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(30, 200, 100 , 30);
        labelAge.setForeground(Color.green);
        labelAge.setFont(new Font("Serif",Font.BOLD,20));

        this.add(labelAge);
        this.ageText = new TextField("");
        this.ageText.setBounds(150, 200, 100, 30);
        this.add(this.ageText);
        this.ageText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    age = Float.parseFloat(ageText.getText());
                    if(age<=0||age>120){
                        System.out.println("0 is not a valid number");
                        ageText.setText("");
                        age= Float.parseFloat(ageText.getText());
                    }
                    System.out.println("Age is "+age);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    ageText.setText("");
                }
            }
        });
    }
    public void addSex(){
        JLabel sexType=new JLabel("Gender");
        sexType.setBounds(30,270,100,50);
        sexType.setForeground(Color.green);
        sexType.setFont(new Font("Serif",Font.BOLD,20));

        this.add(sexType);
        this.comboBoxSex=new JComboBox(manAndWomen);
        comboBoxSex.setBounds(150,270,100,50);
        comboBoxSex.addActionListener(this);
        this.add(comboBoxSex);

    }
    private void addSlider(){
        slider=new JSlider(140,190);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.setBounds(305,60,80,260);
        this.heightLabel=new JLabel("Height = "+slider.getValue());
        this.heightLabel.setForeground(Color.GREEN);
        this.heightLabel.setFont(new Font("Serif",Font.BOLD,17));
        heightLabel.setBounds(305,320,100,50);
        this.add(heightLabel);
        this.add(slider);
    }
    public void addWeight(){
        JLabel labelWeight = new JLabel("Weight");
        labelWeight.setBounds(430, 220, 100 , 30);
        labelWeight.setForeground(Color.green);
        labelWeight.setFont(new Font("Serif",Font.BOLD,20));

        this.add(labelWeight);
        this.weightText = new TextField("");
        this.weightText.setBounds(420, 250, 100, 30);
        this.add(this.weightText);
        this.weightText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                       weight = Float.parseFloat(weightText.getText());
                    if(weight<=0||weight>500){
                        System.out.println("0 is not a valid number");
                        weightText.setText("");
                        weight= Float.parseFloat(weightText.getText());
                    }
                    System.out.println("Height is "+weight);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    weightText.setText("");
                }
            }
        });
    }
    private void addButton(){
        this.printButton=new JButton("Print");
        this.printButton.setBounds(420, 290, 100, 30);
        this.add(printButton);
        printButton.setEnabled(true);
        new Thread(()->{
            while (true){
                if (!weightText.getText().equals("")&&!ageText.getText().equals("")&&height!=0&&!nameText.getText().equals("")&&!familyNameText.getText().equals("")&&!gender.equals("")){
                    printButton.setEnabled(true);
                }else {
                    printButton.setEnabled(false);
                }
            }
        }).start();
        printButton.addActionListener(e->{
            bmi=Integer.parseInt(weightText.getText())/((slider.getValue()/100.0)*(slider.getValue()/100.0));
            if (bmi<15){
                weightStatus="Anorexic";
            }
            if (bmi>15&&bmi<=18.5){
                weightStatus="Underweight";
            }
            if (bmi>18.5&&bmi<=24.9){
                weightStatus="Normal";
            }
            if (bmi>24.9&&bmi<=29.9){
                weightStatus="Overweight";
            }
            if (bmi>29.9&&bmi<=35){
                weightStatus="Obese";
            }
            if (bmi>35){
                weightStatus=" Extreme Obese";
            }
            JOptionPane.showMessageDialog(null,"Name : "+nameText.getText()+"\n" +
                    "Family Name : "+familyNameText.getText()+"\n" +
                    "Age : "+ageText.getText()+"\n" +
                    "Height : "+slider.getValue()+"\n" +
                    "Weight : "+weightText.getText()+"\n" +
                    "BMI : "+bmi+"\n" +
                    "Weight Status : "+weightStatus);

        });

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==comboBoxSex){
            this.gender=manAndWomen[comboBoxSex.getSelectedIndex()];
            System.out.println(this.gender);
        }
    }
    public void stateChanged(){
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                heightLabel.setText("Height : "+slider.getValue());
                height=slider.getValue();
                System.out.println(height);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }
}
