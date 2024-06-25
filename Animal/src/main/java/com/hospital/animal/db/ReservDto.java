package com.hospital.animal.db;

import java.sql.Timestamp;
import java.util.Date;

public class ReservDto {
	
	private int reserveId;
    private Timestamp  reserveDate;
    private int reserveHour;
    private String userId;
    private String animalName;
    private String symptom;
    private boolean reserveResult;
    
	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public Timestamp getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getReserveHour() {
		return reserveHour;
	}
	public void setReserveHour(int reserveHour) {
		this.reserveHour = reserveHour;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public boolean isReserveResult() {
		return reserveResult;
	}
	public void setReserveResult(boolean reserveResult) {
		this.reserveResult = reserveResult;
	}


}
