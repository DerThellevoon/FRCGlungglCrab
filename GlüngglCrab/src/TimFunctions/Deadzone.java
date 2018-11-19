package TimFunctions;

public class Deadzone {
	
	private double outputAxis;
	
	public double getAxis(double inputAxis, double inputDeadzone) {
		
		if(inputAxis > inputDeadzone) {
			outputAxis = MapFunction.map(inputAxis, inputDeadzone, 1, 0, 1);
		}else if(inputAxis < -inputDeadzone) {
			outputAxis = MapFunction.map(inputAxis, -inputDeadzone, -1, 0, -1);
		}else {
			outputAxis = 0;
		}
		
		return outputAxis;
	}
	
}
