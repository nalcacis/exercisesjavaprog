package be.abis.exercise.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

public class Course {
	private String title;
	private int days;
	private double dailyPrice;
	private LocalDate releaseDate;

	public Course(String title, int days, double dailyPrice, LocalDate releaseDate) {
		this.title = title;
		this.days = days;
		this.dailyPrice = dailyPrice;
		this.releaseDate=releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}


	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	@Override
	public String toString() {
		return "title:" + this.getTitle() + " , duration:" + this.getDays() + " , price:" + this.getDailyPrice() + " , release date:" + releaseDate.format(DateTimeFormatter.ofPattern("d/M/yyyy"));
	}

	public double calculatePriceWithVAT(){
		return days*dailyPrice*1.21;
	}
}