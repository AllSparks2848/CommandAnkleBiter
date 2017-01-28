package org.usfirst.frc.team2851.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class driveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public  Spark right1 = new Spark(0);
	public  Spark left1 = new Spark(1);
	public RobotDrive drivebase = new RobotDrive(right1,left1);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void takeJoystickInputs(double y, double x)
    {
    	drivebase.arcadeDrive(y,x);
    }
    
    public void stop()
    {
    	right1.set(0);
    	left1.set(0);
    }
}

