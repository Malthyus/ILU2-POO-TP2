package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficher = new ControlAfficherVillage(village);
		assertNotNull(controlAfficher);
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		String[] tab = control.donnerNomsVillageois();
		for (int i = 0; i < tab.length; i++) {
			assertNotNull(village.trouverHabitant(tab[i]));
		}
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		String nom = control.donnerNomVillage();
		assertEquals(nom, village.getNom());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		int n = control.donnerNbEtals();
		assertEquals(n, village.donnerNbEtal());
	}

}
