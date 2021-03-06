/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team6014.robot;

import frc.team6014.robot.utility.SpeedControllerEnum;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	/* Note that IDs for CAN and PWM controllers are separate. And there are also DIOs.
	 * CAN Types: VICTORSPX,TALONSRX
	 * PWM Types: VICTORSP,SPARK,PWMVICTORSPX,PWMTALONSRX
	 * Other types are explained case-by-case.
	 */
	//Drive
	public static TalonSRX frontLeft = new TalonSRX(1);
	public static VictorSPX rearLeft = new VictorSPX(2);
	public static TalonSRX frontRight = new TalonSRX(3);
	public static VictorSPX rearRight = new VictorSPX(4);
	/*public static int frontLeft = 1;
	public static SpeedControllerEnum frontLeftEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int rearLeft = 2;
	public static SpeedControllerEnum rearLeftEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int frontRight = 3;
	public static SpeedControllerEnum frontRightEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int rearRight = 4;
	public static SpeedControllerEnum rearRightEnum = SpeedControllerEnum.VICTORSPX;*/
	
	public static int leftEncoderA = 2;
	public static int leftEncoderB = 3;
	public static int rightEncoderA = 4;//DIO
	public static int rightEncoderB = 5;//DIO
	
	//Arm
	public static int leftHinge = 6;
	public static SpeedControllerEnum leftHingeEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int rightHinge = 5;
	public static SpeedControllerEnum rightHingeEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int leftHolder = 8;
	public static SpeedControllerEnum leftHolderEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int rightHolder = 7;
	public static SpeedControllerEnum rightHolderEnum = SpeedControllerEnum.VICTORSPX;
	
	public static int armEncoderA = 0;//DIO
	public static int armEncoderB = 1;//DIO
	
	//Perception
	public static int ultra1 = 0;//Analog
	public static int ultra2 = 1;//Analog
}
