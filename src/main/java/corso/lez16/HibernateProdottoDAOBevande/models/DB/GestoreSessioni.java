package corso.lez16.HibernateProdottoDAOBevande.models.DB;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import corso.lez16.HibernateProdottoDAOBevande.models.Bevanda;

public class GestoreSessioni {

	private static GestoreSessioni ogg_gestore;
	private SessionFactory factory;

	public static GestoreSessioni getInstance() {
		if (ogg_gestore == null) {
			ogg_gestore = new GestoreSessioni();
		}

		return ogg_gestore;
	}
	
	public SessionFactory getFactory() {
		if(factory == null) {
			factory = new Configuration()
					.configure("/resources/hibernate_bevande.cfg.xml")
					.addAnnotatedClass(Bevanda.class)
					.buildSessionFactory();
		}
		
		return factory;
	}
}

