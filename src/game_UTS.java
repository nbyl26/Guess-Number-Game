import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author nabil
 */
public class game_UTS extends javax.swing.JFrame {

    /**
     * Creates new form game_UTS
     */
    private int[] randomNumber = new int[4];
    private int attempts;
    private int currentAttempt = 0;
    
    private void initGame(){
        randomNumber = generateUniqueRandomNumbers();
        attempts = 10;
//        currentAttempt = 0;
    }
    
    private int[] generateUniqueRandomNumbers(){
        int[] randomNumbers = new int[4];
        HashSet<Integer>generatedNumbers = new HashSet<>();
        Random random = new Random();
        int count = 0;
        while (count < 4){
            int number = random.nextInt(10);
            if(!generatedNumbers.contains(number)){
                generatedNumbers.add(number);
                randomNumbers[count] = number;
                count++;
            }
        }
        return randomNumbers;
    }
     
//    private void generateRandomNumber() {
//        Random random = new Random();
//        for (int i = 0; i < 4; i++){
//            randomNumber[i] = random.nextInt(10);
//        }
//    }
    private void processGuess() {
        try {
            int[] userGuess = new int[4];
            userGuess[0] = validateAndParse(txtGuess1_1.getText());
            userGuess[1] = validateAndParse(txtGuess1_2.getText());
            userGuess[2] = validateAndParse(txtGuess1_3.getText());
            userGuess[3] = validateAndParse(txtGuess1_4.getText());

            checkGuess(userGuess); // Panggil checkGuess dengan input yang sudah divalidasi
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
//    Method untuk memeriksa tebakan
    private void checkGuess(int[] userGuess){
        if(!isValidInput(userGuess)){
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid anatara 0 dan 9!", "Information!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
            
        int correctNumber = 0;
        int correctPosition = 0;
        
        boolean[] checkedRandom = new boolean[4];
        boolean[] checkedUser = new boolean[4];
        
        for(int i = 0; i < 4; i++){
            if(userGuess[i] == randomNumber[i]){
                correctPosition++;
                correctNumber++;
                checkedRandom[i] = true;
                checkedUser[i] = true;
            }
        }
        
        for(int i = 0; i < 4; i++){
            if(!checkedUser[i]){
                for (int j = 0; j < 4; j++){
                    if(userGuess[i] == randomNumber[j] && !checkedRandom[j]){
                        correctNumber++;
                        checkedRandom[j] = true;
                        break;
                    }
                }
            }
        }
        
        switch(currentAttempt){
            case 0:
                txtCorrectNumber1.setText(String.valueOf(correctNumber));
                txtCorrectPosition1.setText(String.valueOf(correctPosition));
                break;
            case 1:
                txtCorrectNumber2.setText(String.valueOf(correctNumber));
                txtCorrectPosition2.setText(String.valueOf(correctPosition));
                break;
            case 2:
                txtCorrectNumber3.setText(String.valueOf(correctNumber));
                txtCorrectPosition3.setText(String.valueOf(correctPosition));
                break;
            case 3:
                txtCorrectNumber4.setText(String.valueOf(correctNumber));
                txtCorrectPosition4.setText(String.valueOf(correctPosition));
                break;
            case 4:
                txtCorrectNumber5.setText(String.valueOf(correctNumber));
                txtCorrectPosition5.setText(String.valueOf(correctPosition));
                break;
            case 5:
                txtCorrectNumber6.setText(String.valueOf(correctNumber));
                txtCorrectPosition6.setText(String.valueOf(correctPosition));
                break;
            case 6:
                txtCorrectNumber7.setText(String.valueOf(correctNumber));
                txtCorrectPosition7.setText(String.valueOf(correctPosition));
                break;
            case 7:
                txtCorrectNumber8.setText(String.valueOf(correctNumber));
                txtCorrectPosition8.setText(String.valueOf(correctPosition));
                break;
            case 8:
                txtCorrectNumber9.setText(String.valueOf(correctNumber));
                txtCorrectPosition9.setText(String.valueOf(correctPosition));
                break;
            case 9:
                txtCorrectNumber10.setText(String.valueOf(correctNumber));
                txtCorrectPosition10.setText(String.valueOf(correctPosition));
                break;
            
            default :
                JOptionPane.showMessageDialog(this, "Anda sudah Menggunakan semua percobaan!");
                return;
        }
        
        attempts--;
//        currentAttempt++;
        
        if (correctPosition == 4){
            JOptionPane.showMessageDialog(this, "Selamat Anda Menebak dengan benar! \nThe Correct Number is : " + displayRandomNumber(), "YOU WIN!", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        } else if (attempts == 0){
            JOptionPane.showMessageDialog(this, "The correct number is : " + displayRandomNumber(), "YOU LOSE!", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
    }
    
    private boolean isValidInput (int[] userGuess){
        for(int i = 0; i < userGuess.length; i++){
            if(userGuess[i] < 0 || userGuess[i] > 9){
                return false;
            }
        }
        return true;
    }
    
    private boolean contains (int[] arr, int value){
        for(int i : arr){
            if(i == value){
                return true;
            }
        }
        return false;
    }
    
    private String displayRandomNumber(){
        StringBuilder sb = new StringBuilder();
        for(int i : randomNumber){
            sb.append(i).append(" ");
        }
        return sb.toString();
//          return randomNumber[0] + " " + randomNumber[1] + " " + randomNumber[2] + " " + randomNumber[3];
    }
    
    private void resetGame(){
        txtGuess1_1.setText("");
        txtGuess1_2.setText("");
        txtGuess1_3.setText("");
        txtGuess1_4.setText("");
        
        txtGuess2_1.setText("");
        txtGuess2_2.setText("");
        txtGuess2_3.setText("");
        txtGuess2_4.setText("");
        
        txtGuess3_1.setText("");
        txtGuess3_2.setText("");
        txtGuess3_3.setText("");
        txtGuess3_4.setText("");
        
        txtGuess4_1.setText("");
        txtGuess4_2.setText("");
        txtGuess4_3.setText("");
        txtGuess4_4.setText("");
        
        txtGuess5_1.setText("");
        txtGuess5_2.setText("");
        txtGuess5_3.setText("");
        txtGuess5_4.setText("");
        
        txtGuess6_1.setText("");
        txtGuess6_2.setText("");
        txtGuess6_3.setText("");
        txtGuess6_4.setText("");
        
        txtGuess7_1.setText("");
        txtGuess7_2.setText("");
        txtGuess7_3.setText("");
        txtGuess7_4.setText("");
        
        txtGuess8_1.setText("");
        txtGuess8_2.setText("");
        txtGuess8_3.setText("");
        txtGuess8_4.setText("");
        
        txtGuess9_1.setText("");
        txtGuess9_2.setText("");
        txtGuess9_3.setText("");
        txtGuess9_4.setText("");
        
        txtGuess10_1.setText("");
        txtGuess10_2.setText("");
        txtGuess10_3.setText("");
        txtGuess10_4.setText("");
        
        txtCorrectNumber1.setText(" ");
        txtCorrectPosition1.setText(" ");
        
        txtCorrectNumber2.setText(" ");
        txtCorrectPosition2.setText(" ");
        
        txtCorrectNumber3.setText(" ");
        txtCorrectPosition3.setText(" ");
        
        txtCorrectNumber4.setText(" ");
        txtCorrectPosition4.setText(" ");
        
        txtCorrectNumber5.setText(" ");
        txtCorrectPosition5.setText(" ");
        
        txtCorrectNumber6.setText(" ");
        txtCorrectPosition6.setText(" ");
        
        txtCorrectNumber7.setText(" ");
        txtCorrectPosition7.setText(" ");
        
        txtCorrectNumber8.setText(" ");
        txtCorrectPosition8.setText(" ");
        
        txtCorrectNumber9.setText(" ");
        txtCorrectPosition9.setText(" ");
        
        txtCorrectNumber10.setText(" ");
        txtCorrectPosition10.setText(" ");
        
        currentAttempt = 0;
        attempts = 10;
        
        generateUniqueRandomNumbers();
    }
    
    private int validateAndParse(String input) throws NumberFormatException {
        if(input == null || input.trim().isEmpty()){
            throw new NumberFormatException("Input tidak boleh kosong");
        }
        
//        if(!input.matches("\\d+")) {
//            throw new NumberFormatException("Masukkan angka");
//        }
        int number = Integer.parseInt(input);  // Ubah menjadi integer
        if (number < 0 || number > 9) {
            throw new NumberFormatException("Angka harus antara 0 dan 9");
        }
        return number;
    }
    
        
    public game_UTS() {
        initComponents();
        btnReset.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                resetGame();
                JOptionPane.showMessageDialog(null, "Game Telah di-reset!", "Game has been reset", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jButton1.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Guess a four-digit number.\nThe yellow and green boxes give you clues about your attempt.\nYellow indicates how many correct digits there are,\ngreen indicates how many are in the correct position.\nEnjoy and good luck!", "How To Play?", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        initGame();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        txtGuess1_1 = new javax.swing.JTextField();
        txtGuess1_2 = new javax.swing.JTextField();
        txtGuess1_3 = new javax.swing.JTextField();
        txtGuess1_4 = new javax.swing.JTextField();
        txtGuess2_1 = new javax.swing.JTextField();
        txtGuess2_2 = new javax.swing.JTextField();
        txtGuess2_3 = new javax.swing.JTextField();
        txtGuess2_4 = new javax.swing.JTextField();
        txtGuess3_1 = new javax.swing.JTextField();
        txtGuess3_2 = new javax.swing.JTextField();
        txtGuess3_3 = new javax.swing.JTextField();
        txtGuess3_4 = new javax.swing.JTextField();
        txtGuess4_1 = new javax.swing.JTextField();
        txtGuess4_2 = new javax.swing.JTextField();
        txtGuess4_3 = new javax.swing.JTextField();
        txtGuess4_4 = new javax.swing.JTextField();
        txtGuess5_1 = new javax.swing.JTextField();
        txtGuess5_2 = new javax.swing.JTextField();
        txtGuess5_3 = new javax.swing.JTextField();
        txtGuess5_4 = new javax.swing.JTextField();
        txtGuess6_1 = new javax.swing.JTextField();
        txtGuess6_2 = new javax.swing.JTextField();
        txtGuess6_3 = new javax.swing.JTextField();
        txtGuess6_4 = new javax.swing.JTextField();
        txtGuess7_1 = new javax.swing.JTextField();
        txtGuess7_2 = new javax.swing.JTextField();
        txtGuess7_3 = new javax.swing.JTextField();
        txtGuess7_4 = new javax.swing.JTextField();
        txtGuess8_1 = new javax.swing.JTextField();
        txtGuess8_2 = new javax.swing.JTextField();
        txtGuess8_3 = new javax.swing.JTextField();
        txtGuess8_4 = new javax.swing.JTextField();
        txtGuess9_1 = new javax.swing.JTextField();
        txtGuess9_2 = new javax.swing.JTextField();
        txtGuess9_3 = new javax.swing.JTextField();
        txtGuess9_4 = new javax.swing.JTextField();
        txtGuess10_1 = new javax.swing.JTextField();
        txtGuess10_2 = new javax.swing.JTextField();
        txtGuess10_3 = new javax.swing.JTextField();
        txtGuess10_4 = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        txtCorrectNumber1 = new javax.swing.JTextField();
        txtCorrectNumber2 = new javax.swing.JTextField();
        txtCorrectNumber3 = new javax.swing.JTextField();
        txtCorrectNumber4 = new javax.swing.JTextField();
        txtCorrectNumber5 = new javax.swing.JTextField();
        txtCorrectNumber6 = new javax.swing.JTextField();
        txtCorrectNumber7 = new javax.swing.JTextField();
        txtCorrectNumber8 = new javax.swing.JTextField();
        txtCorrectNumber9 = new javax.swing.JTextField();
        txtCorrectNumber10 = new javax.swing.JTextField();
        txtCorrectPosition1 = new javax.swing.JTextField();
        txtCorrectPosition2 = new javax.swing.JTextField();
        txtCorrectPosition3 = new javax.swing.JTextField();
        txtCorrectPosition4 = new javax.swing.JTextField();
        txtCorrectPosition5 = new javax.swing.JTextField();
        txtCorrectPosition6 = new javax.swing.JTextField();
        txtCorrectPosition7 = new javax.swing.JTextField();
        txtCorrectPosition8 = new javax.swing.JTextField();
        txtCorrectPosition9 = new javax.swing.JTextField();
        txtCorrectPosition10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtGuess1_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess1_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess1_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess1_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess1_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess1_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess1_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess1_2ActionPerformed(evt);
            }
        });

        txtGuess1_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess1_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess1_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess1_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess1_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess1_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess1_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess1_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess2_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess2_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess2_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess2_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess2_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess2_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess2_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess2_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess2_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess2_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess2_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess2_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess2_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess2_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess2_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess2_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess3_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess3_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess3_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess3_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess3_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess3_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess3_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess3_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess3_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess3_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess3_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess3_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess3_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess3_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess4_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess4_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess4_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess4_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess4_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess4_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess4_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess4_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess4_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess4_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess4_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess4_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess4_3ActionPerformed(evt);
            }
        });

        txtGuess4_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess4_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess4_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess4_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess5_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess5_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess5_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess5_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess5_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess5_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess5_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess5_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess5_2ActionPerformed(evt);
            }
        });

        txtGuess5_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess5_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess5_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess5_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess5_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess5_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess5_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess5_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess6_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess6_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess6_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess6_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess6_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess6_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess6_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess6_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess6_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess6_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess6_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess6_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess6_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess6_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess6_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess6_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess6_4ActionPerformed(evt);
            }
        });

        txtGuess7_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess7_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess7_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess7_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess7_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess7_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess7_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess7_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess7_2ActionPerformed(evt);
            }
        });

        txtGuess7_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess7_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess7_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess7_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess7_3ActionPerformed(evt);
            }
        });

        txtGuess7_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess7_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess7_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess7_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess8_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess8_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess8_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess8_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess8_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess8_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess8_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess8_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess8_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess8_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess8_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess8_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess8_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess8_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess8_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess8_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess9_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess9_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess9_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess9_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess9_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess9_1ActionPerformed(evt);
            }
        });

        txtGuess9_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess9_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess9_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess9_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess9_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess9_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess9_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess9_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess9_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess9_3ActionPerformed(evt);
            }
        });

        txtGuess9_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess9_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess9_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess9_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess10_1.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess10_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess10_1.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess10_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess10_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess10_1ActionPerformed(evt);
            }
        });

        txtGuess10_2.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess10_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess10_2.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess10_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGuess10_3.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess10_3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess10_3.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess10_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuess10_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuess10_3ActionPerformed(evt);
            }
        });

        txtGuess10_4.setBackground(new java.awt.Color(102, 102, 102));
        txtGuess10_4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGuess10_4.setForeground(new java.awt.Color(255, 255, 255));
        txtGuess10_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnSubmit.setBackground(new java.awt.Color(0, 153, 0));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Guess a four-digit number");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Correct Numbers");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Correct Positions");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Guess Number ");

        btnReset.setBackground(new java.awt.Color(204, 51, 0));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");

        txtCorrectNumber1.setEditable(false);
        txtCorrectNumber1.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber1.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber2.setEditable(false);
        txtCorrectNumber2.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber2.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber3.setEditable(false);
        txtCorrectNumber3.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber3.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber4.setEditable(false);
        txtCorrectNumber4.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber4.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber5.setEditable(false);
        txtCorrectNumber5.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber5.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber6.setEditable(false);
        txtCorrectNumber6.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber6.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber7.setEditable(false);
        txtCorrectNumber7.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber7.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber8.setEditable(false);
        txtCorrectNumber8.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber8.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber9.setEditable(false);
        txtCorrectNumber9.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber9.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectNumber10.setEditable(false);
        txtCorrectNumber10.setBackground(new java.awt.Color(204, 153, 0));
        txtCorrectNumber10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectNumber10.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectNumber10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition1.setEditable(false);
        txtCorrectPosition1.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition1.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition2.setEditable(false);
        txtCorrectPosition2.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition2.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition3.setEditable(false);
        txtCorrectPosition3.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition3.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition4.setEditable(false);
        txtCorrectPosition4.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition4.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition5.setEditable(false);
        txtCorrectPosition5.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition5.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition6.setEditable(false);
        txtCorrectPosition6.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition6.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition7.setEditable(false);
        txtCorrectPosition7.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition7.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition8.setEditable(false);
        txtCorrectPosition8.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition8.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition9.setEditable(false);
        txtCorrectPosition9.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition9.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCorrectPosition10.setEditable(false);
        txtCorrectPosition10.setBackground(new java.awt.Color(51, 153, 0));
        txtCorrectPosition10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCorrectPosition10.setForeground(new java.awt.Color(255, 255, 255));
        txtCorrectPosition10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setBackground(new java.awt.Color(0, 51, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtGuess1_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess2_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess3_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess4_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess5_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtGuess6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtGuess7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txtGuess8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess10_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtGuess1_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess2_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess3_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess4_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess5_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess8_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess9_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess10_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtGuess6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtGuess1_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess2_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess3_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess4_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess5_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess8_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess9_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess10_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtGuess6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtGuess1_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess2_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess3_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess4_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess5_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess8_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess9_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGuess10_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtGuess6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtGuess7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorrectNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorrectPosition1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrectPosition10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGuess1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess3_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess4_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess5_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess6_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess7_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess8_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess9_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGuess10_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtGuess1_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess2_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess3_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess4_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess5_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess6_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess7_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess8_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess9_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess10_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtGuess1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess3_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess4_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess5_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess6_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess7_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess8_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess9_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGuess10_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess1_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess2_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess3_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess4_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess5_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess6_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess7_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess8_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess9_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtGuess10_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorrectNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCorrectPosition1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorrectPosition10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        int[] userGuess = new int[4];

        try {
            // Ambil angka dari input user berdasarkan percobaan saat ini (currentAttempt)
            switch(currentAttempt) {
                case 0:
                    userGuess[0] = validateAndParse(txtGuess1_1.getText());
                    userGuess[1] = validateAndParse(txtGuess1_2.getText());
                    userGuess[2] = validateAndParse(txtGuess1_3.getText());
                    userGuess[3] = validateAndParse(txtGuess1_4.getText());
                    break;
                case 1:
                    userGuess[0] = validateAndParse(txtGuess2_1.getText());
                    userGuess[1] = validateAndParse(txtGuess2_2.getText());
                    userGuess[2] = validateAndParse(txtGuess2_3.getText());
                    userGuess[3] = validateAndParse(txtGuess2_4.getText());
                    break;
                case 2:
                    userGuess[0] = validateAndParse(txtGuess3_1.getText());
                    userGuess[1] = validateAndParse(txtGuess3_2.getText());
                    userGuess[2] = validateAndParse(txtGuess3_3.getText());
                    userGuess[3] = validateAndParse(txtGuess3_4.getText());
                    break;
                case 3:
                    userGuess[0] = validateAndParse(txtGuess4_1.getText());
                    userGuess[1] = validateAndParse(txtGuess4_2.getText());
                    userGuess[2] = validateAndParse(txtGuess4_3.getText());
                    userGuess[3] = validateAndParse(txtGuess4_4.getText());
                    break;
                case 4:
                    userGuess[0] = validateAndParse(txtGuess5_1.getText());
                    userGuess[1] = validateAndParse(txtGuess5_2.getText());
                    userGuess[2] = validateAndParse(txtGuess5_3.getText());
                    userGuess[3] = validateAndParse(txtGuess5_4.getText());
                    break;
                case 5:
                    userGuess[0] = validateAndParse(txtGuess6_1.getText());
                    userGuess[1] = validateAndParse(txtGuess6_2.getText());
                    userGuess[2] = validateAndParse(txtGuess6_3.getText());
                    userGuess[3] = validateAndParse(txtGuess6_4.getText());
                    break;
                case 6:
                    userGuess[0] = validateAndParse(txtGuess7_1.getText());
                    userGuess[1] = validateAndParse(txtGuess7_2.getText());
                    userGuess[2] = validateAndParse(txtGuess7_3.getText());
                    userGuess[3] = validateAndParse(txtGuess7_4.getText());
                    break;
                case 7:
                    userGuess[0] = validateAndParse(txtGuess8_1.getText());
                    userGuess[1] = validateAndParse(txtGuess8_2.getText());
                    userGuess[2] = validateAndParse(txtGuess8_3.getText());
                    userGuess[3] = validateAndParse(txtGuess8_4.getText());
                    break;
                case 8:
                    userGuess[0] = validateAndParse(txtGuess9_1.getText());
                    userGuess[1] = validateAndParse(txtGuess9_2.getText());
                    userGuess[2] = validateAndParse(txtGuess9_3.getText());
                    userGuess[3] = validateAndParse(txtGuess9_4.getText());
                    break;
                case 9:
                    userGuess[0] = validateAndParse(txtGuess10_1.getText());
                    userGuess[1] = validateAndParse(txtGuess10_2.getText());
                    userGuess[2] = validateAndParse(txtGuess10_3.getText());
                    userGuess[3] = validateAndParse(txtGuess10_4.getText());
                    break;
            }
//            System.out.println("User Guess: " + Arrays.toString(userGuess));

            // Setelah mendapatkan input, panggil metode checkGuess untuk mengecek tebakan
            checkGuess(userGuess);
            if(currentAttempt < 10){
                currentAttempt++;
            } else{
                JOptionPane.showMessageDialog(this, "The Correct Number is:  " + displayRandomNumber(), "YOU LOSE!", JOptionPane.INFORMATION_MESSAGE);
                resetGame();
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid antara 0 dan 9!", "Information!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtGuess1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess1_2ActionPerformed

    private void txtGuess4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess4_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess4_3ActionPerformed

    private void txtGuess5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess5_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess5_2ActionPerformed

    private void txtGuess6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess6_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess6_4ActionPerformed

    private void txtGuess7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess7_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess7_3ActionPerformed

    private void txtGuess7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess7_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess7_2ActionPerformed

    private void txtGuess9_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess9_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess9_3ActionPerformed

    private void txtGuess9_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess9_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess9_1ActionPerformed

    private void txtGuess10_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess10_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess10_3ActionPerformed

    private void txtGuess10_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuess10_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuess10_1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(game_UTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game_UTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game_UTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game_UTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        SwingUtilities.invokeLater(()-> {
            game_UTS game = new game_UTS();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setVisible(true);
            game.setSize(400, 300);
        });

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game_UTS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton jButton1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCorrectNumber1;
    private javax.swing.JTextField txtCorrectNumber10;
    private javax.swing.JTextField txtCorrectNumber2;
    private javax.swing.JTextField txtCorrectNumber3;
    private javax.swing.JTextField txtCorrectNumber4;
    private javax.swing.JTextField txtCorrectNumber5;
    private javax.swing.JTextField txtCorrectNumber6;
    private javax.swing.JTextField txtCorrectNumber7;
    private javax.swing.JTextField txtCorrectNumber8;
    private javax.swing.JTextField txtCorrectNumber9;
    private javax.swing.JTextField txtCorrectPosition1;
    private javax.swing.JTextField txtCorrectPosition10;
    private javax.swing.JTextField txtCorrectPosition2;
    private javax.swing.JTextField txtCorrectPosition3;
    private javax.swing.JTextField txtCorrectPosition4;
    private javax.swing.JTextField txtCorrectPosition5;
    private javax.swing.JTextField txtCorrectPosition6;
    private javax.swing.JTextField txtCorrectPosition7;
    private javax.swing.JTextField txtCorrectPosition8;
    private javax.swing.JTextField txtCorrectPosition9;
    private javax.swing.JTextField txtGuess10_1;
    private javax.swing.JTextField txtGuess10_2;
    private javax.swing.JTextField txtGuess10_3;
    private javax.swing.JTextField txtGuess10_4;
    private javax.swing.JTextField txtGuess1_1;
    private javax.swing.JTextField txtGuess1_2;
    private javax.swing.JTextField txtGuess1_3;
    private javax.swing.JTextField txtGuess1_4;
    private javax.swing.JTextField txtGuess2_1;
    private javax.swing.JTextField txtGuess2_2;
    private javax.swing.JTextField txtGuess2_3;
    private javax.swing.JTextField txtGuess2_4;
    private javax.swing.JTextField txtGuess3_1;
    private javax.swing.JTextField txtGuess3_2;
    private javax.swing.JTextField txtGuess3_3;
    private javax.swing.JTextField txtGuess3_4;
    private javax.swing.JTextField txtGuess4_1;
    private javax.swing.JTextField txtGuess4_2;
    private javax.swing.JTextField txtGuess4_3;
    private javax.swing.JTextField txtGuess4_4;
    private javax.swing.JTextField txtGuess5_1;
    private javax.swing.JTextField txtGuess5_2;
    private javax.swing.JTextField txtGuess5_3;
    private javax.swing.JTextField txtGuess5_4;
    private javax.swing.JTextField txtGuess6_1;
    private javax.swing.JTextField txtGuess6_2;
    private javax.swing.JTextField txtGuess6_3;
    private javax.swing.JTextField txtGuess6_4;
    private javax.swing.JTextField txtGuess7_1;
    private javax.swing.JTextField txtGuess7_2;
    private javax.swing.JTextField txtGuess7_3;
    private javax.swing.JTextField txtGuess7_4;
    private javax.swing.JTextField txtGuess8_1;
    private javax.swing.JTextField txtGuess8_2;
    private javax.swing.JTextField txtGuess8_3;
    private javax.swing.JTextField txtGuess8_4;
    private javax.swing.JTextField txtGuess9_1;
    private javax.swing.JTextField txtGuess9_2;
    private javax.swing.JTextField txtGuess9_3;
    private javax.swing.JTextField txtGuess9_4;
    // End of variables declaration//GEN-END:variables
}
