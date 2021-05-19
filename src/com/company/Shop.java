package com.company;

import java.util.Scanner;

public class Shop {
    private String name;
    private String address;
    private int countOfProduct;
    private double priceOfProduct;
    private double shopBalance;

    public Shop(String name, String address, int countOfProduct, double priceOfProduct, double shopBalance) {
        setName(name);
        setAddress(address);
        setCountOfProduct(countOfProduct);
        setPriceOfProduct(priceOfProduct);
        setShopBalance(shopBalance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public double getShopBalance() {
        return shopBalance;
    }

    public void setShopBalance(double shopBalance) {
        this.shopBalance = shopBalance;
    }

    public void acceptOrder() {
        int press = checkOrder();
        if (press == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Count of product which you want to buy: ");
            int chooseCountOfProduct = scanner.nextInt();
            if (chooseCountOfProduct <= countOfProduct) {
                System.out.println("Your old shop balance: " + shopBalance);
                double orderPrice = calculateOrder(priceOfProduct, chooseCountOfProduct);
                System.out.println("Order price: " + orderPrice);
                double totalBalance = addToShopBalance(shopBalance, orderPrice);
                System.out.println("Total balance: " + totalBalance);
            } else System.out.println("Now we do not have so much product: ");
        }
    }

    private int checkOrder() {
        System.out.print("If you want to buy press 1, if you do not want to buy press any bottom: ");
        Scanner scanner = new Scanner(System.in);
        int press = scanner.nextInt();
        return press;
    }

    private double calculateOrder(double priceOfProduct, int chooseCountOfProduct) {
        double orderPrice = 0;
        orderPrice = orderPrice + (priceOfProduct * chooseCountOfProduct);
        return orderPrice;
    }

    private double addToShopBalance(double shopBalance, double orderPrice) {
        shopBalance += orderPrice;
        return shopBalance;
    }
}
