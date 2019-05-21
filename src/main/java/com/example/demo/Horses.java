package com.example.demo;

import java.sql.Date;

public class Horses {
    private Long microchip;
    private String horseName;
    private Date dateOfBirth;
	//private String FName;
	//private String SName;
    
   

    Horses(Long microchip, String horseName, Date dateOfBirth)
    {
        this.microchip = microchip;
        this.horseName = horseName;
        this.dateOfBirth = dateOfBirth;
		//this.FName = FName;
		//this.SName = SName;
       
    }

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateofBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	//public String getFName() {
	//	return FName;
	//}

	//public void setFName(String FName) {
	//	this.FName = FName;
	//}

	//public String getSName() {
	//	return SName;
	//}

	//public void setSName(String SName) {
	//	this.SName = SName;
	//}

	public Long getMicrochip() {
		return microchip;
	}

	public void setMicrochip(Long microchip) {
		this.microchip = microchip;
	}
}