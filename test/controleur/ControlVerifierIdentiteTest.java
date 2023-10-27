package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	public @Test void testControlVerifierIdentite() {
		ControlVerifierIdentite control = new ControlVerifierIdentite(village);
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite control = new ControlVerifierIdentite(village);
	}

}
