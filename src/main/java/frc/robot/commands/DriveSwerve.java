// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Chassis;
import frc.robot.RobotContainer;
import frc.robot.Constants.driverConstants;
import frc.robot.Constants.motorConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
//import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveSwerve extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Chassis m_Chassis;

  /**
   * Creates a new DriveSwerve.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveSwerve(Chassis subsystem) {
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
    //swerve code adapted from:
    // https://github.com/SeanSun6814/FRC0ToAutonomous

    //1. get joystick values
    double xSpeed = RobotContainer.m_DriverController.getRawAxis(driverConstants.X_AXIS);
    double ySpeed = RobotContainer.m_DriverController.getRawAxis(driverConstants.Y_AXIS);
    double turningSpeed = RobotContainer.m_DriverController.getRawAxis(driverConstants.Z_AXIS);
    
    //2. Deadband
    xSpeed = (Math.abs(xSpeed) <= driverConstants.CONT_DEADBAND) ? 0 : xSpeed;
    ySpeed = (Math.abs(ySpeed) <= driverConstants.CONT_DEADBAND) ? 0 : ySpeed;
    ySpeed = (Math.abs(turningSpeed) <= driverConstants.CONT_DEADBAND) ? 0 : turningSpeed;

    // 3. Make the driving smoother
    //xSpeed = xLimiter.calculate(xSpeed) * DriveConstants.kTeleDriveMaxSpeedMetersPerSecond;
    //ySpeed = yLimiter.calculate(ySpeed) * DriveConstants.kTeleDriveMaxSpeedMetersPerSecond;
    //turningSpeed = turningLimiter.calculate(turningSpeed)* DriveConstants.kTeleDriveMaxAngularSpeedRadiansPerSecond;

    // 4. Construct desired chassis speeds
    
    /*
    ChassisSpeeds chassisSpeeds;

    if (fieldOrientedFunction.get()) {
        // Relative to field
        chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(
                xSpeed, ySpeed, turningSpeed, swerveSubsystem.getRotation2d());
    } else {
        // Relative to robot
        chassisSpeeds = new ChassisSpeeds(xSpeed, ySpeed, turningSpeed);
    }
    */

    // 5. Convert chassis speeds to individual module states
    //SwerveModuleState[] moduleStates = DriveConstants.kDriveKinematics.toSwerveModuleStates(chassisSpeeds);

    // 6. Output each module states to wheels
    //swerveSubsystem.setModuleStates(moduleStates);
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
