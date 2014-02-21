package bowling.frame.objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.constats.Constants;

public class FrameDescriptorTest {

	private FrameDescriptor frameDescriptor;
	
	@Before
	public void setUp() throws Exception {
		frameDescriptor = new FrameDescriptor();
	}

	@Test
	public void testGetIsValid() {
		frameDescriptor.setIsValid(false);
		assertFalse(frameDescriptor.getIsValid());
	}

	@Test
	public void testGetMessage() {
		String test = "test";
		frameDescriptor.setMessage(test);
		assertEquals(test, frameDescriptor.getMessage());
	}

	@Test
	public void testGetFrameType() {
		frameDescriptor.setFrameType(Constants.OPEN);
		assertEquals(Constants.OPEN, frameDescriptor.getFrameType());
	}

	@Test
	public void testGetFrameNumber() {
		Integer frameNumber = 5;
		frameDescriptor.setFrameNumber(frameNumber);
		assertEquals(frameNumber, frameDescriptor.getFrameNumber());
	}

}
