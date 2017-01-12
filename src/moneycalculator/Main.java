package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.files.FileCurrencyListLoader;
import moneycalculator.persistence.rest.RestExchangeRateLoader;

public class Main {

    public static void main(String[] args) {
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        
        Mainframe mainframe = new Mainframe(currencyLoader.currencies());
        mainframe.add(new CalculateCommand(mainframe.getMoneyDialogFrom(), mainframe.getMoneyDisplay(),mainframe.getMoneyDialogTo(),exchangeRateLoader));
    }    
}
