package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
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
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal control = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(control);
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal control = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(control.isVendeur("gaulois"));
		assertFalse(control.isVendeur("ha"));

	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal control = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] tab = control.libererEtal("gaulois");
		System.out.println(tab[0]);
		assertEquals(tab[0], "false");
	}

}
