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

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 3);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois gaulois = new Gaulois("gaulois", 5);
		village.ajouterHabitant(gaulois);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal control = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal control = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(control.resteEtals());
		control.prendreEtal("gaulois", "produit", 1);
		assertTrue(control.resteEtals());
		control.prendreEtal("gaulois", "produit", 1);
		assertTrue(control.resteEtals());
		control.prendreEtal("gaulois", "produit", 1);
		assertFalse(control.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal control = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(0, control.prendreEtal("gaulois", "produit", 1));
		control.prendreEtal("gaulois", "produit", 1);
		control.prendreEtal("gaulois", "produit", 1);
		assertEquals(control.prendreEtal("gaulois", "produit", 1), -1);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal control = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(control.verifierIdentite("gaulois"));
		assertFalse(control.verifierIdentite("ha"));
	}

}
