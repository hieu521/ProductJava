/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsmanagement.upgrade;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author phong
 */
public class Validator {

    // checking name when user input
    public static boolean checkName(JTextField feild, StringBuilder stringBuilder) {
        // create variable validata for update status
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Name is not empty!")) {
            return false;
        }

        try {
            String name = feild.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(name);
            boolean isSpecial = matcher.find();

            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    stringBuilder.append("Name does not contain number!");
                    feild.setForeground(Color.red);
                    break;
                }
            }
            // for special characters
            if (isSpecial) {
                stringBuilder.append("Name does not contain special characters!");
                feild.setForeground(Color.red);
            }

            if (name.startsWith(" ") || name.endsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }

        } catch (Exception e) {
            stringBuilder.append("Name must be a string!");
            feild.setForeground(new Color(204, 0, 0, 21));
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking ID when user input
    public static boolean checkId(JTextField feild, StringBuilder stringBuilder, String message) {
        // create variable validata for update status
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Id is not empty!")) {
            return false;
        }

        try {
            String ID = feild.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(ID);
            boolean isSpecial = matcher.find();
            // for special characters

            if (ID.startsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }

            if (ID.startsWith(" ") || ID.endsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }

        } catch (Exception e) {
            stringBuilder.append("ID must be a string or number!");
            feild.setForeground(new Color(204, 0, 0, 21));
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking Quanitty when user input
    public static boolean checkQuantity(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Quanity is not empty!")) {
            return false;
        }

        try {
            int quantity = Integer.parseInt(feild.getText());

            if (quantity <= 0) {
                stringBuilder.append("The quantity can not smaller than 1!");
                feild.setForeground(Color.red);
                isValidate = false;
            }

        } catch (Exception e) {
            stringBuilder.append("The value of quanity must be a number!");
            feild.setForeground(Color.red);
            System.out.println("Quanity error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking Description when user input
    public static boolean checkDescription(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Description is not empty!")) {
            feild.setForeground(Color.red);
            return false;
        }

        try {
            String description = feild.getText();

            if (description.startsWith(" ") || description.endsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }

        } catch (Exception e) {
            stringBuilder.append("Description is not empty");
            feild.setForeground(Color.red);
            System.out.println("Description error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking cetegory when user input
    public static boolean checkCategory(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Category is not empty!")) {
            return false;
        }

        try {
            String category = feild.getText();
            feild.setBackground(new Color(204, 0, 0, 21));
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(category);
            boolean isSpecial = matcher.find();

            if (category.startsWith(" ") || category.endsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }

            char[] chars = category.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    stringBuilder.append("Category does not contain number!\n");
                    feild.setForeground(Color.red);
                    break;
                }
            }

            // for special characters
            if (isSpecial) {
                stringBuilder.append("Category does not contain special characters!\n");
            }

        } catch (Exception e) {
            stringBuilder.append("The value of category must be a string!");
            feild.setForeground(Color.red);
            System.out.println("Category error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking shop when user input
    public static boolean checkShop(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Shop is not empty!")) {
            feild.setForeground(Color.red);
            return false;
        }

        try {
            String category = feild.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(category);
            boolean isSpecial = matcher.find();

            // for special characters
            if (isSpecial) {
                stringBuilder.append("Shop does not contain special characters!\n");
                feild.setForeground(Color.red);
            }

            if (category.startsWith(" ") || category.endsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }

        } catch (Exception e) {
            stringBuilder.append("Shop must be a string!");
            System.out.println("Category error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // checking production when user input
    public static boolean checkProductionDate(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        formatter.setLenient(false);

        if (!checkEmpty(feild, stringBuilder, "Production date is not empty!")) {
            return false;
        }

        try {
            String productionDate = feild.getText();
            Date checkDate = formatter.parse(productionDate);
            Pattern pattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(productionDate);
            boolean isSpecial = matcher.find();
            char[] chars = productionDate.toCharArray();
            for (char c : chars) {
                if (Character.isLetter(c)) {
                    stringBuilder.append("Production date does not contain text!\n");
                    feild.setForeground(Color.red);
                    break;
                }
            }

            if (productionDate.endsWith("/")) {
                stringBuilder.append("Production date does not contain character!\n");
                feild.setForeground(Color.red);
            }

            if (isSpecial) {
                stringBuilder.append("Production date does not contain character!\n");
                feild.setForeground(Color.red);
            }

            if (productionDate.startsWith(" ") || productionDate.endsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setForeground(Color.red);
            }



        } catch (Exception e) {
            stringBuilder.append("Date type format error!");
            feild.setForeground(Color.red);
            System.out.println("Date type format error!: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    // check price
    public static boolean checkProductPrice(JTextField feild, StringBuilder stringBuilder) {
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Price is not empty!")) {
            feild.setForeground(Color.red);
            return false;
        }

        try {
            double price = Double.parseDouble(feild.getText());


        } catch (Exception e) {
            stringBuilder.append("Price must be a number!");
            feild.setForeground(Color.red);
            System.out.println("Production date error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }


        return isValidate;
    }

    // checking empty when user input
    public static boolean checkEmpty(JTextField feild, StringBuilder stringBuilder, String message) {
        boolean isValidate = true;
        if (feild.getText().equals("")) {
            stringBuilder.append(message).append("\n");
            feild.setForeground(Color.red);
            isValidate = false;
        } else {
            feild.setBackground(Color.white);
        }
        return isValidate;
    }

    public void checkIsCorrect(JTextField feild, StringBuilder stringBuilder, String message) {
        if (!feild.getText().isBlank()) {
            feild.setBackground(new Color(255, 255, 255, 255));
        }
    }

}
