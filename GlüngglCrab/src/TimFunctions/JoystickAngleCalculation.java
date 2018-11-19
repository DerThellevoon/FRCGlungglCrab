package TimFunctions;

public class JoystickAngleCalculation {

	public static double joystickAngleRadiant(double xAxis, double yAxis) {
		
		if(xAxis <= 0 && yAxis < 0) {
			return Math.atan(xAxis/yAxis) - 180;
		}else if(xAxis >= 0 && yAxis < 0) {
			return Math.atan(xAxis/yAxis) + 180;
		}else {
			return Math.atan(xAxis/yAxis);
		}
	}
	
	public static double joystickAngleDegrees(double xAxis, double yAxis) {
		
		if(xAxis <= 0 && yAxis < 0) {
			return 180 * Math.atan(xAxis/yAxis) / Math.PI - 180;
		}else if(xAxis >= 0 && yAxis < 0) {
			return 180 * Math.atan(xAxis/yAxis) / Math.PI + 180;
		}else {
			return 180 * Math.atan(xAxis/yAxis) / Math.PI;
		}
		
		
	}
}