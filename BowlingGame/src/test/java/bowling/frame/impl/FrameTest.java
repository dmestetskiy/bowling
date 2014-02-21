package bowling.frame.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bowling.constats.Constants;
import bowling.frame.objects.FrameDescriptor;

public class FrameTest {

	FrameDescriptor frameDescriptor = new FrameDescriptor();
	String values = "45";
	Frame frame;
	Integer frameNumber = 5;
	
	
	@Before
	public void setUp() throws Exception {
		frameDescriptor = new FrameDescriptor();
		frameDescriptor.setFrameNumber(frameNumber);
		frameDescriptor.setIsValid(true);
		frameDescriptor.setFrameType(Constants.OPEN);
		frame = new Frame(values, frameDescriptor);
	}

	@Test
	public void testGetTotal() {
		assertEquals(Integer.valueOf(9),frame.getTotal());
	}

	@Test
	public void testGetValue() {
		assertEquals(Integer.valueOf(4),frame.getValue(0));
	}

	@Test
	public void testGetFrameType() {
		assertEquals(Constants.OPEN,frame.getFrameType());
	}

	@Test
	public void testGetFrameNumber() {
		assertEquals(frameNumber,frame.getFrameNumber());
	}

	@Test
	public void testGetSizeOfFrame() {
		assertEquals(Integer.valueOf(2),frame.getSizeOfFrame());
	}

	@Test
	public void testGetValues() {
		List<Integer> expectedValues = new ArrayList<Integer>();
		expectedValues.add(4);
		expectedValues.add(5);
		assertEquals(expectedValues, frame.getValues());
	}

	@Test
	public void testGetIsValid() {
		assertTrue(frame.getIsValid());
	}
	
	public void testFrameWhichAddsUpToMoreThanTen(){
		String values = "77";
		frame = new Frame(values,frameDescriptor);
		
		assertFalse(frame.getIsValid());
		assertEquals(Constants.BROKEN, frame.getFrameType());
	}

}
