package ecommerce2.servidor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ListaEcommerces implements Observer{
    private static ArrayList<Ecommerce> ecommerces;

    public ListaEcommerces(){
        ecommerces = new ArrayList<Ecommerce>();
    }

    @Override
    public void update(Observable o, Object arg){
        //quando notificado de que houve alteracoes no banco de um ecommerce, adiciona esta modificacao na lista
        for(Ecommerce e:ecommerces){
            if(e.getNomeEcommerce().equalsIgnoreCase(o.getNomeEcommerce())){
                o.getPedidos().add(arg);
            }
        }
    }

    public ArrayList<Ecommerce> getLista(){
        return this.ecommerces;
    }

    public void addEcommerce(Ecommerce e){
        this.ecommerces.add(e);
    }

    public void removeEcommerce(Ecommerce e){
        this.ecommerces.remove(e);
    }

    @Override
    public String toString(){
        String ret = "Ecommerces cadastrados: \n";
        for(Ecommerce e:ecommerces) ret += e+"\n";
        return ret;
    }
}