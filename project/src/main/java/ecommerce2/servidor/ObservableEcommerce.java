package ecommerce2.servidor;

import java.util.ArrayList;

public class ObservableEcommerce {
    private ArrayList<ListaEcommercesObserver> observers;

    public ObservableEcommerce(){
        observers = new ArrayList<ListaEcommercesObserver>();
    }

    public void notifyObservers(Ecommerce e, Pedido p){
        for(ListaEcommercesObserver observer:observers) {observer.update(e, p);}
    }

    public void addObserver(ListaEcommercesObserver e){
        observers.add(e);
    }
}
