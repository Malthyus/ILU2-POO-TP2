package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 3);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois gaulois = new Gaulois("gaulois", 5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "produit", 1);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur control = new ControlTrouverEtalVendeur(village);
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur control = new ControlTrouverEtalVendeur(village);
		assertNotNull(control.trouverEtalVendeur("gaulois"));
		assertNull(control.trouverEtalVendeur("ha"));
	}

}
