package bowling.frame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bowling.constats.Constants;
import bowling.frame.objects.FrameDescriptor;

public class FrameControllerTest {

	
	FrameDescriptor frameDescriptor;
	@Before
	public void setUp() throws Exception {
		frameDescriptor = new FrameDescriptor();
		frameDescriptor.setFrameNumber(5);
		frameDescriptor.setIsValid(true);
		frameDescriptor.setMessage("");
		frameDescriptor.setFrameType(Constants.OPEN);
	}

	@Test
	public void testSetUpValuesForFrame() {
		String values = "35";
		List<Integer> valuesReturned = FrameController.setUpValuesForFrame(values, frameDescriptor);
		assertEquals(Integer.valueOf(3),valuesReturned.get(0));
		assertEquals(Integer.valueOf(5),valuesReturned.get(1));
	}

	@Test
	public void testCalculateFrameTotal() {
		List<Integer> nextValues = new ArrayList<Integer>();
		nextValues.add(2);
		nextValues.add(3);
		List<Integer> values = new ArrayList<Integer>();
		values.add(2);
		values.add(3);
		Integer total = FrameController.calculateFrameTotal(values, nextValues, frameDescriptor);
		assertEquals(Integer.valueOf(5),total);
	}
	
	@Test
	public void testCalculateFrameTotalWithSpare() {
		List<Integer> nextValues = new ArrayList<Integer>();
		nextValues.add(2);
		nextValues.add(3);
		List<Integer> values = new ArrayList<Integer>();
		values.add(2);
		values.add(3);
		frameDescriptor.setFrameType(Constants.SPARE);
		Integer total = FrameController.calculateFrameTotal(values, nextValues, frameDescriptor);
		assertEquals(Integer.valueOf(7),total);
	}
	
	@Test
	public void testCalculateFrameTotalWithStrike() {
		List<Integer> nextValues = new ArrayList<Integer>();
		nextValues.add(2);
		nextValues.add(3);
		List<Integer> values = new ArrayList<Integer>();
		values.add(2);
		values.add(3);
		frameDescriptor.setFrameType(Constants.STRIKE);
		Integer total = FrameController.calculateFrameTotal(values, nextValues, frameDescriptor);
		assertEquals(Integer.valueOf(10),total);
	}
	

}
