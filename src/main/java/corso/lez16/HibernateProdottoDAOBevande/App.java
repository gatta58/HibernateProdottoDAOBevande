package corso.lez16.HibernateProdottoDAOBevande;

import java.util.List;

import corso.lez16.HibernateProdottoDAOBevande.crud.BevandaDAO;
import corso.lez16.HibernateProdottoDAOBevande.models.Bevanda;

public class App 
{
    public static void main( String[] args )
    {

    	BevandaDAO bevDao = new BevandaDAO();
    	
    	//insert
    	
    	Bevanda bev1 = new Bevanda ("CC001", "CocaCola",150.0f);
    	Bevanda bev2 = new Bevanda ("PC002", "PepsiCola",500.0f);
    	Bevanda bev3 = new Bevanda ("AM003", "Acqua Minerale",1500.0f);
    	Bevanda bev4 = new Bevanda ("FA004", "Fanta",500.0f);
    	
    	System.out.println("\n Insert ------------------------------");
    	bevDao.insert(bev1);
    	bevDao.insert(bev2);
    	bevDao.insert(bev3);
    	bevDao.insert(bev4);
    	
    	// FindByID
    	System.out.println("\n FindByID ------------------------------");
    	Bevanda temp = bevDao.findById(2);
    	System.out.println(temp.toString());
    	
    	// FindAll
    	System.out.println("\n FindAll ------------------------------");
    	List<Bevanda> elenco = bevDao.findAll();
    	for(int i = 0; i < elenco.size(); i++) {
    		Bevanda tlist = elenco.get(i);
    		System.out.println(tlist.toString());
    	}
    	
    	// Delete con id
    	System.out.println("\n Delete by ID ------------------------------");
    	if(bevDao.delete(1)) {
    		System.out.println("Eliminazione Bevanda 1 effettuata");
    	}
    	else {
    		System.out.println("Errore in eliminazione del id  1");
    	}
    	
    	// Delete bevanda
    	System.out.println("\n Delete Bevanda ------------------------------");
    	Bevanda bevt = bevDao.findById(3);
    	if(bevDao.delete(bevt)) {
    		System.out.println("Eliminazione Bevanda 3 effettuata");
    	}
    	else {
    		System.out.println("Errore in eliminazione del id  3");
    	}
    	
    	// Update
    	System.out.println("\n Update ------------------------------");
    	Bevanda due = bevDao.findById(2);
    	due.setCodice("PCMMM");
    	due.setNome("Bevanda Verde");
    	due.setVolume(1250.0f);
    	if (bevDao.update(due)) {
    		System.out.println("Update realizzato");
    		System.out.println(due.toString());
    	}
    	else {
    		System.out.println("Errore nell'update");
    	}
    	
    	// FindAll
    	System.out.println("\n FindAll ------------------------------");
    	elenco = bevDao.findAll();
    	for(int i = 0; i < elenco.size(); i++) {
    		Bevanda tlist = elenco.get(i);
    		System.out.println(tlist.toString());
    	}
    	
    }
}
