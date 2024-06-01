package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
	protected int code;
	protected double solde;
	protected List<Operation> operations = new ArrayList<>();

	public Compte() {
	}

	public Compte(int code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}

	public void verser(double montant) {
		Versement versement = new Versement(operations.size() + 1, new Date(), montant);
		operations.add(versement);
		this.solde += montant;
	}

	public abstract void retirer(double montant);

	public void virement(double montant, Compte compte) {
		this.retirer(montant);
		compte.verser(montant);
	}

	public double consulterSolde() {
		return this.solde;
	}

	public abstract void updateSolde();

	public List<Operation> getOperations() {
		return operations;
	}

	public double totalVersements() {
		double somme = 0;
		for (Operation operation : operations) {
			if (operation instanceof Versement) {
				somme += operation.getMontant();
			}
		}
		return somme;
	}

	public double totalRetraits() {
		double somme = 0;
		for (Operation operation : operations) {
			if (operation instanceof Retrait) {
				somme += operation.getMontant();
			}
		}
		return somme;
	}

}
