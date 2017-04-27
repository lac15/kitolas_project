package hu.unideb.inf.prt.kitolas.model;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

public class TestKitolasData {

	private static KitolasData kd;
	
	static {
        kd = new KitolasData("0", "0", "0", "0", "0", "0");
    }
	
	@Test
	public void getAndSetTablanBTest() {
		kd.setTablanB("1");
		assertEquals("1", kd.getTablanB());
	}
	
	@Test
	public void getAndSetLevettBTest() {
		kd.setLevettB("1");
		assertEquals("1", kd.getLevettB());
	}
	
	@Test
	public void getAndSetTablanWTest() {
		kd.setTablanW("1");
		assertEquals("1", kd.getTablanW());
	}
	
	@Test
	public void getAndSetLevettWTest() {
		kd.setLevettW("1");
		assertEquals("1", kd.getLevettW());
	}
	
	@Test
	public void getAndSetKorSzamTest() {
		kd.setKorSzam("1");
		assertEquals("1", kd.getKorSzam());
	}
	
	@Test
	public void getAndSetLepesSzamTest() {
		kd.setLepesSzam("1");
		assertEquals("1", kd.getLepesSzam());
	}
}
