/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Package
package frc.robot.vars;

//Imports
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Servo;

public class Motors {

    //========================
    //===DRIVE TRAIN MOTORS===
    //========================
    
    //Configured for test chassis (1111_TestBedBlue)

    /*Drive Motors*/
	public static TalonSRX leftMotor = new TalonSRX(36); 
    public static TalonSRX rightMotor = new TalonSRX(9); 
    
    /*Accessory Motors*/
	public static TalonSRX flywheelMotor = new TalonSRX(53); 
    public static TalonSRX intakeMotor = new TalonSRX(58); 

    /*Servos*/
    public static Servo servoLeft = new Servo(9); //servo on the left from the back of the robot
    public static Servo servoRight = new Servo(1); //servo on the right from the back of the robot
    
    public static Servo ariTiltCam = new Servo(8);
}