package org.usfirst.frc.team2851.robot.commands;

import org.usfirst.frc.team2851.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class moveIntake extends Command {
public double setPoint = 0;
    public moveIntake(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	this.setPoint = setPoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.setOutputRange(-.5, .5);
    	Robot.intake.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.intake.getPot() - setPoint) < 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stopActuation();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stopActuation();
    }
}
