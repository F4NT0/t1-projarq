package ecommerce2.servidor;

import java.util.ArrayList;


public class ListaEcommercesObserver {
    private ArrayList<Ecommerce> ecommerces;

    public ListaEcommercesObserver(){

        ecommerces = new ArrayList<Ecommerce>();
    }

    public void update(Ecommerce ec, Pedido p){
        //quando notificado de que houve alteracoes no banco de um ecommerce, adiciona esta modificacao na lista
        for(Ecommerce e:ecommerces){
            if(e.getNomeEcommerce().equalsIgnoreCase(ec.getNomeEcommerce())){
                e.getPedidos().add(p);
            }
        }
    }

    public ArrayList<Ecommerce> getLista(){
        return ecommerces;
    }

    public void addEcommerce(Ecommerce e){
        ecommerces.add(e);
    }

    public void removeEcommerce(Ecommerce e){
        ecommerces.remove(e);
    }

    @Override
    public String toString(){
        String ret = "Ecommerces cadastrados: \n";
        for(Ecommerce e:ecommerces) ret += e+"\n";
        return ret;
    }
}