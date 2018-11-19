package TimFunctions;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ActiveWheelAngleCalculation {

	public static double wheelRotationsDecimal = 0;
	public static int wheelRotations = 0;
	public static boolean wheelAngleOperationFlip = false;
	public double wheelAngle = 0;
	
	public ActiveWheelAngleCalculation() {
		
	}
	
	public double getWheelAngleDegrees(int encoderTicks, int encoderTicksPerRotation) {
		
		wheelRotationsDecimal = (double) encoderTicks / (encoderTicksPerRotation / 2);
		
		SmartDashboard.putNumber("encoderTicks: ", encoderTicks);
		SmartDashboard.putNumber("encoderTicksPerRotation: ", encoderTicksPerRotation);
		
		wheelRotations = (int)Math.floor(wheelRotationsDecimal);
		
		if (wheelRotations%2 == 0) {
			
			wheelAngleOperationFlip = false;
		}else {
			
			wheelAngleOperationFlip = true;
		}
		
		if(wheelAngleOperationFlip == false) {
			
			wheelAngle = (wheelRotationsDecimal - wheelRotations) * 180;
		}else {
			
			wheelAngle = -180 + (wheelRotationsDecimal - wheelRotations) * 180;
		}
		
		return wheelAngle;
	}
}
