package corso.lez16.HibernateProdottoDAOBevande.crud;

import java.util.List;

import org.hibernate.Session;

import corso.lez16.HibernateProdottoDAOBevande.models.Bevanda;
import corso.lez16.HibernateProdottoDAOBevande.models.DB.GestoreSessioni;

public class BevandaDAO implements Dao<Bevanda> {

	@Override
	public void insert(Bevanda t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		
	}

	@Override
	public Bevanda findById(int id) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			Bevanda temp = sessione.get(Bevanda.class, id);
			sessione.getTransaction().commit();;
			return temp;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			
		}
		
		return null;
	}

	@Override
	public List<Bevanda> findAll() {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			List<Bevanda> elenco = sessione.createQuery("FROM Bevanda").list();
			sessione.getTransaction().commit();;
			return elenco;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			Bevanda temp = sessione.load(Bevanda.class, id);
			sessione.delete(temp);
			sessione.getTransaction().commit();;
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		return false;
	}

	@Override
	public boolean delete(Bevanda t) {

		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			sessione.delete(t);
			sessione.getTransaction().commit();;
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			sessione.close();
		}
		
		return false;
	}

	@Override
	public boolean update(Bevanda t) {
		
		Session sessione = GestoreSessioni.getInstance().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			sessione.update(t);
			sessione.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return false;
	}

}
