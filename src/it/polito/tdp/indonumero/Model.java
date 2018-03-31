package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {
	
	private int NMAX = 100 ;
	private int TMAX = 7 ;
	
	private int segreto ; // numero da indovinare
	private int tentativi ; // tentativi già effettuati

	private boolean inGame = false ;
	
	public Model() {
		this.inGame = false ;
	}
	
	/**
	 * Fai un nuovo tentativo di indovinare il numero segreto
	 * @param t valore numerico del tentativo 
	 * @return 0 se è indovinato +1 se troppo grande -1 se troppo piccolo
	 */
	public int tentativo(int t) {
		if ( !inGame ) {
			throw new IllegalStateException("Partita non attiva") ;
		}
		if ( !valoreValido(t) ) {
			throw new InvalidParameterException("Valore fuori range") ;
		}
		
		this.tentativi++ ;
		if(this.tentativi == this.TMAX) {
			this.inGame = false ;
		}
		if (t==this.segreto) {
			this.inGame = false ;
			return 0;
		}
		if (t<this.segreto) {
			return -1 ;
		} else {
			return 1 ;
		}
			
	}
	/**
	 * Procedura per verificare il range di validità del dato inserito
	 * @param tentativo
	 * @return {@code true} se il tentativo è valido
	 */
	public boolean valoreValido(int tentativo) {
		return tentativo>=1 && tentativo <= this.NMAX ;
	}
	
	/**
	 * Avvia una nuova partita, generando un nuovo numero segreto
	 */
	public void newGame() {
		
    	this.segreto = (int)(Math.random()*NMAX)+1 ;
    	
    	this.tentativi = 0 ;
    	this.inGame = true ;
	}

	/**
	 * 
	 * @return the inGame
	 */
	public boolean isInGame() {
		return inGame;
	}
	/**
	 * 
	 * @return
	 */
	public int getTentativi() {
		return this.tentativi ; 
	}
	
	/**
	 * @return the nMAX
	 */
	public int getNMAX() {
		return NMAX;
	}

	/**
	 * @return the tMAX
	 */
	public int getTMAX() {
		return TMAX;
	}

	/**
	 * @return the segreto
	 */
	public int getSegreto() {
		return segreto;
	}

}
