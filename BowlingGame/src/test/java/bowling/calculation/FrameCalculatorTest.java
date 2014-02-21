package bowling.calculation;


import bowling.calculation.FrameCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrameCalculatorTest {

	private FrameCalculator frameCalculator;
	
	@Test
	public void getTotal(){
		frameCalculator = new FrameCalculator("45-54-36-27-09-63-81-18-90-72");
		assertTrue(frameCalculator.getAllValid().booleanValue());
		assertEquals(Integer.valueOf(90),frameCalculator.getTotal());
	}
	
	@Test
	public void getError(){
		frameCalculator = new FrameCalculator("XXXXXXX");
		assertFalse(frameCalculator.getAllValid());
		assertEquals("Not Enough Frames, counted only 1 frames",frameCalculator.getErroMessage());
	}
	
	@Test
	public void getErrorMultipleFramesAreWrong(){
		frameCalculator = new FrameCalculator("XXX-54-99-//-09-63-81-18-90-72");
		assertFalse(frameCalculator.getAllValid());
		assertEquals("Frame:1 contained more characters than it should have\n"+
					"Frame:3 has second throw which is larger than it should be\n"+
					"Frame:4 has an invalid value\n",frameCalculator.getErroMessage());
	}
	
	@Test
	public void getTotalWithAllStrikes(){
		frameCalculator = new FrameCalculator("x-x-x-x-x-x-x-x-x-x");
		assertTrue(frameCalculator.getAllValid());
	}

}
