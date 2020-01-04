package org.chenxh.designPattern.observer;

import java.util.List;

public class Subject implements Observerable{
    private List<Observer> observerList;

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void registerObserver(Observer observer) {
        this.getObserverList().add(observer);
    }

    public void removeObserver(Observer observer) {
        this.getObserverList().remove(observer);
    }

    public void notifyObserver() {
        for (Observer observer:this.getObserverList()) {
            observer.update(this);
        }
    }
}
