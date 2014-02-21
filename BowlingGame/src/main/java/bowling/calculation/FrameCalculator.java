package bowling.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bowling.validation.StringParser;

import bowling.frame.impl.Frame;


public class FrameCalculator {

	private String DASH = "-";
	private Integer total = 0;
	private String errorMessage = "";
	private Boolean framesAllValid = true;
	
	public FrameCalculator(String inputString){
		List<String> frameStrings = Arrays.asList(inputString.split(DASH));
		List<Frame> frames = getAllFrames(frameStrings);
		Boolean framesAllValid = true;
		List<Frame> newFrames = addNextTwoValuesToFrames(frames);
		
		if (framesAllValid){
			calculateTotal(newFrames);
		}
	}
	
	private List<Frame> getAllFrames(List<String> frameStrings){
		List<Frame> frames = new ArrayList<Frame>();
		int frameNumber = 1;
		for (String frameString : frameStrings){
			frames.add(StringParser.getFrame(frameString,frameNumber ));
			frameNumber++;
		}

		if (frameNumber == 11){
			frames.add(new Frame(Integer.valueOf(frameNumber)));
		}
		return frames;
	}
	
	private List<Frame> addNextTwoValuesToFrames(List<Frame> frames){
		List<Frame> newFrames = new ArrayList<Frame>();
		if (frames.size() == 10 || frames.size() == 11){
			for (Frame frame : frames){
				if (frame.getFrameNumber() <=10 && frame.getIsValid() && framesAllValid){
					List<Integer> twoMoreValues = new ArrayList<Integer>();
					Frame futureFrame = frames.get(frame.getFrameNumber());
					int sizeOfFirstFrame = futureFrame.getSizeOfFrame();
					twoMoreValues = new ArrayList<Integer>(futureFrame.getValues());
					if (sizeOfFirstFrame == 1){
						twoMoreValues.add(frames.get(frame.getFrameNumber()+1).getValue(0));
					}
					Frame newFrame = frame;
					newFrame.setNextTwoValues(twoMoreValues);
					newFrames.add(newFrame);
				}else if (!frame.getIsValid()){
					framesAllValid = false;
					errorMessage+= frame.getErrorMessage()+"\n";
				}
			}
		}else if (frames.size() < 10){
			framesAllValid = false;
			errorMessage+= "Not Enough Frames, counted only "+frames.size()+" frames";
		}else if (frames.size() > 11){
			framesAllValid = false;
			errorMessage+= "Too many frames, counted "+frames.size()+" frames";
		}
		
		return newFrames;
	}
	
	private void calculateTotal(List<Frame> frames){
		for (Frame frame :frames){
			if (frame.getFrameNumber() <=10 ){
				
				total += frame.getTotal();
			}
		}
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public String getErroMessage(){
		return errorMessage;
	}
	
	public Boolean getAllValid(){
		return framesAllValid;
	}
	
}
