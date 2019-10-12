package org.chenxh.designPattern.observer;

public interface Observerable {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();

}
