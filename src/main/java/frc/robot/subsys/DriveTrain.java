/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Package
package frc.robot.subsys;

//Imports
import frc.robot.vars.Motors;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.vars.ControllerMap;

public class DriveTrain {
    private int shiftIf;
    public DriveTrain() {
        Motors.leftMotor.setInverted(true);
        Motors.rightMotor.setInverted(true);
    }

    /*public void tankDrive(double left, double right) {
        left *= 1; right *= 1;
        double nvar = 0.2;
        Motors.leftFront.set(-nvar * left);
        Motors.leftBack.set(nvar * left);
        Motors.rightFront.set(nvar * right);
        Motors.rightBack.set(-nvar * right);
    }*/
    
    /*public void arcadeDrive(double throttle, double turnVal) {
        throttle *= 1; turnVal *= 1;
        double nvar = 0.8;
        Motors.leftFront.set(-nvar * (throttle - turnVal));
        Motors.leftBack.set(nvar * (throttle - turnVal));
        Motors.rightFront.set(nvar * (throttle + turnVal));
        Motors.rightBack.set(-nvar * (throttle + turnVal));
    }*/

    public void arcadeDrive(double throttle, double turnVal)
    {
        double nvar = 1;
        Motors.leftMotor.set(ControlMode.PercentOutput, (nvar * (throttle + turnVal)));
        Motors.rightMotor.set(ControlMode.PercentOutput, (-nvar * (throttle - turnVal)));
    }
    public void fire(double percentFire)
    {
        Motors.flywheelMotor.set(ControlMode.PercentOutput, percentFire);
    }
    public void intakeBall(double percentIntake, double percentOuttake)
    {
        Motors.intakeMotor.set(ControlMode.PercentOutput, (percentIntake - percentOuttake));
    }
    public void tilt(double yeet)
    {
        Motors.ariTiltCam.set(yeet);
    }
    /*----------------------------------------------------------------------------*/
    public void shift()
    {   
        Joystick njoy = new Joystick(ControllerMap.DRIVER_PORT);
		if(njoy.getRawButton(5)) { //LB, aka downshift
			shiftIf = 0;
		}
		else if(njoy.getRawButton(6)) { //RB, aka upshift
			shiftIf = 1;
		}
		if(shiftIf == 1){
			Motors.servoLeft.set(0.3); //not really sure why I set the servos independently but it works so that's that
			Motors.servoRight.set(0.3); //upshift
		}
		else if(shiftIf == 0) {
			Motors.servoLeft.set(0.7); //downshift
			Motors.servoRight.set(0.7);
        }
    }
    /*----------------------------------------------------------------------------*/
    
}