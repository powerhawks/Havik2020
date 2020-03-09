/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Package
package frc.robot.util;

//Imports

public class util {
    /**
     * Maps a value from one range to another
     * Example: 5 in range 1-10 is 50 in range 1-100
     * @param x is the value whose range is to be changed
     * @param inMin is the minimum of the input value range
     * @param inMax is the maximum of the input value range
     * @param outMin is the minimum of the output value range
     * @param outMax is the maximum of the output value range
     * @return "x" in the same relative position of the output range as it was in the input
     */
    public static double map(double x, double inMin, double inMax, double outMin, double outMax) {
        return (x - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }
    
    /**
     * Method that checks if a value is within a certain bound of a target
     * Example: is 5 in range of 7 +/- 2 --> TRUE
     *          is 6 in range of 10 +/- 3 --> FALSE
     * This is most commonly used to create a deadzone for maneuvers
     * @param x is the value to be checked
     * @param bound is the +/- range of the target value
     * @param target is the target "x" is being check against
     * @return if "x" is in range of the target
     */
    public static boolean isInRange(double x, double bound, double target) {
        return x <= target+bound && x >= target-bound;
    }

    /**
     * Method that checks if a value is out of a certain range
     * Example: is 5 out of range of -1 to 1 --> TRUE
     *          is 0.01 out of range of -0.1 to 0.1 --> FALSE
     * This is most commonly used as a noise fiter for joystick input
     * @param x the value to be checked
     * @param bound the +/- range of the bound
     * @return if "x" is out of the target bounds
     */
    public static boolean isOutofRange(double x, double bound) {
        return x <= -bound || x >= bound;
    }
}