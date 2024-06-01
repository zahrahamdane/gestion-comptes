package metier;

import java.util.List;

public class Application {

	public static void main(String[] args) {

		Compte c1 = new CompteCourant(1, 8000, 5000);
		Compte c2 = new CompteEpargne(2, 30000, 5.5);
		try {

			c1.verser(50000);
			c1.retirer(3000);
			c1.virement(400, c2);
			c1.verser(4000);
			c1.retirer(7000);

			System.out.println("Solde compte c1 = " + c1.consulterSolde());
			System.out.println("Solde compte c2 = " + c2.consulterSolde());

			System.out.println("Total des vairsements du compte C2 = " + c2.totalVersements());
			System.out.println("Total des retraits du compte C2 = " + c2.totalRetraits());

			System.out.println("------------------------------------------");

			List<Operation> listOperations = c1.getOperations();
			for (Operation operation : listOperations) {
				System.out.println(operation.getClass().getSimpleName() + "  " + operation.getNumero() + "  "
						+ operation.getDateOperation() + "  " + operation.getMontant());
			}

			System.out.println("Total des vairsements du compte C1 = " + c1.totalVersements());
			System.out.println("Total des retraits du compte C1 = " + c1.totalRetraits());

			System.out.println("------------------------------------------");

			c1.retirer(800000000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("------------------------------------------");

			System.out.println("Mettre a jour le solde");
			c1.updateSolde();
			c2.updateSolde();

			System.out.println("Solde compte c1 = " + c1.consulterSolde());
			System.out.println("Solde compte c2 = " + c2.consulterSolde());
		}

	}

}
