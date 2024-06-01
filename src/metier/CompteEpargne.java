package metier;

import java.util.Date;

public class CompteEpargne extends Compte {

	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(int code, double solde, double taux) {
		super(code, solde);
		this.taux = taux;
	}

	@Override
	public void retirer(double montant) {
		if (montant > solde)
			throw new RuntimeException("Solde insuffisant.");
		Retrait retrait = new Retrait(operations.size() + 1, new Date(), montant);
		operations.add(retrait);
		this.solde -= montant;
	}

	@Override
	public void updateSolde() {
		this.solde = solde * (1 + taux / 100);

	}

}
