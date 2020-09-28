package com.example.bean;
/**
* Create by 张瀛煜
* On Sep 28, 2020 9:16:45 AM
*/
public class carMove {
	private String CarId,CarAction;

	public carMove(String carId, String carAction) {
		super();
		CarId = carId;
		CarAction = carAction;
	}

	public String getCarId() {
		return CarId;
	}

	public void setCarId(String carId) {
		CarId = carId;
	}

	public String getCarAction() {
		return CarAction;
	}

	public void setCarAction(String carAction) {
		CarAction = carAction;
	}
	
}

