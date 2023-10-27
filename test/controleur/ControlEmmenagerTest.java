package controleur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
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
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager);
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager control = new ControlEmmenager(village);
		control.ajouterGaulois("Bonemine", 3);
		assertTrue(control.isHabitant("Bonemine"));
		assertFalse(control.isHabitant("Ha"));
		control.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(control.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager control = new ControlEmmenager(village);
		assertFalse(control.isHabitant("Panoramix"));
		control.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(control.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager control = new ControlEmmenager(village);
		assertFalse(control.isHabitant("Bonemine"));
		control.ajouterGaulois("Bonemine", 3);
		assertTrue(control.isHabitant("Bonemine"));
	}

}
