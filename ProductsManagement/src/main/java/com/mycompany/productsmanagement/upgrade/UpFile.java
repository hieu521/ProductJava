/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsmanagement.upgrade;

import com.mycompany.productsmanagement.model.Product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author phong
 */
public class UpFile {
    // Read file
    public static Object readObj(String path) throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ) {
            Object obj = objectInputStream.readObject();
            return obj;
        }
    }
    
    // Write File
    public static void writeObject(String path, Object object) throws IOException {
        try (    
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        )
        {
           objectOutputStream.writeObject(object);
        }
    }

}
