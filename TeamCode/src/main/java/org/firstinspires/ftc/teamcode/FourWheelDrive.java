package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Team Inspiration on 1/21/18.
 */
@TeleOp(name = "Four Wheel Drive Two")

public class FourWheelDrive extends OpMode {

    DcMotor leftWheelMotorFront;
    DcMotor leftWheelMotorBack;
    DcMotor rightWheelMotorFront;
    DcMotor rightWheelMotorBack;
    //All the hardware

    @Override
    public void init() {

        leftWheelMotorFront = hardwareMap.dcMotor.get("leftWheelMotorFront");
        leftWheelMotorBack = hardwareMap.dcMotor.get("leftWheelMotorBack");
        rightWheelMotorFront = hardwareMap.dcMotor.get("rightWheelMotorFront");
        rightWheelMotorBack = hardwareMap.dcMotor.get("rightWheelMotorBack");

        //declaration of all hardware to the config file

        leftWheelMotorFront.setDirection(DcMotor.Direction.REVERSE);
        leftWheelMotorBack.setDirection(DcMotor.Direction.REVERSE);

        //reverses some motors to work normally
    }


    @Override
    public void loop() {
       Drive();
       //Each function running is a compilation of all the functions for that major hardware device
    }

    public void Drive(){
        FourWheelDrive();
    }

    public void FourWheelDrive() {

        float leftY_gp1 = (-gamepad1.left_stick_y);
        float rightY_gp1 = (-gamepad1.right_stick_y);
        boolean dPad_Left = gamepad1.dpad_left;
        boolean dPad_Right = gamepad1.dpad_right;
        telemetry.addData("right power input", rightY_gp1);
        telemetry.addData("left power input", leftY_gp1);

        if (dPad_Left) {
            leftWheelMotorBack.setPower(-1);
            leftWheelMotorFront.setPower(1);
            rightWheelMotorBack.setPower(1);
            rightWheelMotorFront.setPower(-1);
            //code to strafe left
        }

        else if (dPad_Right) {
            leftWheelMotorBack.setPower(1);
            leftWheelMotorFront.setPower(-1);
            rightWheelMotorBack.setPower(-1);
            rightWheelMotorFront.setPower(1);
            //code to strafe right
        }

        else {
            leftWheelMotorBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftWheelMotorFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightWheelMotorBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightWheelMotorFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftWheelMotorFront.setPower(leftY_gp1);
            leftWheelMotorBack.setPower(leftY_gp1);
            rightWheelMotorFront.setPower(rightY_gp1);
            rightWheelMotorBack.setPower(rightY_gp1);

            //I made this an if-if else- else statement so that driving forward/strafing does not override
            //each other
        }
    }
}
