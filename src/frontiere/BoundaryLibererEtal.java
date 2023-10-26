package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		// TODO a completer
		if (!(controlLibererEtal.isVendeur(nomVendeur))) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = donneesEtal[0] == "true";
			if (etalOccupe) {
				StringBuilder chaine = new StringBuilder();
				chaine.append("Vous avez vendu ");
				chaine.append(donneesEtal[4]);
				chaine.append(" sur ");
				chaine.append(donneesEtal[3]);
				chaine.append(" ");
				chaine.append(donneesEtal[2]);
				chaine.append(".");
				System.out.println(chaine);
				chaine = new StringBuilder();
				chaine.append("En revoir ");
				chaine.append(nomVendeur);
				chaine.append(", passez une bonne journée.");
				System.out.println(chaine);
			}
		}
	}

}
