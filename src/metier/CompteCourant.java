package metier;

import java.util.Date;

public class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(int code, double solde, double decouvert) {
		super(code, solde);
		this.decouvert = decouvert;
	}

	@Override
	public void retirer(double montant) {
		if (montant > (this.solde + this.decouvert))
			throw new RuntimeException("Solde insuffisant");
		Retrait retrait = new Retrait(operations.size() + 1, new Date(), montant);
		operations.add(retrait);
		this.solde -= montant;
	}

	@Override
	public void updateSolde() {
		// TODO Auto-generated method stub

	}

}
