// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Chassis;
import frc.robot.RobotContainer;
import frc.robot.Constants.driverConstants;
import frc.robot.Constants.motorConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TestSwerve extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Chassis m_Chassis;

  /**
   * Creates a new TestSwerve.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TestSwerve(Chassis subsystem) {
    this.m_Chassis = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //get joystick values
    double forward = RobotContainer.m_DriverController.getRawAxis(driverConstants.Y_AXIS);
    double turn = RobotContainer.m_DriverController.getRawAxis(driverConstants.X_AXIS);

    //Deadband
    turn = (Math.abs(turn) <= driverConstants.CONT_DEADBAND) ? 0 : turn;
    forward = (Math.abs(forward) <= driverConstants.CONT_DEADBAND) ? 0 : forward;

    //drive motors
    if (true) {
      m_Chassis.move_motors(forward, turn);
    }
    


    //get encoder values for smartdashboard
    double[] encs = m_Chassis.get_encoder_values();

    SmartDashboard.putNumber("Front Left Drive Encoder", encs[0]);
    SmartDashboard.putNumber("Front Right Drive Encoder", encs[1]);
    SmartDashboard.putNumber("Back Right Drive Encoder", encs[2]);
    SmartDashboard.putNumber("Back Left Drive Encoder", encs[3]);

    SmartDashboard.putNumber("Front Left Turn Encoder", encs[4]);
    SmartDashboard.putNumber("Front Right Turn Encoder", encs[5]);
    SmartDashboard.putNumber("Back Right Turn Encoder", encs[6]);
    SmartDashboard.putNumber("Back Left Turn Encoder", encs[7]);

    SmartDashboard.putNumber("Front Left Abs Encoder", encs[8] - motorConstants.FL_ABS_ENC_OFFSET);
    SmartDashboard.putNumber("Front Right Abs Encoder", encs[9] - motorConstants.FR_ABS_ENC_OFFSET);
    SmartDashboard.putNumber("Back Right Abs Encoder", encs[10] - motorConstants.BR_ABS_ENC_OFFSET);
    SmartDashboard.putNumber("Back Left Abs Encoder", encs[11] - motorConstants.BL_ABS_ENC_OFFSET);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
