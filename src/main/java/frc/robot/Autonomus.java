/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Package
package frc.robot;

//Imports
import frc.robot.subsys.DriveTrain;
import edu.wpi.first.wpilibj.SPI;

import java.util.Timer;

import com.kauailabs.navx.frc.AHRS;

/**
 * ( --- ) is a placeholder for
 * class-specific adjectives
 */

public class Autonomus {

    //Default Constructor
    public Autonomus() {
        navX.reset();  
    }

    // --- Objects
    AHRS navX = new AHRS(SPI.Port.kMXP);
    DriveTrain dt = new DriveTrain();
    Timer timer = new Timer();
    // --- Variables
    boolean x = false;
    boolean yeet = false;
    boolean endAutoFunction = false;
    int partOfAuto = 0;
    long startTime;
    double startAng;
    // Getters
    
    // Setters
    public void runAuto(){
        if(endAutoFunction == false){
            if(partOfAuto == 0){
                set45deg(85.0);
            }
            else if(partOfAuto == 1){
                driveMilliseconds(5000.0);
            }
            else{
                endAutoFunction = true;
                partOfAuto = 0;
            }
        }
    }
    public void tiltyBoi()
    {
        dt.tilt(0.75);
    }
    public void tiltyStop()
    {
        dt.tilt(0.5);
    }


    public void resetNavX()
    {
        navX.reset();
    }
    
    
    public void set45deg(double newAngle)
    {
        
            if(x == false)
            {
                startAng = navX.getAngle();
                x = true;
            }
            if(navX.getAngle() < (startAng + newAngle)){
                dt.arcadeDrive(0, .35);
            }
            else
            {
                dt.arcadeDrive(0, 0);
                partOfAuto++;
                //x = false;
            }
            System.out.println(startAng);
        
    }
    public void driveMilliseconds(double numMilliseconds)
    {
        if(yeet == false){
            startTime = System.currentTimeMillis();
            yeet = true;
        }
        if(System.currentTimeMillis() < (startTime + numMilliseconds)){
            dt.arcadeDrive(0.3, 0);
        }
        else{
            dt.arcadeDrive(0, 0);
            partOfAuto++;
            //yeet = false;
        }
    }
    
}

