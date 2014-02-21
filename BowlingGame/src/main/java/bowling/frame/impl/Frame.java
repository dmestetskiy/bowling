package bowling.frame.impl;

import java.util.ArrayList;
import java.util.List;

import bowling.constats.Constants;
import bowling.frame.FrameController;
import bowling.frame.interfaces.FrameInterface;
import bowling.frame.objects.FrameDescriptor;

public class Frame implements FrameInterface {

	private List<Integer> values;
	private List<Integer> nextTwoValues;
	private FrameDescriptor frameDescriptor;
	
	public Frame ()
	{
		nextTwoValues = new ArrayList<Integer>();
	}
	
	public Frame (Integer frameNumber){
		this();
		values = new ArrayList<Integer>();
		frameDescriptor = new FrameDescriptor();
		frameDescriptor.setFrameNumber(frameNumber);
		frameDescriptor.setIsValid(true);
	}
	
	public Frame (String values, FrameDescriptor frameDescriptor){
		this();
		this.values = FrameController.setUpValuesForFrame(values, frameDescriptor);
		this.frameDescriptor = frameDescriptor;
		if (this.values.size() == 0 && frameDescriptor.getIsValid()){
			this.frameDescriptor.setFrameType(Constants.BROKEN);
			this.frameDescriptor.setIsValid(false);
			this.frameDescriptor.setMessage("Frame:"+ frameDescriptor.getFrameNumber() +" has second throw which is larger than it should be");
		}
	}
	
	@Override
	public Integer getTotal() {
		return FrameController.calculateFrameTotal(values, nextTwoValues, frameDescriptor);
	}

	@Override
	public Integer getValue(int index) {
		if (values.size() > index){
			return values.get(index);
		}else{
			return 0;
		}
	}

	@Override
	public String getFrameType() {
		// TODO Auto-generated method stub
		return frameDescriptor.getFrameType();
	}

	@Override
	public void setNextTwoValues(List<Integer> nextTwoValues) {
		this.nextTwoValues = nextTwoValues;

	}

	@Override
	public Integer getFrameNumber() {
		return frameDescriptor.getFrameNumber();
	}

	@Override
	public Integer getSizeOfFrame() {
		return values.size();
	}

	@Override
	public List<Integer> getValues() {
		return values;
	}

	@Override
	public Boolean getIsValid() {
		return frameDescriptor.getIsValid();
	}

	@Override
	public String getErrorMessage() {
		return frameDescriptor.getMessage();
	}

}
