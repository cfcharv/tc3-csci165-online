import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureTest {

	@Test
	void testTemperature() {
		Temperature t =new Temperature();
		double value = t.getTempVal();
		String scale = t.getTempScale();
		
		assertEquals(value, 0);
		assertEquals(scale, "C");
	}

	@Test
	void testTemperatureDoubleString() {
		Temperature t  = new Temperature(212 , "Ffd"); //invalid value and Scale
		Temperature t1 = new Temperature(-40, "C");//valid
		Temperature t3 = new Temperature(212, "F");//invalid value, valid scale
		Temperature t4 = new Temperature(35, "S");//valid value, invalid scale
		
		double value = t.getTempVal();
		String scale = t.getTempScale();
		
		assertEquals(value,0);
		assertEquals(scale,"C");
		
		value = t1.getTempVal();
		scale = t1.getTempScale();
		
		assertEquals(value, -40);
		assertEquals(scale, "C");
		
		value = t3.getTempVal();
		scale = t3.getTempScale();
		
		assertEquals(value, 0);
		assertEquals(scale, "F");
		
		value = t4.getTempVal();
		scale = t4.getTempScale();
		
		assertEquals(value, 35);
		assertEquals(scale, "C");
		
		
	}

	@Test
	void testSetTempVal() {
		Temperature t = new Temperature(40,"F");//did not use default as that might not indicate a failure due to default values
		
		t.setTempVal(212);//invalid entry
		
		double value = t.getTempVal();
		
		assertEquals(value, 0);
		
		t.setTempVal(135);//seting a valid value now
		value = t.getTempVal();
		
		assertEquals(value, 135);
		
	}

	@Test
	void testSetTempScale() {
		Temperature t = new Temperature(100, "C");//once again not using default so a failure is definitely indicated
		
		t.setTempScale("F");//valid scale
		
		String scale = t.getTempScale();
		
		assertEquals(scale, "F");
		
		t.setTempScale("Q");//invalid scale
		scale = t.getTempScale();
		
		assertEquals(scale, "C");
		
	}

	@Test
	void testSetTempValScale() {
		Temperature t = new Temperature();
		
		t.setTempValScale(40, "F");//valid data
		
		double value = t.getTempVal();
		String scale = t.getTempScale();
		
		assertEquals(value, 40);
		assertEquals(scale, "F");
		
		t.setTempValScale(212, "hfdjk");//invalid data for both
		
		value = t.getTempVal();
		scale = t.getTempScale();
		
		assertEquals(value, 0);
		assertEquals(scale, "C");
		
		
		
		
	}

	@Test
	void testGetTempF() {
		Temperature t =new Temperature(100, "C");//object in Celsius needs to convert
		Temperature t1 = new Temperature (121, "F");//object already in Fahrenheit
		
		double value = t.getTempF();
		
		assertEquals(value, 212);
		
		value = t1.getTempF();
		assertEquals(value, 121);
		
	}

	@Test
	void testGetTempC() {
		Temperature t =new Temperature(100, "C");//object in Celsius 
		Temperature t1 = new Temperature (32, "F");//object in Fahrenheit needs to convert
		
		double value = t.getTempC();
		assertEquals(value, 100);
		
		value = t1.getTempC();
		assertEquals(value, 0);
		
	}

	@Test
	void testEqualsTemperature() {
		Temperature t = new Temperature(32, "F");
		Temperature t1 = new Temperature (0, "C");
		Temperature t2 = new Temperature (100, "C");
		Temperature t3 = new Temperature (32, "F");
		
		boolean tempcheck = t.equals(t1);//check different scales
		assertEquals(tempcheck, true);
		
		tempcheck = t1.equals(t2);
		assertEquals (tempcheck, false);//check not equals
		
		tempcheck = t.equals(t3);
		assertEquals(tempcheck, true);//check same scale
		
	}

	@Test
	void testToString() {
		Temperature t = new Temperature(40, "F");
		
		String temp = t.toString();
		
		assertEquals(temp, "40.0 degrees F");
	}

	@Test
	void testCompareTo() {
		Temperature t = new Temperature(32, "F");
		Temperature t1 = new Temperature (0, "C");
		Temperature t2 = new Temperature (100, "C");
		Temperature t3 = new Temperature (32, "F");
		
		int compare = t.compareTo(t1);//check equal with different scales
		assertEquals(compare, 0);
		
		compare = t1.compareTo(t2);//check less than same scasle
		assertEquals(compare, -1);
		
		compare = t2.compareTo(t3);// greater than different scale
		assertEquals(compare, 1);
		
	}

}
