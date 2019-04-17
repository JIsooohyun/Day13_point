package com.sh.Start;

import com.sh.control.PointController;

public class Start {
	public static void main(String[] args) {
		PointController pointController = new PointController();
		try {
			pointController.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
