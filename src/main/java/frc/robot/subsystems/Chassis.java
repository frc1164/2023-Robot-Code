// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//import frc.robot.Constants.characterizationConstants;
import frc.robot.Constants.motorConstants;
import com.ctre.phoenix.sensors.CANCoder;



import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

public class Chassis extends SubsystemBase {

  private CANSparkMax fldMot = new CANSparkMax(motorConstants.FL_DRIVE_SPEED_CONT, MotorType.kBrushless);
  private CANSparkMax fltMot = new CANSparkMax(motorConstants.FL_TURNING_SPEED_CONT, MotorType.kBrushless);

  private CANSparkMax frdMot = new CANSparkMax(motorConstants.FR_DRIVE_SPEED_CONT, MotorType.kBrushless);
  private CANSparkMax frtMot = new CANSparkMax(motorConstants.FR_TURNING_SPEED_CONT, MotorType.kBrushless);

  private CANSparkMax brdMot = new CANSparkMax(motorConstants.BR_DRIVE_SPEED_CONT, MotorType.kBrushless);
  private CANSparkMax brtMot = new CANSparkMax(motorConstants.BR_TURNING_SPEED_CONT, MotorType.kBrushless);

  private CANSparkMax bldMot = new CANSparkMax(motorConstants.BL_DRIVE_SPEED_CONT, MotorType.kBrushless);
  private CANSparkMax bltMot = new CANSparkMax(motorConstants.BL_TURNING_SPEED_CONT, MotorType.kBrushless);


  private CANCoder flEnc = new CANCoder(motorConstants.FL_ABS_ENC);
  private CANCoder frEnc = new CANCoder(motorConstants.FR_ABS_ENC);
  private CANCoder brEnc = new CANCoder(motorConstants.BR_ABS_ENC);
  private CANCoder blEnc = new CANCoder(motorConstants.BL_ABS_ENC);
  


  /** Creates a new ExampleSubsystem. */
  public Chassis() {
    //idle all motors
    fldMot.setIdleMode(IdleMode.kCoast);
    fltMot.setIdleMode(IdleMode.kCoast);

    frdMot.setIdleMode(IdleMode.kCoast);
    frtMot.setIdleMode(IdleMode.kCoast);

    brdMot.setIdleMode(IdleMode.kCoast);
    brtMot.setIdleMode(IdleMode.kCoast);

    bldMot.setIdleMode(IdleMode.kCoast);
    bltMot.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void move_motors(double fwd, double rot) {
    fldMot.set(fwd);
    frdMot.set(fwd);
    brdMot.set(fwd);
    bldMot.set(fwd);

    fltMot.set(rot);
    frtMot.set(rot);
    brtMot.set(rot);
    bltMot.set(rot);
  }

  public double[] get_encoder_values() {

    double[] myRet = {
      fldMot.getEncoder().getPosition(),
      frdMot.getEncoder().getPosition(),
      brdMot.getEncoder().getPosition(),
      bldMot.getEncoder().getPosition(),
      fltMot.getEncoder().getPosition(),
      frtMot.getEncoder().getPosition(),
      brtMot.getEncoder().getPosition(),
      bltMot.getEncoder().getPosition(),
      
      flEnc.getAbsolutePosition(),
      frEnc.getAbsolutePosition(),
      brEnc.getAbsolutePosition(),
      blEnc.getAbsolutePosition()
      
      };

    return myRet;
  }



}
