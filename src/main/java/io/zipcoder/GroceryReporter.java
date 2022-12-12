package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.List;

public class GroceryReporter {
    private final String originalFileText;

    ItemParser parser = new ItemParser();

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        //System.out.println(parser.parseItemList(originalFileText));
          List<Item> list = parser.parseItemList(originalFileText);
          for (Item i :list) {
              System.out.println(i);
          }

          //        System.out.println(parser.parseItemList(originalFileText).size());

        return null;
    }
}
