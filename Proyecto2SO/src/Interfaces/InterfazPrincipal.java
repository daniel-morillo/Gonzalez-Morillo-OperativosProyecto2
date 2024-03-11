/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import proyecto2so.AI;
import proyecto2so.Company;
import proyecto2so.SO;
import proyecto2so.Simulacion;

/**
 *
 * @author Daniel Morillo
 */
public class InterfazPrincipal extends javax.swing.JFrame {
    

    Semaphore mutex = new Semaphore(1);
    String RSNames[] = {"Mordecai", "Rigby", "Skips", "Musculoso", "Fantasmin", "Benson", "Thomas", "Papaleta", "Muerte", "AntiPapaleta", "Margarita", "CJ", "Aylin", "GBF","FNAF","Gene","Martillo","Ross","Susan","Chad","Demon"};

    String RSPhotos[] = {"src/resources/mordecai.png", "src/resources/rigby.png", "src/resources/skips.png", "src/resources/musculoso.png", "src/resources/fantasmin.png", "src/resources/benson.png", "src/resources/thomas.png", "src/resources/pops.png", "src/resources/death.png", "src/resources/antipops.png", "src/resources/margarita.png", "src/resources/cj.png", "src/resources/aylin.png","src/resources/GBF.png","src/resources/FNAF.png","src/resources/Gene.png","src/resources/Martillo.png","src/resources/Ross.png","src/resources/Susan.png","src/resources/Chad.png","src/resources/Demon.png"};

    String AVNames[] = {"Aang", "Katara", "Sokka", "Toph", "Zuko", "Iroh", "Appa", "Momo", "Suki", "Azula", "Ozai", "Ty Lee", "Bumi", "Mai", "Leon tortuga", "Gyatso", "Roku", "Kyoshi", "Jet", "Zhao"};

    String AVPhotos[] = {"src/resources/Aang.PNG", "src/resources/Katara.png", "src/resources/Sokka.PNG", "src/resources/Toph.PNG", "src/resources/Zuko.PNG", "src/resources/Iroh.png", "src/resources/Appa.PNG", "src/resources/Momo.PNG", "src/resources/Suki.PNG", "src/resources/Azula.PNG", "src/resources/Ozai.PNG", "src/resources/Ty-Lee.PNG", "src/resources/Bumi.PNG", "src/resources/Mai.png", "src/resources/Leon-tortuga.png", "src/resources/Gyatso.png", "src/resources/Roku.png", "src/resources/Kyoshi.png", "src/resources/Jet.png", "src/resources/Zhao.png"};
    
    

    Company RSCompany = new Company('R', RSNames, RSPhotos);
    Company AVCompany = new Company('A', AVNames, AVPhotos);

    AI ai = new AI(5000, RSCompany, AVCompany, mutex );
    SO so = new SO(RSCompany, AVCompany, mutex);
    

    Simulacion simulacion = new Simulacion(RSCompany, AVCompany, so, ai);


    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
        
        setImageLabel(FondoLabel, "src/resources/MalevolantShrine.png");
        
        TimeField.setText(String.valueOf(ai.getBattleDuration()/1000));
        JLabel[] AIRSLabels = {RSIDLabel, RSFighterLabel, RSHPLabel, RSHabilityLabel, RSAtkLabel, RSAgilitylabel};
        JLabel[] AIAVLabels = {AVIDLabel, AVFighterLabel, AVHPLabel, AVHabilityLabel, AVATKLabel, AVAgilityLabel};
        
        JLabel[] RSPriority1Labels = {RSpr1_1image, RSpr1_1ID,RSpr1_2image, RSpr1_2ID,RSpr1_3image, RSpr1_3ID,RSpr1_4image, RSpr1_4ID };
        JLabel[] RSPriority2Labels = {RSpr2_1image, RSpr2_1ID,RSpr2_2image, RSpr2_2ID,RSpr2_3image, RSpr2_3ID,RSpr2_4image, RSpr2_4ID };
        JLabel[] RSPriority3Labels = {RSpr3_1image, RSpr3_1ID,RSpr3_2image, RSpr3_2ID,RSpr3_3image, RSpr3_3ID,RSpr3_4image, RSpr3_4ID };
        
