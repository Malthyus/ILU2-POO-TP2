package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		// TODO a completer
		if (!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis désolée ");
			chaine.append(nomVendeur);
			chaine.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(chaine);
		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Bonjour ");
			chaine.append(nomVendeur);
			chaine.append(" je vais regarder si je peux vous trouver un étal.");
			System.out.println(chaine);
			if (!(controlPrendreEtal.resteEtals())) {
				StringBuilder chaine2 = new StringBuilder();
				chaine2.append("Désolée ");
				chaine2.append(nomVendeur);
				chaine2.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(chaine2);
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		// TODO a completer
		System.out.println("C'est parfait il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelque renseignement :");
		System.out.println("Quel produit souhaitez-vous vendre ?");
		String produit = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		}
		;
	}
}
