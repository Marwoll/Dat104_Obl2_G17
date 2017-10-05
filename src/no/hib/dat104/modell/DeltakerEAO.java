package no.hib.dat104.modell;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import no.hib.dat104.modell.Deltaker;

@Stateless
public class DeltakerEAO {
	@PersistenceContext(name = "deltakerPersistenceUnit")
	private EntityManager em; 
	
	public void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
	}
	
	
}