        JLabel[] AVPriority1Labels = {AVpr1_1image, AVpr1_1ID,AVpr1_3image, AVpr1_2ID,AVpr1_2image, AVpr1_3ID,AVpr1_4image, AVpr1_4ID };
        JLabel[] AVPriority2Labels = {AVpr2_1image, AVpr2_1ID,AVpr2_2image, AVpr2_2ID,AVpr2_3image, AVpr2_3ID,AVpr2_4image, AVpr2_4ID };
        JLabel[] AVPriority3Labels = {AVpr3_1image, AVpr3_1ID,AVpr3_2image, AVpr3_2ID,AVpr3_3image, AVpr3_3ID,AVpr3_4image, AVpr3_4ID };
        
        
        JTextArea[] QueueLabels = {RSpr1,RSpr2,RSpr3,AVpr1,AVpr2,AVpr3};
        
        JTextArea[] ReinforcementsLabels = {RSReinArea,AVReinArea};
        
        JLabel[] ScoreLabels = {RSScore,AVScore};
        
        ai.setScorelabels(ScoreLabels);
        
        
        so.setRSPriority1Labels(RSPriority1Labels);
        so.setRSPriority2Labels(RSPriority2Labels);
        so.setRSPriority3Labels(RSPriority3Labels);
        
        so.setAVPriority1Labels(AVPriority1Labels);
        so.setAVPriority2Labels(AVPriority2Labels);
        so.setAVPriority3Labels(AVPriority3Labels);
        
        so.setQueueAreas(QueueLabels);
        
        so.setReinforcementLabels(ReinforcementsLabels);
        
        ai.setRSLabels(AIRSLabels);
        ai.setAVLabels(AIAVLabels);
        ai.setStatus(IAStatusLabel);
        ai.getStatus().setText("Iniciando");
        
