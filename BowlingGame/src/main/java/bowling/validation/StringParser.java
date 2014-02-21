package bowling.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bowling.constats.*;
import bowling.frame.impl.Frame;
import bowling.frame.objects.FrameDescriptor;

public class StringParser {

	private static FrameDescriptor getFrameDescriptor(String inputString, Integer frameNumber){
		int inputLength = inputString.length();
		Matcher findMatch;
		FrameDescriptor frameDescriptor;
		
		if (inputLength > 0 && inputLength <= 2){
			Pattern framePattern = Pattern.compile("\\d{2}|X{1}|x{1}|\\d{1}/{1}");
			if(frameNumber == 11 ){
				framePattern = Pattern.compile("\\d{1,2}|X{2}|x{2}|\\d{1}/{1}");
			}
			findMatch = framePattern.matcher(inputString);
			if(!findMatch.matches()){
				frameDescriptor = createABrokenFrameDescriptor(frameNumber," has an invalid value");
			}else{
				String frameType = Constants.OPEN;
				if(inputString.contains("/")){
					frameType = Constants.SPARE;
				}else if(inputString.toLowerCase().contains("x")){
					frameType = Constants.STRIKE;
				}
				frameDescriptor = createAFrameDescriptor(frameNumber,frameType);
			}
			
		}else{
			frameDescriptor = createABrokenFrameDescriptor(frameNumber," contained more characters than it should have");
		}
		
		
		return frameDescriptor;
	}
	
	private static FrameDescriptor createABrokenFrameDescriptor(Integer frameNumber, String message){
		FrameDescriptor frameDescriptor = new FrameDescriptor();
		frameDescriptor.setFrameNumber(frameNumber);
		frameDescriptor.setFrameType(Constants.BROKEN);
		frameDescriptor.setIsValid(false);
		frameDescriptor.setMessage("Frame:"+frameNumber+message);
		
		return frameDescriptor;
	}
	
	private static FrameDescriptor createAFrameDescriptor(Integer frameNumber, String frameType){
		FrameDescriptor frameDescriptor = new FrameDescriptor();
		frameDescriptor.setFrameNumber(frameNumber);
		frameDescriptor.setFrameType(frameType);
		frameDescriptor.setIsValid(true);
		frameDescriptor.setMessage("");
		
		return frameDescriptor;
	}
	
	public static Frame getFrame (String inputString, Integer frameNumber){
		FrameDescriptor frameDescriptor = getFrameDescriptor(inputString,frameNumber);
		return new Frame(inputString, frameDescriptor);
	}
	
}
