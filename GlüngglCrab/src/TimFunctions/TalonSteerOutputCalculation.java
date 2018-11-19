package TimFunctions;

public class TalonSteerOutputCalculation {
	
	private int desiredEncoderTicks = 0;
	private int encoderTicksDifference = 0;
	public double talonOutput = 0;
	private double rampValue = 0;

	public TalonSteerOutputCalculation() {
		
	}
	
	public double getTalonSteerOutput(int encoderTicks, int encoderTicksPerRotation, double rotationDistance, boolean rotationDirection) {
		
		rampValue = encoderTicksPerRotation / 360 * 20;
		
		if(rotationDirection == true) {
			
			desiredEncoderTicks = (int) (encoderTicks + Math.round(encoderTicksPerRotation / 360 * rotationDistance));
			encoderTicksDifference = desiredEncoderTicks - encoderTicks;
			
			if(encoderTicksDifference < rampValue) {
				talonOutput = MapFunction.map(encoderTicksDifference, 0, rampValue, 0, 1);
			}else {
				talonOutput = 1;
			}
		}else {
			
			desiredEncoderTicks = (int) (encoderTicks - Math.round(encoderTicksPerRotation / 360 * rotationDistance));
			encoderTicksDifference = encoderTicks - desiredEncoderTicks;

			if(encoderTicksDifference > rampValue) {
				talonOutput = MapFunction.map(encoderTicksDifference, 0, -rampValue, 0, -1);
			}else {
				talonOutput = -1;
			}			
		}
		
		return talonOutput;
	}
}
