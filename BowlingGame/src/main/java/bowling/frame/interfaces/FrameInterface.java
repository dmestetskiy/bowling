package bowling.frame.interfaces;

import java.util.List;

public interface FrameInterface {

	public Integer getTotal();
	
	public Integer getValue(int index);
	
	public String getFrameType();
	
	public void setNextTwoValues(List<Integer> twoMoreValues);
	
	public Integer getFrameNumber();
	
	public Integer getSizeOfFrame();

	public List<Integer> getValues();
	
	public Boolean getIsValid();
	
	public String getErrorMessage();
}
