/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package currencyexchange;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.io.Serializable;
import java.lang.String;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CurrencyRate has a hash table that contain list
 * of available currency rates
 * the key for the hash is a pair of currency unit String (from,to)
 * and the value is going to be the rate
 * the values in hash table is updated via RSS Feed
 * 
 * @author Quan Nguyen
 */
public class CurrencyRate{
    private HashMap<String, Double> rates;
    private CurrencyUnit[] currencies;
    private String filePath;
    
    public CurrencyRate(String filePath, CurrencyUnit[] currencies){
        this.filePath = filePath;
        this.currencies = currencies;
        this.rates = new HashMap<String, Double>();
        
        File f = new File(filePath);
        
        if (f.exists()) {
            //inflate the file
            try{
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
                this.rates = (HashMap<String, Double>) is.readObject();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        } else {
            //create a new table out of scratch
            for (int i = 0; i < currencies.length; i++) {
                for (int j = 0; j < currencies.length; j++){
                    String rateTitle = currencies[j].getCurrencyUnit() + "/" + currencies[i].getCurrencyUnit();
                    rates.put(rateTitle,0.0);
                }
            }
            
            updateTable();
            
            //save file
            try {
            //write to a file for later use
                f.createNewFile();
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f, false));
                os.writeObject(rates);
                os.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
            
        }
    }
    
    public double getRate(CurrencyUnit from, CurrencyUnit to){
        double rate;
        String ratePair = to.getCurrencyUnit() + "/" + from.getCurrencyUnit();
        updateSingleRate(from, to);
        rate = rates.get(ratePair);
        return rate;
    }
    
    /**
     * update via RSS feed
    */
    public void updateSingleRate(CurrencyUnit from, CurrencyUnit to) {
        String URLString = "http://http://themoneyconverter.com/rss-feed/";
        String fromCurrency = from.getCurrencyUnit();
        SyndFeed feed = null;
        String convertTitle = to.getCountryCurrency() + "/" + from.getCountryCurrency();
        double rate = 0;
        
        try {
            URL feedURL = new URL(URLString + fromCurrency + "/rss.xml");
            
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(new XmlReader(feedURL));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if(feed != null) {
            Iterator it = feed.getEntries().iterator();
            boolean found = false;
            SyndEntry entry = null;
            while (it.hasNext() || !found){
                entry = (SyndEntry)it.next();
                String title = entry.getTitle();
                if (title == convertTitle) {
                    found = true;
                }
            }
            
            Pattern p = Pattern.compile("[0-9]*\\.[0-9]+");
            Matcher m = p.matcher(entry.getDescription().getValue());
            while (m.find())
                rate = Double.parseDouble(m.group());
            
        }
        
        rates.put(convertTitle, rate);
    }
    
    public void updateTable(){
         String URLString = "http://themoneyconverter.com/rss-feed/";
         
         for (int i = 0; i < currencies.length; i++){
             String unit = currencies[i].getCurrencyUnit();
             SyndFeed feed = null;
             try {
                 URL feedURL = new URL(URLString + unit + "/rss.xml");
                 SyndFeedInput input = new SyndFeedInput();
                 feed = input.build(new XmlReader(feedURL));
             } catch (Exception ex){
                 ex.printStackTrace();
             }
             
             if (feed != null){
                 List<SyndEntry> list = (List<SyndEntry>) feed.getEntries();
                 
                 for (SyndEntry entry : list){
                     String title = entry.getTitle();
                     String descr = entry.getDescription().getValue();
                     
                     Pattern p = Pattern.compile("[0-9]*\\.[0-9]+");
                     Matcher m = p.matcher(descr);
                     
                     double rate = 0;
                     while (m.find())
                         rate = Double.parseDouble(m.group());
                     rates.put(title, rate);
                 }
             }
         }
    }
    
    public void saveTable() {
        File f = new File(filePath);
        try {
            f.createNewFile();
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f, false));
            os.writeObject(rates);
            os.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}