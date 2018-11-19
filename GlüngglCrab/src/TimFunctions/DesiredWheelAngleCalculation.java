package TimFunctions;

public class DesiredWheelAngleCalculation {

	public static double wheelAngleForward = 0;
	public static double wheelAngleBackward = 0;
	public static double desiredAngleForward = 0;
	public static double desiredAngleBackward = 0;
	public static double distanceClockwiseForward = 0;
	public static double distanceClockwiseBackward = 0;
	public static double distanceCounterClockwiseForward = 0;
	public static double distanceCounterClockwiseBackward = 0;
	public static boolean distanceDirection = false;
	public static boolean wheelDirection = false;
	public static boolean rotationDirection = false;
	public static double rotationDistance = 0;
	
	public DesiredWheelAngleCalculation() {
		
	}
	
	public void calculateWheelAngleDegrees(double actualAngle, double desiredAngle) {
		
		wheelAngleForward = actualAngle;
		desiredAngleForward = desiredAngle;
		
		if(wheelAngleForward + 180 > 180) {
			wheelAngleBackward = wheelAngleForward - 180;
		}else {
			wheelAngleBackward = wheelAngleForward + 180;
		}
		
		if(desiredAngleForward + 180 > 180) {
			desiredAngleBackward = desiredAngleForward - 180;
		}else {
			desiredAngleBackward = desiredAngleForward + 180;
		}
		
		if(wheelAngleForward - desiredAngleForward < 0) {
			distanceClockwiseForward = desiredAngleForward - wheelAngleForward;
		}else {
			distanceClockwiseForward = wheelAngleForward - desiredAngleForward;
		}
		
		if(wheelAngleBackward - desiredAngleBackward < 0) {
			distanceClockwiseBackward = desiredAngleBackward - wheelAngleBackward;
		}else {
			distanceClockwiseBackward = wheelAngleBackward - desiredAngleBackward;
		}
		
		if(wheelAngleBackward - desiredAngleForward < 0) {
			distanceCounterClockwiseForward = desiredAngleForward - wheelAngleBackward;
		}else {
			distanceCounterClockwiseForward = wheelAngleBackward - desiredAngleForward;
		}
		
		if(wheelAngleForward - desiredAngleBackward < 0) {
			distanceCounterClockwiseBackward = desiredAngleBackward - wheelAngleForward;
		}else {
			distanceCounterClockwiseBackward = wheelAngleForward - desiredAngleBackward;
		}
		
		if(distanceClockwiseForward <= distanceClockwiseBackward && distanceCounterClockwiseForward <= distanceCounterClockwiseBackward) {
			distanceDirection = true;
		}else {
			distanceDirection = false;
		}
		
		if(distanceDirection == true) {
			if(distanceClockwiseForward < distanceCounterClockwiseForward) {
				wheelDirection = true;
			}else {
				wheelDirection = false;
			}
		}else {
			if(distanceClockwiseBackward < distanceCounterClockwiseBackward) {
				wheelDirection = true;
			}else {
				wheelDirection = false;
			}
		}
		
		if(wheelDirection == true) {
			if(wheelAngleForward > desiredAngleForward) {
				rotationDirection = false;
			}else {
				rotationDirection = true;
			}
		}else {
			if(wheelAngleForward < desiredAngleBackward) {
				rotationDirection = true;
			}else {
				rotationDirection = false;
			}
		}
		
		if(wheelDirection == true) {
			if(distanceDirection == true) {
				rotationDistance = distanceClockwiseForward;
			}else {
				rotationDistance = distanceClockwiseBackward;
			}
		}else {
			if(distanceDirection == true) {
				rotationDistance = distanceCounterClockwiseForward;
			}else {
				rotationDistance = distanceCounterClockwiseBackward;
			}
		}
	}
	public void calculateWheelAngleRadiant(double actualAngle, double desiredAngle) {
		
		wheelAngleForward = actualAngle;
		desiredAngleForward = desiredAngle;
		
		if(wheelAngleForward + Math.PI > Math.PI) {
			wheelAngleBackward = wheelAngleForward - Math.PI;
		}else {
			wheelAngleBackward = wheelAngleForward + Math.PI;
		}
		
		if(desiredAngleForward + Math.PI > Math.PI) {
			desiredAngleBackward = desiredAngleForward - Math.PI;
		}else {
			desiredAngleBackward = desiredAngleForward + Math.PI;
		}
		
		if(wheelAngleForward - desiredAngleForward < 0) {
			distanceClockwiseForward = desiredAngleForward - wheelAngleForward;
		}else {
			distanceClockwiseForward = wheelAngleForward - desiredAngleForward;
		}
		
		if(wheelAngleBackward - desiredAngleBackward < 0) {
			distanceClockwiseBackward = desiredAngleBackward - wheelAngleBackward;
		}else {
			distanceClockwiseBackward = wheelAngleBackward - desiredAngleBackward;
		}
		
		if(wheelAngleBackward - desiredAngleForward < 0) {
			distanceCounterClockwiseForward = desiredAngleForward - wheelAngleBackward;
		}else {
			distanceCounterClockwiseForward = wheelAngleBackward - desiredAngleForward;
		}
		
		if(wheelAngleForward - desiredAngleBackward < 0) {
			distanceCounterClockwiseBackward = desiredAngleBackward - wheelAngleForward;
		}else {
			distanceCounterClockwiseBackward = wheelAngleForward - desiredAngleBackward;
		}
		
		if(distanceClockwiseForward <= distanceClockwiseBackward && distanceCounterClockwiseForward <= distanceCounterClockwiseBackward) {
			distanceDirection = true;
		}else {
			distanceDirection = false;
		}
		
		if(distanceDirection == true) {
			if(distanceClockwiseForward < distanceCounterClockwiseForward) {
				wheelDirection = true;
			}else {
				wheelDirection = false;
			}
		}else {
			if(distanceClockwiseBackward < distanceCounterClockwiseBackward) {
				wheelDirection = true;
			}else {
				wheelDirection = false;
			}
		}
		
		if(wheelDirection == true) {
			if(wheelAngleForward > desiredAngleForward) {
				rotationDirection = false;
			}else {
				rotationDirection = true;
			}
		}else {
			if(wheelAngleForward < desiredAngleBackward) {
				rotationDirection = true;
			}else {
				rotationDirection = false;
			}
		}
		
		if(wheelDirection == true) {
			if(distanceDirection == true) {
				rotationDistance = distanceClockwiseForward;
			}else {
				rotationDistance = distanceClockwiseBackward;
			}
		}else {
			if(distanceDirection == true) {
				rotationDistance = distanceCounterClockwiseForward;
			}else {
				rotationDistance = distanceCounterClockwiseBackward;
			}
		}
	}

	public boolean getWheelDirection() {
		return wheelDirection;
	}

	public boolean getRotationDirection() {
		return rotationDirection;
	}

	public double getRotationDistance() {
		return rotationDistance;
	}
}