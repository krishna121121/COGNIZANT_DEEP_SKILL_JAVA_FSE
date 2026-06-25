package DesignPatternsandPrinciples;

import java.util.*;

interface Observer {
    void update(double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: " + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App: " + price);
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        market.registerObserver(new MobileApp());
        market.registerObserver(new WebApp());

        market.setPrice(500);
    }
}