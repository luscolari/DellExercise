package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class InterfaceList {

    private final JDialog dialog;
    private JTable teamTable;
    private final List<Team> teams;
    private final App app;

    public InterfaceList(JFrame parentFrame, List<Team> teams, App app) {
        this.teams = teams;
        this.app = app;

        dialog = new JDialog(parentFrame, "List of Teams", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(new Dimension(600, 400));
        dialog.setLocationRelativeTo(parentFrame);

        // Create table model
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Name");
        columnNames.add("Scream");
        columnNames.add("Founded Year");

        // Create table data
        Vector<Vector<Object>> data = new Vector<>();
        for (Team team : teams) {
            Vector<Object> row = new Vector<>();
            row.add(team.getName());
            row.add(team.getScream());
            row.add(team.getFounded());
            data.add(row);
        }

        // Create table and add to scroll pane
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        teamTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(teamTable);
        dialog.add(scrollPane, BorderLayout.CENTER);

        // Add buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton deleteButton = new JButton("Delete Team");
        JButton closeButton = new JButton("Close");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTeam();
            }
        });

        closeButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(deleteButton);
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void deleteTeam() {
        int selectedRow = teamTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(dialog, "Please select a team to delete.");
            return;
        }

        String name = (String) teamTable.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(dialog, "Confirm deletion of team " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            app.removeTeam(name);
            refreshTable();
        }
    }

    private void refreshTable() {
        // Get updated list of teams from the app
        List<Team> updatedTeams = app.listTeams();
        Vector<Vector<Object>> data = new Vector<>();
        for (Team team : updatedTeams) {
            Vector<Object> row = new Vector<>();
            row.add(team.getName());
            row.add(team.getScream());
            row.add(team.getFounded());
            data.add(row);
        }

        // Update table model
        DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
        model.setDataVector(data, new Vector<>(List.of("Name", "Scream", "Founded Year")));
    }

    public void show() {
        dialog.setVisible(true);
    }
}
