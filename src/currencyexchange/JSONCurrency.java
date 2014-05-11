/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package currencyexchange;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Quan Nguyen
 */
public class JSONCurrency {
    private static final String filePath = "./res/currencyUnits.json";
    
    public static ArrayList<CurrencyUnit> getCurrencyUnitsJSON() {
        try {
            FileReader reader = new FileReader(filePath);
            
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            
            JSONArray currencyUnits = (JSONArray) jsonObject.get("units");
            
            ArrayList<CurrencyUnit> currencies = new ArrayList<CurrencyUnit>();
            
            Iterator i = currencyUnits.iterator();
            while (i.hasNext()){
                JSONObject e = (JSONObject)i.next();
                CurrencyUnit currency = new CurrencyUnit((String)e.get("CountryCurrency"), 
                                                         (String)e.get("Units"));
                
                currencies.add(currency);
            }
            return currencies;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException | NullPointerException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
