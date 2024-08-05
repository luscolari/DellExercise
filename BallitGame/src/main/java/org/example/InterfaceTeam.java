package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceTeam {

        private JTextField txtName;
        private JButton saveButton;
        private JButton cancelButton;
        private JTextField txtScream;
        private JTextField txtyear;
        private JPanel panelTeam;
        private Register registration;
        private final JDialog windowTeams;

        public InterfaceTeam(Register registration, JFrame janelaPrincipal) {
           this.registration = registration;
            windowTeams = new JDialog(janelaPrincipal, "Register Team", true);
            windowTeams.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            // Define o tamanho mínimo da janela
            this.windowTeams.setMinimumSize(new Dimension(500, 300));
            this.windowTeams.setLayout(new BorderLayout());
            this.windowTeams.add(panelTeam);


            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nameText = txtName.getText();
                    String screamText = txtScream.getText();
                    try {
                        int year = Integer.parseInt(txtyear.getText());
                        Team team = new Team(nameText, screamText, year);
                        registration.addTeams(team);

                        // Depois de salvar o vagão, fecha a janela
                        windowTeams.setVisible(false);

                        JOptionPane.showMessageDialog(windowTeams, "Team added successfully!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Year must be an integer");
                    } catch (RuntimeException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });

            cancelButton.addActionListener(new

                                                     ActionListener() {
                                                         @Override
                                                         public void actionPerformed (ActionEvent e){
                                                             System.out.println("Saindo...");
                                                             windowTeams.setVisible(false);
                                                         }
                                                     });
        }

        public void show () {
            windowTeams.pack();
            windowTeams.setVisible(true);
        }
    }