        simulacion.start();
    }
    
    public void setImageLabel (JLabel nombrelabel, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(nombrelabel.getWidth(), nombrelabel.getHeight(), nombrelabel.getWidth()));
        nombrelabel.setIcon(icon);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RSFighterLabel = new javax.swing.JLabel();
        AVFighterLabel = new javax.swing.JLabel();
        RSHPLabel = new javax.swing.JLabel();
        RSHabilityLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RSAtkLabel = new javax.swing.JLabel();
        RSAgilitylabel = new javax.swing.JLabel();
        AVHPLabel = new javax.swing.JLabel();
        AVHabilityLabel = new javax.swing.JLabel();
        AVATKLabel = new javax.swing.JLabel();
        AVAgilityLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RSIDLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AVIDLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RSpr1_4ID = new javax.swing.JLabel();
        RSpr1_4image = new javax.swing.JLabel();
        RSpr1_3ID = new javax.swing.JLabel();
        RSpr1_3image = new javax.swing.JLabel();
        RSpr1_2ID = new javax.swing.JLabel();
        RSpr1_2image = new javax.swing.JLabel();
        RSpr1_1ID = new javax.swing.JLabel();
        RSpr1_1image = new javax.swing.JLabel();
        RSReinforcements = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RSReinArea = new javax.swing.JTextArea();
        TimeField = new javax.swing.JTextField();
        TimeButton = new javax.swing.JButton();
        statusIA = new javax.swing.JLabel();
        IAStatusLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RSpr1 = new javax.swing.JTextArea();
        RSReinforcements1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AVReinArea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        RSScore = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        RSpr2_4ID = new javax.swing.JLabel();
        RSpr2_4image = new javax.swing.JLabel();
        RSpr2_3ID = new javax.swing.JLabel();
        RSpr2_3image = new javax.swing.JLabel();
        RSpr2_2ID = new javax.swing.JLabel();
        RSpr2_2image = new javax.swing.JLabel();
        RSpr2_1ID = new javax.swing.JLabel();
        RSpr2_1image = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        RSpr2 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        RSpr3_4ID = new javax.swing.JLabel();
        RSpr3_4image = new javax.swing.JLabel();
        RSpr3_3ID = new javax.swing.JLabel();
        RSpr3_3image = new javax.swing.JLabel();
        RSpr3_2ID = new javax.swing.JLabel();
        RSpr3_2image = new javax.swing.JLabel();
        RSpr3_1ID = new javax.swing.JLabel();
        RSpr3_1image = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        RSpr3 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        AVpr1_4image = new javax.swing.JLabel();
        AVpr1_1ID = new javax.swing.JLabel();
        AVpr1_1image = new javax.swing.JLabel();
        AVpr1_2ID = new javax.swing.JLabel();
        AVpr1_2image = new javax.swing.JLabel();
        AVpr1_3ID = new javax.swing.JLabel();
        AVpr1_3image = new javax.swing.JLabel();
        AVpr1_4ID = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        AVpr1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        AVScore = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        AVpr2_1ID = new javax.swing.JLabel();
        AVpr2_1image = new javax.swing.JLabel();
        AVpr2_2ID = new javax.swing.JLabel();
        AVpr2_2image = new javax.swing.JLabel();
        AVpr2_3ID = new javax.swing.JLabel();
        AVpr2_3image = new javax.swing.JLabel();
        AVpr2_4ID = new javax.swing.JLabel();
        AVpr2_4image = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        AVpr2 = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        AVpr3_1ID = new javax.swing.JLabel();
        AVpr3_1image = new javax.swing.JLabel();
        AVpr3_2ID = new javax.swing.JLabel();
        AVpr3_2image = new javax.swing.JLabel();
        AVpr3_3ID = new javax.swing.JLabel();
        AVpr3_3image = new javax.swing.JLabel();
        AVpr3_4ID = new javax.swing.JLabel();
        AVpr3_4image = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        AVpr3 = new javax.swing.JTextArea();
        RSid = new javax.swing.JLabel();
        AVid = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        FondoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(RSFighterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 150, 150));
        getContentPane().add(AVFighterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 150, 150));

        RSHPLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSHPLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(RSHPLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 68, 35));

        RSHabilityLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSHabilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(RSHabilityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 68, 35));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado de la IA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, 35));

        RSAtkLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSAtkLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(RSAtkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 68, 35));

        RSAgilitylabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSAgilitylabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(RSAgilitylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 68, 35));

        AVHPLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        AVHPLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(AVHPLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 68, 35));

        AVHabilityLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        AVHabilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(AVHabilityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 65, 34));

        AVATKLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        AVATKLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(AVATKLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 65, 36));

        AVAgilityLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        AVAgilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(AVAgilityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 71, 35));

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID : ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        RSIDLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        RSIDLabel.setText(" ");
        getContentPane().add(RSIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 117, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        AVIDLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        AVIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        AVIDLabel.setText(" ");
        getContentPane().add(AVIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 101, -1));

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PRIORIDAD 1");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 173, -1));

        RSpr1_4ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr1_4ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr1_4ID.setText("ID: ");
        getContentPane().add(RSpr1_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 56, -1));
        getContentPane().add(RSpr1_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 50, 50));

        RSpr1_3ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr1_3ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr1_3ID.setText("ID: ");
        getContentPane().add(RSpr1_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 56, -1));
        getContentPane().add(RSpr1_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 50, 50));

        RSpr1_2ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr1_2ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr1_2ID.setText("ID: ");
        getContentPane().add(RSpr1_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 56, -1));
        getContentPane().add(RSpr1_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 50, 50));

        RSpr1_1ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr1_1ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr1_1ID.setText("ID: ");
        getContentPane().add(RSpr1_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 56, -1));
        getContentPane().add(RSpr1_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 50, 50));

        RSReinforcements.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSReinforcements.setForeground(new java.awt.Color(255, 255, 255));
        RSReinforcements.setText("REFUERZOS:");
        getContentPane().add(RSReinforcements, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 110, 40));

        RSReinArea.setBackground(new java.awt.Color(0, 0, 0));
        RSReinArea.setColumns(20);
        RSReinArea.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        RSReinArea.setForeground(new java.awt.Color(255, 255, 255));
        RSReinArea.setRows(5);
        jScrollPane1.setViewportView(RSReinArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 310, 30));

        TimeField.setBackground(new java.awt.Color(0, 0, 0));
        TimeField.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        TimeField.setForeground(new java.awt.Color(255, 255, 255));
        TimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeFieldActionPerformed(evt);
            }
        });
        getContentPane().add(TimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 80, -1));

        TimeButton.setBackground(new java.awt.Color(0, 0, 0));
        TimeButton.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        TimeButton.setForeground(new java.awt.Color(255, 255, 255));
        TimeButton.setText("BattleDuration");
        TimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(TimeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, -1, -1));
        getContentPane().add(statusIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 710, 160, -1));

        IAStatusLabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        IAStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        IAStatusLabel.setText("   ");
        getContentPane().add(IAStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 200, -1));

        RSpr1.setEditable(false);
        RSpr1.setBackground(new java.awt.Color(0, 0, 0));
        RSpr1.setColumns(20);
        RSpr1.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        RSpr1.setForeground(new java.awt.Color(255, 255, 255));
        RSpr1.setRows(5);
        RSpr1.setToolTipText("");
        jScrollPane3.setViewportView(RSpr1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 300, 50));

        RSReinforcements1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSReinforcements1.setForeground(new java.awt.Color(255, 255, 255));
        RSReinforcements1.setText("REFUERZOS:");
        getContentPane().add(RSReinforcements1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 110, 40));

        AVReinArea.setBackground(new java.awt.Color(0, 0, 0));
        AVReinArea.setColumns(20);
        AVReinArea.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        AVReinArea.setForeground(new java.awt.Color(255, 255, 255));
        AVReinArea.setRows(5);
        jScrollPane4.setViewportView(AVReinArea);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 580, 310, 30));

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Regular Show VS Avatar");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SCORE: ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        RSScore.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSScore.setForeground(new java.awt.Color(255, 255, 255));
        RSScore.setText(" ");
        getContentPane().add(RSScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 40, -1));

        jLabel21.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("PRIORIDAD 2");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 173, -1));

        RSpr2_4ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr2_4ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr2_4ID.setText("ID: ");
        getContentPane().add(RSpr2_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 56, -1));
        getContentPane().add(RSpr2_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 50, 50));

        RSpr2_3ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr2_3ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr2_3ID.setText("ID: ");
        getContentPane().add(RSpr2_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 56, -1));
        getContentPane().add(RSpr2_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 50, 50));

        RSpr2_2ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr2_2ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr2_2ID.setText("ID: ");
        getContentPane().add(RSpr2_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 56, -1));
        getContentPane().add(RSpr2_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 50, 50));

        RSpr2_1ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr2_1ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr2_1ID.setText("ID: ");
        getContentPane().add(RSpr2_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 56, -1));
        getContentPane().add(RSpr2_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 50, 50));

        RSpr2.setEditable(false);
        RSpr2.setBackground(new java.awt.Color(0, 0, 0));
        RSpr2.setColumns(20);
        RSpr2.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        RSpr2.setForeground(new java.awt.Color(255, 255, 255));
        RSpr2.setRows(5);
        RSpr2.setToolTipText("");
        jScrollPane8.setViewportView(RSpr2);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 300, 50));

        jLabel23.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PRIORIDAD 3");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 173, -1));

        RSpr3_4ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr3_4ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr3_4ID.setText("ID: ");
        getContentPane().add(RSpr3_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 56, -1));
        getContentPane().add(RSpr3_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 50, 50));

        RSpr3_3ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr3_3ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr3_3ID.setText("ID: ");
        getContentPane().add(RSpr3_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 56, -1));
        getContentPane().add(RSpr3_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 50, 50));

        RSpr3_2ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr3_2ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr3_2ID.setText("ID: ");
        getContentPane().add(RSpr3_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 56, -1));
        getContentPane().add(RSpr3_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 50, 50));

        RSpr3_1ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        RSpr3_1ID.setForeground(new java.awt.Color(255, 255, 255));
        RSpr3_1ID.setText("ID: ");
        getContentPane().add(RSpr3_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 56, -1));
        getContentPane().add(RSpr3_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 50, 50));

        RSpr3.setEditable(false);
        RSpr3.setBackground(new java.awt.Color(0, 0, 0));
        RSpr3.setColumns(20);
        RSpr3.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        RSpr3.setForeground(new java.awt.Color(255, 255, 255));
        RSpr3.setRows(5);
        RSpr3.setToolTipText("");
        jScrollPane9.setViewportView(RSpr3);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 300, 50));

        jLabel25.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("PRIORIDAD 1");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 173, -1));
        getContentPane().add(AVpr1_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 50, 50));

        AVpr1_1ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr1_1ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr1_1ID.setText("ID: ");
        getContentPane().add(AVpr1_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 56, -1));
        getContentPane().add(AVpr1_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, 50, 50));

        AVpr1_2ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr1_2ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr1_2ID.setText("ID: ");
        getContentPane().add(AVpr1_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 56, -1));
        getContentPane().add(AVpr1_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 50, 50));

        AVpr1_3ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr1_3ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr1_3ID.setText("ID: ");
        getContentPane().add(AVpr1_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 56, -1));
        getContentPane().add(AVpr1_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 50, 50));

        AVpr1_4ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr1_4ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr1_4ID.setText("ID: ");
        getContentPane().add(AVpr1_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, 56, -1));

        AVpr1.setEditable(false);
        AVpr1.setBackground(new java.awt.Color(0, 0, 0));
        AVpr1.setColumns(20);
        AVpr1.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        AVpr1.setForeground(new java.awt.Color(255, 255, 255));
        AVpr1.setRows(5);
        AVpr1.setToolTipText("");
        jScrollPane12.setViewportView(AVpr1);

        getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, 330, 50));

        jLabel26.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("SCORE: ");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        AVScore.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVScore.setForeground(new java.awt.Color(255, 255, 255));
        AVScore.setText(" ");
        getContentPane().add(AVScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 40, -1));

        jLabel28.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("PRIORIDAD 2");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, 173, -1));

        AVpr2_1ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr2_1ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr2_1ID.setText("ID: ");
        getContentPane().add(AVpr2_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 56, -1));
        getContentPane().add(AVpr2_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 50, 50));

        AVpr2_2ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr2_2ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr2_2ID.setText("ID: ");
        getContentPane().add(AVpr2_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 290, 56, -1));
        getContentPane().add(AVpr2_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 230, 50, 50));

        AVpr2_3ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr2_3ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr2_3ID.setText("ID: ");
        getContentPane().add(AVpr2_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 56, -1));
        getContentPane().add(AVpr2_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 50, 50));

        AVpr2_4ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr2_4ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr2_4ID.setText("ID: ");
        getContentPane().add(AVpr2_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 290, 56, -1));
        getContentPane().add(AVpr2_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 230, 50, 50));

        AVpr2.setEditable(false);
        AVpr2.setBackground(new java.awt.Color(0, 0, 0));
        AVpr2.setColumns(20);
        AVpr2.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        AVpr2.setForeground(new java.awt.Color(255, 255, 255));
        AVpr2.setRows(5);
        AVpr2.setToolTipText("");
        jScrollPane15.setViewportView(AVpr2);

        getContentPane().add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 340, 50));

        jLabel30.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("PRIORIDAD 3");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 173, -1));

        AVpr3_1ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr3_1ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr3_1ID.setText("ID: ");
        getContentPane().add(AVpr3_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 56, -1));
        getContentPane().add(AVpr3_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 50, 50));

        AVpr3_2ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr3_2ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr3_2ID.setText("ID: ");
        getContentPane().add(AVpr3_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 56, -1));
        getContentPane().add(AVpr3_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 50, 50));

        AVpr3_3ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr3_3ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr3_3ID.setText("ID: ");
        getContentPane().add(AVpr3_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 460, 56, -1));
        getContentPane().add(AVpr3_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 50, 50));

        AVpr3_4ID.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        AVpr3_4ID.setForeground(new java.awt.Color(255, 255, 255));
        AVpr3_4ID.setText("ID: ");
        getContentPane().add(AVpr3_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 460, 56, -1));
        getContentPane().add(AVpr3_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 400, 50, 50));

        AVpr3.setEditable(false);
        AVpr3.setBackground(new java.awt.Color(0, 0, 0));
        AVpr3.setColumns(20);
        AVpr3.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        AVpr3.setForeground(new java.awt.Color(255, 255, 255));
        AVpr3.setRows(5);
        AVpr3.setToolTipText("");
        jScrollPane16.setViewportView(AVpr3);

        getContentPane().add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 350, 50));

        RSid.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        RSid.setForeground(new java.awt.Color(255, 255, 255));
        RSid.setText(" ");
        getContentPane().add(RSid, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 50, -1));

        AVid.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        AVid.setForeground(new java.awt.Color(255, 255, 255));
        AVid.setText(" ");
        getContentPane().add(AVid, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 70, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HP: ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, 35));

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Habilidad:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, 35));

        jLabel15.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ataque: ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, 35));

        jLabel18.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Agilidad:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, 35));

        jLabel19.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("HP: ");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, 35));

        jLabel20.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Habilidad:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, -1, 35));

        jLabel22.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ataque:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, 35));

        jLabel24.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Agilidad:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, 35));
        getContentPane().add(FondoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1290, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFieldActionPerformed

    private void TimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeButtonActionPerformed
        // TODO add your handling code here:
        ai.setBattleDuration(Integer.parseInt(TimeField.getText())*1000);
        JOptionPane.showMessageDialog(this, "Duracion de Batalla Cambiada con Exito");
    }//GEN-LAST:event_TimeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AVATKLabel;
    private javax.swing.JLabel AVAgilityLabel;
    private javax.swing.JLabel AVFighterLabel;
    private javax.swing.JLabel AVHPLabel;
    private javax.swing.JLabel AVHabilityLabel;
    private javax.swing.JLabel AVIDLabel;
    private javax.swing.JTextArea AVReinArea;
    private javax.swing.JLabel AVScore;
    private javax.swing.JLabel AVid;
    private javax.swing.JTextArea AVpr1;
    private javax.swing.JLabel AVpr1_1ID;
    private javax.swing.JLabel AVpr1_1image;
    private javax.swing.JLabel AVpr1_2ID;
    private javax.swing.JLabel AVpr1_2image;
    private javax.swing.JLabel AVpr1_3ID;
    private javax.swing.JLabel AVpr1_3image;
    private javax.swing.JLabel AVpr1_4ID;
    private javax.swing.JLabel AVpr1_4image;
    private javax.swing.JTextArea AVpr2;
    private javax.swing.JLabel AVpr2_1ID;
    private javax.swing.JLabel AVpr2_1image;
    private javax.swing.JLabel AVpr2_2ID;
    private javax.swing.JLabel AVpr2_2image;
    private javax.swing.JLabel AVpr2_3ID;
    private javax.swing.JLabel AVpr2_3image;
    private javax.swing.JLabel AVpr2_4ID;
    private javax.swing.JLabel AVpr2_4image;
    private javax.swing.JTextArea AVpr3;
    private javax.swing.JLabel AVpr3_1ID;
    private javax.swing.JLabel AVpr3_1image;
    private javax.swing.JLabel AVpr3_2ID;
    private javax.swing.JLabel AVpr3_2image;
    private javax.swing.JLabel AVpr3_3ID;
    private javax.swing.JLabel AVpr3_3image;
    private javax.swing.JLabel AVpr3_4ID;
    private javax.swing.JLabel AVpr3_4image;
    private javax.swing.JLabel FondoLabel;
    private javax.swing.JLabel IAStatusLabel;
    private javax.swing.JLabel RSAgilitylabel;
    private javax.swing.JLabel RSAtkLabel;
    private javax.swing.JLabel RSFighterLabel;
    private javax.swing.JLabel RSHPLabel;
    private javax.swing.JLabel RSHabilityLabel;
    private javax.swing.JLabel RSIDLabel;
    private javax.swing.JTextArea RSReinArea;
    private javax.swing.JLabel RSReinforcements;
    private javax.swing.JLabel RSReinforcements1;
    private javax.swing.JLabel RSScore;
    private javax.swing.JLabel RSid;
    private javax.swing.JTextArea RSpr1;
    private javax.swing.JLabel RSpr1_1ID;
    private javax.swing.JLabel RSpr1_1image;
    private javax.swing.JLabel RSpr1_2ID;
    private javax.swing.JLabel RSpr1_2image;
    private javax.swing.JLabel RSpr1_3ID;
    private javax.swing.JLabel RSpr1_3image;
    private javax.swing.JLabel RSpr1_4ID;
    private javax.swing.JLabel RSpr1_4image;
    private javax.swing.JTextArea RSpr2;
    private javax.swing.JLabel RSpr2_1ID;
    private javax.swing.JLabel RSpr2_1image;
    private javax.swing.JLabel RSpr2_2ID;
    private javax.swing.JLabel RSpr2_2image;
    private javax.swing.JLabel RSpr2_3ID;
    private javax.swing.JLabel RSpr2_3image;
    private javax.swing.JLabel RSpr2_4ID;
    private javax.swing.JLabel RSpr2_4image;
    private javax.swing.JTextArea RSpr3;
    private javax.swing.JLabel RSpr3_1ID;
    private javax.swing.JLabel RSpr3_1image;
    private javax.swing.JLabel RSpr3_2ID;
    private javax.swing.JLabel RSpr3_2image;
    private javax.swing.JLabel RSpr3_3ID;
    private javax.swing.JLabel RSpr3_3image;
    private javax.swing.JLabel RSpr3_4ID;
    private javax.swing.JLabel RSpr3_4image;
    private javax.swing.JButton TimeButton;
    private javax.swing.JTextField TimeField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel statusIA;
    // End of variables declaration//GEN-END:variables
}
