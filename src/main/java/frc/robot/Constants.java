// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class motorConstants {
        public static final int FL_DRIVE_SPEED_CONT = 10;
        public static final int FL_TURNING_SPEED_CONT = 11;
        public static final int FL_ABS_ENC = 12;
        public static final double FL_ABS_ENC_OFFSET = 167.695;


        public static final int FR_DRIVE_SPEED_CONT = 20;
        public static final int FR_TURNING_SPEED_CONT = 21;
        public static final int FR_ABS_ENC = 22;
        public static final double FR_ABS_ENC_OFFSET = 102.919;


        public static final int BR_DRIVE_SPEED_CONT = 30;
        public static final int BR_TURNING_SPEED_CONT = 31;
        public static final int BR_ABS_ENC = 32;
        public static final double BR_ABS_ENC_OFFSET = 65.742;


        public static final int BL_DRIVE_SPEED_CONT = 40;
        public static final int BL_TURNING_SPEED_CONT = 41;
        public static final int BL_ABS_ENC = 42;
        public static final double BL_ABS_ENC_OFFSET = 45.000;
        

    }

    public static final class driverConstants {
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;
        public static final int X_AXIS = 0;
        public static final int Y_AXIS = 1;
        public static final int Z_AXIS = 2;
        public static final int X_ROTATE = 3;

        public static final double CONT_DEADBAND = 0.1;
    }


}
