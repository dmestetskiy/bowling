package bowling.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.constats.Constants;
import bowling.frame.impl.Frame;

public class StringParserTest {

	private String inputString;
	private Integer frameNumber = 5;
	private Frame frame;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetFrame() {
		inputString = "90";
		frame = StringParser.getFrame(inputString, frameNumber);
		assertTrue(frame.getIsValid());
		assertEquals(Integer.valueOf(9),frame.getTotal());
	}
	
	@Test
	public void testGetFrameTooManyCharacters() {
		inputString = "999";
		frame = StringParser.getFrame(inputString, frameNumber);
		assertFalse(frame.getIsValid());
		assertEquals(Constants.BROKEN,frame.getFrameType());
		assertEquals("Frame:5 contained more characters than it should have", frame.getErrorMessage());
	}
	
	@Test
	public void testGetFrameNotEnoughCharacters() {
		inputString = "9";
		frame = StringParser.getFrame(inputString, frameNumber);
		assertFalse(frame.getIsValid());
		assertEquals(Constants.BROKEN,frame.getFrameType());
		assertEquals("Frame:5 has an invalid value", frame.getErrorMessage());
	}
	
	@Test
	public void testGetFrameHasTooManyStrikes() {
		inputString = "XX";
		frame = StringParser.getFrame(inputString, frameNumber);
		assertFalse(frame.getIsValid());
		assertEquals(Constants.BROKEN,frame.getFrameType());
		assertEquals("Frame:5 has an invalid value", frame.getErrorMessage());
	}
	
	@Test
	public void testGetFrameHasTooManySpares() {
		inputString = "//";
		frame = StringParser.getFrame(inputString, frameNumber);
		assertFalse(frame.getIsValid());
		assertEquals(Constants.BROKEN,frame.getFrameType());
		assertEquals("Frame:5 has an invalid value", frame.getErrorMessage());
	}

}
