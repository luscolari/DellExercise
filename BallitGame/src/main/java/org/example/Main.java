package org.example;

import org.example.App;
import org.example.Register;
import org.example.Team;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    App app = new App();
    JFrame menu;

    public void menu() {
        start();
        menu = new JFrame();

        ImageIcon icon = new ImageIcon("src/main/resources/logo.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        menu.setIconImage(newimg);

        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setMinimumSize(new Dimension(500, 500));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER));

        JScrollPane panel2 = introPane();

        JPanel panel1 = getPanel1();

        Container container = menu.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(panel2);
        container.add(Box.createVerticalStrut(10));
        container.add(panel1);
        container.add(Box.createVerticalStrut(10));

        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private JPanel getPanel1() {
        JPanel panel1 = new JPanel(new GridLayout(2, 2, 10, 10));
        panel1.setMaximumSize(new Dimension(350, 80));
        JButton teams = new JButton("Register Teams");
        JButton championship = new JButton("Start a Championship");
        JButton list = new JButton("List Teams");

        teams.addActionListener(e -> team());

        championship.addActionListener(e -> startChampionship());

        list.addActionListener(e -> listTeams());
        panel1.add(teams);
        panel1.add(championship);
        panel1.add(list);
        return panel1;
    }

    public JScrollPane introPane() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        ImageIcon originalIcon = new ImageIcon("src/main/resources/logo.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextArea intro = new JTextArea("""
                Welcome to BallIt 2.0, the best App to help in your BallIT's Championships!

                An App desenvolvido by
                Luísa Scolari""");
        intro.setMargin(new Insets(10, 10, 10, 10));
        intro.setAlignmentX(Component.CENTER_ALIGNMENT);
        intro.setEditable(false);
        intro.setLineWrap(true);
        intro.setWrapStyleWord(true);
        intro.setBackground(new Color(238, 238, 238));
        panel1.add(imageLabel);
        panel1.add(Box.createRigidArea(new Dimension(0, 10)));
        panel1.add(intro);
        panel1.add(Box.createRigidArea(new Dimension(0, 10)));

        JScrollPane teste = new JScrollPane(panel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        teste.setPreferredSize(new Dimension(400, 500));
        return teste;
    }

    public void start() {
        app.starting();
    }

    public void team() {
        JFrame frame = new JFrame("Register Team");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel screamLabel = new JLabel("Scream:");
        JTextField screamField = new JTextField();

        JLabel foundedLabel = new JLabel("Founded Year:");
        JTextField foundedField = new JTextField();

        JButton addButton = new JButton("Add Team");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String scream = screamField.getText();
            int founded = Integer.parseInt(foundedField.getText());
            app.addTeam(name, scream, founded);
            JOptionPane.showMessageDialog(frame, "Team added successfully!");
            frame.dispose();
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(screamLabel);
        frame.add(screamField);
        frame.add(foundedLabel);
        frame.add(foundedField);
        frame.add(addButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void startChampionship() {
        try {
            Team winner = app.startChampionship();
            JOptionPane.showMessageDialog(menu, "The Winner of the Championship is: " + winner.getName());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(menu, e.getMessage());
        }
    }

    public void listTeams() {
        List<Team> teams = app.listTeams();
        if (teams.isEmpty()) {
            JOptionPane.showMessageDialog(menu, "No teams registered.");
        } else {
            InterfaceList listUI = new InterfaceList(menu, teams, app);
            listUI.show();
        }
    }

    public void exit(JFrame frame) {
        frame.dispose();
        menu.setVisible(false);
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.menu();
    }
}
