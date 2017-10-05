package no.hib.dat104.modell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "public", name = "deltaker")
public class Deltaker {

	@Id
	String mobil;
	String fornavn;
	String etternavn;
	String kjonn;
	boolean betalingsStatus;

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getMobil() {
		return mobil; 
	}
	
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	
	public String getKjonn() {
		return kjonn;
	}
	
}
