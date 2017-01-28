package org.usfirst.frc.team2851.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Intake extends PIDSubsystem {
public static double p = .1;
public static double i = 0;
public static double d = 0;
Spark intakeRoller = new Spark(0); 
Spark intakeMov = new Spark(1);
public static double MAXUP = 0.0,
MAXDOWN = 0.0;
Potentiometer pot = new AnalogPotentiometer(0,360,-30);
DigitalInput breakBeam = new DigitalInput(9);
    // Initialize your subsystem here
    public Intake() {
    	super("Intake",p,i,d);
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return pot.get();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	intakeMov.set(output);
    }
    public void intake()
    {
    	intakeRoller.set(.8);
    }
    
    public void stopIntake() {
    	intakeRoller.set(0);
    }
    
    public void stopActuation() {
    	intakeMov.set(0);
    }
    
    public void ActuateUp() {
    	intakeMov.set(.5);
    }
    
    public void ActuateDown() {
    	intakeMov.set(-.5);
    }
    
    public void spit()
    {
    	intakeRoller.set(-.8);
    }

	public double getPot() {
		return pot.get();
	}
	
	public boolean isBeamBroken() {
		return breakBeam.get();
	}

}
