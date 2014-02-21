package bowling.frame;

import java.util.ArrayList;
import java.util.List;

import bowling.constats.Constants;
import bowling.frame.objects.FrameDescriptor;


public class FrameController {

	public static List<Integer> setUpValuesForFrame(String values, FrameDescriptor frameDescriptor){
		List<Integer> newValues = new ArrayList<Integer>();
		Integer firstValue = 10;
		if (!frameDescriptor.getFrameType().equals(Constants.BROKEN)){
			if (!frameDescriptor.getFrameType().equals(Constants.STRIKE)){
				firstValue = Integer.valueOf(values.substring(0,1));
				newValues.add(firstValue);
				
				if (frameDescriptor.getFrameType().equals(Constants.SPARE)){
					newValues.add(10-firstValue);
				}else if (frameDescriptor.getFrameType().equals(Constants.OPEN) && 
						 values.length() == 1){
					newValues.add(0);
				}else if (frameDescriptor.getFrameType().equals(Constants.OPEN) && 
						 values.length() == 2){
					Integer secondValue = Integer.valueOf(values.substring(1,2));
					if (secondValue + firstValue <= 10){
						newValues.add(secondValue);
					}else{
						newValues.clear();
					}
				}
			}else{
				newValues.add(firstValue);
				if (values.toLowerCase().contains("xx")){
					newValues.add(firstValue);
				}
			}
		}
		
		return newValues;
	}
	
	public static Integer calculateFrameTotal (List<Integer> values,List<Integer> nextTwoValues, FrameDescriptor frameDescriptor){
		Integer total =0;
		for(Integer value : values){
			total += value;
		}
		int size = 0;
		if (frameDescriptor.getFrameNumber() < 11){
			if (frameDescriptor.getFrameType().equals(Constants.SPARE)){
				size = 1;
			}else if (frameDescriptor.getFrameType().equals(Constants.STRIKE)){
				size = 2;
			}
			for(int i = 0; i < nextTwoValues.size() && i < size; i++){
				total += nextTwoValues.get(i);
			}
		}
		return total;
	}
}
