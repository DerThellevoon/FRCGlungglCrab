/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6417.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import TimFunctions.DesiredWheelAngleCalculation;
import TimFunctions.ActiveWheelAngleCalculation;
import TimFunctions.Deadzone;
import TimFunctions.JoystickAngleCalculation;
import TimFunctions.TalonSteerOutputCalculation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	public static Deadzone deadzone = new Deadzone();
	public DesiredWheelAngleCalculation angleCalculationFrontLeft = new DesiredWheelAngleCalculation();
	public ActiveWheelAngleCalculation activeAngleCalculationFrontLeft = new ActiveWheelAngleCalculation();
	public TalonSteerOutputCalculation talonSteerOutputCalculationFrontLeft = new TalonSteerOutputCalculation();
	
	public static final WPI_TalonSRX talonDriveFrontLeft = new WPI_TalonSRX(4);
	public static final WPI_TalonSRX talonDriveFrontRight = new WPI_TalonSRX(1);
	public static final WPI_TalonSRX talonDriveBackLeft = new WPI_TalonSRX(2);
	public static final WPI_TalonSRX talonDriveBackRight = new WPI_TalonSRX(3);
	public static final WPI_TalonSRX talonSteerFrontLeft = new WPI_TalonSRX(0);
	public static final WPI_TalonSRX talonSteerFrontRight = new WPI_TalonSRX(5);
	public static final WPI_TalonSRX talonSteerBackLeft = new WPI_TalonSRX(6);
	public static final WPI_TalonSRX talonSteerBackRight = new WPI_TalonSRX(7);
	
	public static final Joystick joystick1 = new Joystick(0);
	public static final JoystickButton buttonSetZero = new JoystickButton(joystick1, 1);
	
	public static double deadzoneValue = 0.15;
	public static int driveRotationTickCount = 11564;
	public static int steerRotationTickCount = 255200;
	
	public static double joystickYAxis, joystickXAxis, joystickZAxis = 0;
	public static boolean buttonSetZeroState = false;
	public static int encoderDriveFrontLeftCount, encoderSteerFrontLeftCount = 0;
	public static double joystickAngleDegrees = 0;
	public static boolean wheelDirectionFrontLeft = false;
	public static boolean rotationDirectionFrontLeft = false;
	public static double rotationDistanceDergreesFrontLeft = 0;
	public static double wheelAngleFrontLeft = 0;
	
	@Override
	public void teleopInit() {
		
		talonDriveFrontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		talonSteerFrontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		joystickXAxis = deadzone.getAxis(joystick1.getX(), deadzoneValue);
		joystickYAxis = deadzone.getAxis(-joystick1.getY(), deadzoneValue);
		joystickZAxis = deadzone.getAxis(joystick1.getZ(), deadzoneValue);
		
		buttonSetZeroState = buttonSetZero.get();
		
		encoderDriveFrontLeftCount = -talonDriveFrontLeft.getSelectedSensorPosition();
		encoderSteerFrontLeftCount = -talonSteerFrontLeft.getSelectedSensorPosition();
		
		joystickAngleDegrees = JoystickAngleCalculation.joystickAngleDegrees(joystickXAxis, joystickYAxis);
		
		wheelAngleFrontLeft = activeAngleCalculationFrontLeft.getWheelAngleDegrees(encoderSteerFrontLeftCount, steerRotationTickCount);
		
//		angleCalculationFrontLeft.calculateWheelAngleDegrees(0, joystickAngleDegrees);
		
//		wheelDirectionFrontLeft = angleCalculationFrontLeft.getWheelDirection();
//		rotationDirectionFrontLeft = angleCalculationFrontLeft.getRotationDirection();
//		rotationDistanceDergreesFrontLeft = angleCalculationFrontLeft.getRotationDistance();
	
//		talonSteerFrontLeft.set(talonSteerOutputCalculationFrontLeft.getTalonSteerOutput(encoderSteerFrontLeftCount, steerRotationTickCount, rotationDistanceDergreesFrontLeft, rotationDirectionFrontLeft));
		
		talonSteerFrontLeft.set(joystickZAxis);
		
		if(buttonSetZeroState == true) {
			talonDriveFrontLeft.setSelectedSensorPosition(0);
			talonDriveFrontRight.setSelectedSensorPosition(0);
			talonDriveBackLeft.setSelectedSensorPosition(0);
			talonDriveBackRight.setSelectedSensorPosition(0);
			talonSteerFrontLeft.setSelectedSensorPosition(0);
			talonSteerFrontRight.setSelectedSensorPosition(0);
			talonSteerBackLeft.setSelectedSensorPosition(0);
			talonSteerBackRight.setSelectedSensorPosition(0);
		}
		
		
		
//		SmartDashboard.putNumber("Joystick X Axis: ", joystickXAxis);
//		SmartDashboard.putNumber("Joystick Y Axis: ", joystickYAxis);
		SmartDashboard.putNumber("Joystick Z Axis: ", joystickZAxis);
//		SmartDashboard.putNumber("Joystick Angle: ", joystickAngleDegrees);
		SmartDashboard.putNumber("steerRotationTickCount: ", steerRotationTickCount);
		SmartDashboard.putNumber("Wheelangle FrontLeft: ", wheelAngleFrontLeft);
		SmartDashboard.putNumber("wheelRotationsDecimal: ", ActiveWheelAngleCalculation.wheelRotationsDecimal);
		SmartDashboard.putNumber("wheelRotations: ", ActiveWheelAngleCalculation.wheelRotations);
		SmartDashboard.putBoolean("wheelAngleOperationFlip: ", ActiveWheelAngleCalculation.wheelAngleOperationFlip);

		//		SmartDashboard.putBoolean("Joystick Button 1 State: ", buttonSetZeroState);
//		SmartDashboard.putNumber("encoderDriveFrontLeftCount: ", encoderDriveFrontLeftCount);
//		SmartDashboard.putNumber("encoderDriveFrontRightCount: ", encoderDriveFrontRightCount);
//		SmartDashboard.putNumber("encoderDriveBackLeftCount: ", encoderDriveBackLeftCount);
//		SmartDashboard.putNumber("encoderDriveBackRightCount: ", encoderDriveBackRightCount);
		SmartDashboard.putNumber("encoderSteerFrontLeftCount: ", encoderSteerFrontLeftCount);
//		SmartDashboard.putNumber("encoderSteerFrontRightCount: ", encoderSteerFrontRightCount);
//		SmartDashboard.putNumber("encoderSteerBackLeftCount: ", encoderSteerBackLeftCount);
//		SmartDashboard.putNumber("encoderSteerBackRightCount: ", encoderSteerBackRightCount);
//		SmartDashboard.putNumber("wheelAngleForward: ", DesiredWheelAngleCalculation.wheelAngleForward);
//		SmartDashboard.putNumber("wheelAngleBackward: ", DesiredWheelAngleCalculation.wheelAngleBackward);
//		SmartDashboard.putNumber("desiredAngleForward: ", DesiredWheelAngleCalculation.desiredAngleForward);
//		SmartDashboard.putNumber("desiredAngleBackward: ", DesiredWheelAngleCalculation.desiredAngleBackward);
//		SmartDashboard.putNumber("distanceClockwiseForward: ", DesiredWheelAngleCalculation.distanceClockwiseForward);
//		SmartDashboard.putNumber("distanceClockwiseBackward: ", DesiredWheelAngleCalculation.distanceClockwiseBackward);
//		SmartDashboard.putNumber("distanceCounterClockwiseForward: ", DesiredWheelAngleCalculation.distanceCounterClockwiseForward);
//		SmartDashboard.putNumber("distanceCounterClockwiseBackward: ", DesiredWheelAngleCalculation.distanceCounterClockwiseBackward);
//		SmartDashboard.putBoolean("Distance Direction: ", DesiredWheelAngleCalculation.distanceDirection);
//		SmartDashboard.putBoolean("Wheel Direction: ", wheelDirectionFrontLeft);
//		SmartDashboard.putBoolean("Rotation Direction: ", rotationDirectionFrontLeft);
//		SmartDashboard.putNumber("Rotation Distance: ", rotationDistanceDergreesFrontLeft);
	}
}
