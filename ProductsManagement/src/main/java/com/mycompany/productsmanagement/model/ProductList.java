/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsmanagement.model;

import com.mycompany.productsmanagement.upgrade.UpFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phong
 */
public class ProductList extends Product {

    // where product being save
    private ArrayList<Product> list = new ArrayList<>();
    private int currentIndex = 0;
    private final String pathFile = "E:\\data\\data.txt";
    

    public void saveToFile() throws IOException {
        UpFile.writeObject(pathFile, list);
    }

    public void loadFormFile() throws IOException,
            ClassNotFoundException {
        File file = new File(pathFile);

        if (!file.exists()) {
            initProductData();
        } else {
            list = (ArrayList<Product>) UpFile.readObj(pathFile);
        }
    }

    // init value for table
    private void initProductData() {
        list.add(new Product("201WM", "Mouse", "DPI 800", "2022/12/03", "Paika", "Technical", 1, 99));
        list.add(new Product("202NA", "Keyboard", "example", "2022/03/16", "Sherwin", "Technical", 2, 29));
        list.add(new Product("203AM", "Screen", "example", "2022/09/12", "Universe", "Technical", 3, 32));
        list.add(new Product("204MB", "Adapter", "example", "2022/01/29", "Phong", "Technical", 4, 74.5));
    }

    public void moveToFirst() {
        if (currentIndex > 0) {
            currentIndex = 0;
        }
    }

    public void moveToLast() {
        currentIndex = list.size() - 1;
    }

    public void moveToPrevious() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public void moveToNext() {
        if (currentIndex < list.size() - 1) {
            currentIndex++;
        }
    }

    public int getCurrentProductIndex() {
        return currentIndex;
    }

    public Product getCurrentProduct() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(currentIndex);
    }

    // change stutus of list when moving page
    public String getCurrentProductStatus() {
        return "Record " + (currentIndex + 1) + " / " + list.size();
    }

    // change positon of product when naviagtion element
    public void setCurrentProductToRow(Product product) {
        currentIndex = list.indexOf(product);
    }

    // add product
    public void add(Product product) {
        list.add(product);
    }

    // search product by it's ID
    public Product searchById(String productId) {
        for (Product product : list) {
            if (product.getProductId().replaceAll(" ", "").toLowerCase().
                    equalsIgnoreCase(productId.replaceAll(" ", "").toLowerCase())) {
                return product;
            }
        }
        return null;
    }

    // update product by it's ID
    public boolean updateProduct(Product product) {
        Product productInList = searchById(product.getProductId().replaceAll(" ", "").toLowerCase());
        boolean status = false;
        if (productInList == null) {
            return status;
        }
        productInList.setName(product.getName());
        productInList.setDescription(product.getDescription());
        productInList.setProductionDate(product.getProductionDate());
        productInList.setQuantity(product.getQuantity());
        productInList.setCategory(product.getCategory());
        productInList.setShop(product.getShop());
        productInList.setPrice(product.getPrice());
        return true;
    }

    // render or flush data to table to save changes
    public void renderToTable(DefaultTableModel tblModel) {
        tblModel.setRowCount(0);

        for (Product product : list) {
            // each object of Product will create a row
            Object[] row = new Object[]{
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getProductionDate(),
                product.getCategory(),
                product.getShop(),
                product.getPrice()
            };

            tblModel.addRow(row);
        }

        tblModel.fireTableDataChanged();
    }

    // delete product by it's ID
    public boolean delete(String productId) {
        for (Product product : list) {
            if (product.getProductId().trim().toLowerCase().equals(productId)) {
                list.remove(product);
                return true;
            }
        }
        return false;
    }

}
