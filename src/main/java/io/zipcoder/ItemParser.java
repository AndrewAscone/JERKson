package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse){
        List<Item> parsedList = new ArrayList<>();
        int exceptionCount = 0;

        String[] parsed = valueToParse.toLowerCase().split("##");
        //System.out.println(Arrays.toString(parsed));

        for(String s : parsed){
            try{
                parsedList.add(parseSingleItem(s));
            } catch (ItemParseException e) {
                exceptionCount++;
                System.out.println("Exception handled. Exception count is now: " + exceptionCount);
            }
        }
        System.out.println(parsedList);
        return parsedList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String[] parsed = singleItem.toLowerCase().split("[:;^%*!@#]");
        //System.out.println(Arrays.toString(parsed));
        if(parsed.length != 8 || Objects.equals(parsed[1], "")){
            //System.out.println("Parsed item has improper length!");
           throw new ItemParseException();
        }
        else {
            double priceValue;
            try{
                priceValue = Double.parseDouble(parsed[3]);
            }catch(NumberFormatException e){throw new ItemParseException();}
            return new Item(parsed[1], priceValue, parsed[5], parsed[7]);
        }
    }
}


/*
Regex to match a line sequence that follows the proper key:value pattern
([nameNAME])\w+\:([a-zA-z])\w+\;([pricePRICE]\w+)\:(\d\.\d{2})\;([typeTYPE]\w+)\:([a-zA-Z]\w+)[;^%*!@]([expirationEXPIRATION]\w+)\:(\d\/\d{2}\/\d{4})\#{2}
*/
