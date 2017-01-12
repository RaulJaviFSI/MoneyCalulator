
package moneycalculator.ui.swing;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.ui.MoneyDialogTo;


public class SwingMoneyDialogTo extends JPanel implements MoneyDialogTo{

    private Currency currency;
    private final Currency[] currencies;
        
    public SwingMoneyDialogTo(Currency[] currencies) {
        this.currencies = currencies;
        this.add(currency());
    }
    
    

    private Component currency() {
        JComboBox combo = new JComboBox(currencies);
        combo.addItemListener(currencyChanged());
        currency = (Currency) combo.getSelectedItem();
        return combo;
    }

   
    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED)return;
                currency = (Currency) e. getItem();
            }
        };
    }

    @Override
    public Currency get() {
        return currency;
    }

}
