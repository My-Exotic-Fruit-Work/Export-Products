package org.example;

import com.google.gson.JsonObject;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

public class ExportProducts {
  public static void exportAllProducts(boolean suggested) {
    Map<String, JsonObject> products = RequestItems.getProducts();
    ArrayList<Map<String, String>> ekmProductMaps = MapProducts.getProductMaps(products, suggested);

    Path outputPath = Path.of("./products.csv");
    CsvWriter.writeCsv(outputPath, ekmProductMaps);
    System.out.println("Successfully wrote to " + outputPath);
  }
}