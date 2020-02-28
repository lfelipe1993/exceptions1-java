package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//getTime devolve a quantidade em milissegundos da data
		long diff = checkOut.getTime() - checkIn.getTime();
		
		//converter milissegundos em dias
		//TimeUnit � um tipo enumerado complexo(classe) para realizar conversoes
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates(Date checkIn,Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ " CheckIn: "
				+ sdf.format(checkIn)
				+ " CheckOut: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " Nights";
	}

}