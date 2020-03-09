/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Package
package frc.robot;
import frc.robot.subsys.PixyCam;
//Imports
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsys.DriveTrain;
import frc.robot.util.util;
import frc.robot.vars.ControllerMap;




public class Driver {
    PixyCam cam = new PixyCam();
    Joystick joy = new Joystick(ControllerMap.DRIVER_PORT);
    DriveTrain dt = new DriveTrain();
    
    
    private static final double joyFilterBound = 0.1;

    public Driver() {
        //Put any driver initialization code here!
        
    }

    public void drive() {
        double intakeTrigger = joy.getRawAxis(ControllerMap.R_TRIGGER);
        double outtakeTrigger = joy.getRawAxis(ControllerMap.L_TRIGGER);
        boolean fireButton = joy.getRawButton(4);
        double throttle = joy.getRawAxis(ControllerMap.L_STICKY);
        double turnVal = joy.getRawAxis(ControllerMap.L_STICKX);

        //System.out.println(navXD.getAngle());

        dt.tilt(0.75);
        if(joy.getRawButton(ControllerMap.R_BUMPER))
        {
            lineUp();
        }
        else if (util.isOutofRange(throttle, joyFilterBound) || util.isOutofRange(turnVal, joyFilterBound)) { //Filters joystick drift
            
            dt.arcadeDrive(throttle, turnVal);
            dt.shift();
            
        }
        else {
            dt.arcadeDrive(0,0);
            dt.shift();
        }
        if(fireButton)
        {
            dt.fire(0.9);
        }
        else{
            dt.fire(0.0);
        }
        dt.intakeBall(intakeTrigger, outtakeTrigger);
        
        
    }
    //code made by ari that sets the motors to a speed calculated by an equation ari wrote

	public double ariSpeedLeft(int x) {
		double result = (0.01257845050366*(double)x)-1.0104688571278;
		if (result > 1) {
			result = 1;
		}
		return result;
	}
	
	public double ariSpeedRight(int x) {
		double result = (-0.0125*(double)x)+3;
		if (result < -1) {
			result = -1;
		}
		return result;
	}
    public void lineUp() {
        cam.updateData();
        int x = cam.getX();
        //SmartDashboard.putNumber("X position ", x);
        //double speed = -0.4;
        if(joy.getRawButton(ControllerMap.Y_BUTTON)) {
            if(x > 0) {
                //dt.tankDrive(ariSpeedLeft(x) * speed, ariSpeedRight(x) * speed);
            }
        }
    }
    
}