package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.control.Command;
import moneycalculator.model.Currency;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDialogFrom;
import moneycalculator.ui.swing.SwingMoneyDialogTo;
import moneycalculator.ui.swing.SwingMoneyDisplay;
import moneycalculator.ui.MoneyDialogFrom;
import moneycalculator.ui.MoneyDialogTo;


class Mainframe extends JFrame{

    private final Currency[] currencies;
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDialogFrom moneyDialogFrom;
    private MoneyDisplay moneyDisplay;
    private MoneyDialogTo moneyDialogTo;
    
    public Mainframe(Currency[] currencies) {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialogFrom(), BorderLayout.NORTH);
        this.add(moneyDialogTo(), BorderLayout.EAST);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void add(Command command){
        commands.put(command.name(), command);
    }
    
    public MoneyDialogTo getMoneyDialogTo() {
        return moneyDialogTo;
    }

    public MoneyDialogFrom getMoneyDialogFrom() {
        return moneyDialogFrom;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    
    private Component moneyDialogFrom() {
        SwingMoneyDialogFrom dialog = new SwingMoneyDialogFrom(currencies);
        moneyDialogFrom = dialog;
        return dialog;
    }
    
    private Component moneyDialogTo() {
        SwingMoneyDialogTo to = new SwingMoneyDialogTo(currencies);
        moneyDialogTo = to;
        return to;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        moneyDisplay = display;
        return display;
    }
    public SwingMoneyDisplay display;
    
    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }

    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
    }

}
