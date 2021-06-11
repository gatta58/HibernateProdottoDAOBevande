package corso.lez16.HibernateProdottoDAOBevande.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bevanda")
public class Bevanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bevandaID")
	private int id;
	@Column
	private String codice;
	@Column
	private String nome;
	@Column
	private Float volume;
	
	public Bevanda() {
		
	}

	public Bevanda(String codice, String nome, Float volume) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Bevanda [id=" + id + ", codice=" + codice + ", nome=" + nome + ", volume=" + volume + "]";
	}
	
	

}
