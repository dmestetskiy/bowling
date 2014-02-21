package bowling.frame.objects;

public class FrameDescriptor {
	private Boolean isValid = false;
	private String message = "";
	private String frameType;
	private Integer frameNumber;
	
	public FrameDescriptor(){
	}
	
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFrameType() {
		return frameType;
	}
	public void setFrameType(String type) {
		this.frameType = type;
	}

	public Integer getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(Integer frameNumber) {
		this.frameNumber = frameNumber;
	}
	
	
	
	
	
}
