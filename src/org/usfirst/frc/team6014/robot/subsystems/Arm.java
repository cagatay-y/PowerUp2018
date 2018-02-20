/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import org.usfirst.frc.team6014.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * A subsystem for controlling the arm and its components.
 */
public class Arm extends PIDSubsystem {
	SpeedController leftHinge = RobotMap.leftHingeEnum.generate(RobotMap.leftHinge);
	SpeedController rightHinge = RobotMap.rightHingeEnum.generate(RobotMap.rightHinge);
	SpeedControllerGroup hinge;
	
	SpeedController leftHolder = RobotMap.leftHolderEnum.generate(RobotMap.leftHolder);
	SpeedController rightHolder = RobotMap.rightHolderEnum.generate(RobotMap.rightHolder);	
	SpeedControllerGroup holder;
	
	Encoder hingeEncoder = new Encoder(RobotMap.encoderA, RobotMap.encoderB, false, Encoder.EncodingType.k4X);
	
	double countsPerRevolution = 564;
	double angularRange = 171;
	private double outPID = 0;
	
	public Arm() {
		super(0.48,1.85,0.031);
		hingeEncoder.reset();
		rightHinge.setInverted(true);
		rightHolder.setInverted(true);
		hinge = new SpeedControllerGroup(leftHinge,rightHinge);
		holder = new SpeedControllerGroup(leftHolder,rightHolder);
		setAbsoluteTolerance(3);
		getPIDController().setContinuous(false);
	}
	
	@Override
	public void initDefaultCommand() {
	}
	
	@Override
	protected double returnPIDInput() {
		return getCurrentAngle();
	}
	@Override
	protected void usePIDOutput(double output) {
		this.outPID = output;
	}
	public void setAngle(double angle) {
		this.setSetpoint(angle);
	}
	public void hingePID() {
		this.setHingeSpeed(outPID);
	}
	
	public void setHolderSpeed(double speed) {
		holder.set(speed);
	}
	public void setHingeSpeed(double speed) {
		if(overRotated(speed>0)){
			hinge.set(0);
		} else {
			hinge.set(speed);
		}
	}
	
	public void resetHingeEncoder() {
		hingeEncoder.reset();
	}
	
	public double getCurrentAngle() {
		int count = hingeEncoder.get();
		return count*360/countsPerRevolution;
	}
	
	public boolean overRotated(boolean dir){
		double angle = getCurrentAngle();
		if((angle<=0 && !dir) || (angle>=angularRange && dir)){
			return true;
		}
		return false;
	}
}