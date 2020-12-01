package ecommerce2.servidor;

// Import
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Database {
    //Atributos
    private ArrayList<String> ecommerces = new ArrayList<String>();

    public Database(){}

    public void addEcommercesToDatabase(){
        try{
            PrintWriter writer = new PrintWriter("database/ecommerce.txt","utf-8");
            for(String values : ecommerces){
                writer.println(values);
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean addEcommerceToList(Ecommerce eco){
        String data = "id:" + eco.getIdEcommerce() + "-" + "nome:" + eco.getNomeEcommerce();
        ecommerces.add(data);
        addEcommercesToDatabase();
        return true;
    }

    public void watchEcommerceList(){
        for(String values : ecommerces){
            System.out.println("Ecommerce: " + values);
        }
    }

    public static void main(String[] args){
        Database database = new Database();
        Ecommerce eco = new Ecommerce(1,"Pepe");
        Ecommerce eco2 = new Ecommerce(2,"Lolo");
        Ecommerce eco3 = new Ecommerce(3,"Lala");
        Ecommerce eco4 = new Ecommerce(3,"Lala");
        database.addEcommerceToList(eco);
        database.addEcommerceToList(eco2);
        database.addEcommerceToList(eco3);
        database.addEcommerceToList(eco4);
        database.addEcommercesToDatabase();
    }
}