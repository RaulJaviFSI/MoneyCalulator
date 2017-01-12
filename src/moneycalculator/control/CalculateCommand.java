package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.MoneyDialogFrom;
import moneycalculator.ui.MoneyDialogTo;


public class CalculateCommand implements Command {

    private final MoneyDialogFrom  moneyDialog;
    private final MoneyDialogTo moneyDialogto;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader loader;   

    public CalculateCommand(MoneyDialogFrom moneyDialog, MoneyDisplay moneyDisplay, MoneyDialogTo moneyDialogto, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.moneyDialogto = moneyDialogto;
        this.moneyDisplay = moneyDisplay;
        this.loader = loader;
    }

    @Override
    public String name() {
        return "Calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(exchange(moneyDialog.get()));
    }

    private Money exchange(Money money) {
        return new Money(money.getAmount() * rateOf(money.getCurrency()), moneyDialogto.get());
    }

    private double rateOf(Currency currency) {
        return loader.load(currency, moneyDialogto.get()).getAmuont();
    }

}
