/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package currencyexchange;

/**
 *
 * @author Quan Nguyen
 */
public class CurrencyUnit {
    private String countryCurrency;
    private String currencyUnit;
    
    public CurrencyUnit(String countryCurrency, String unit) {
        this.countryCurrency = countryCurrency;
        this.currencyUnit = unit;
    }
    
    public String getCountryCurrency() {
        return countryCurrency;
    }
    
    public String getCurrencyUnit(){
        return currencyUnit;
    }
    
    @Override
    public String toString(){
        return currencyUnit + "-" + countryCurrency;
    }
}
