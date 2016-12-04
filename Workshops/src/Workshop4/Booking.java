package Workshop4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Workshop2.Facility;
import Workshop3.Member;

public class Booking {
	
	private Member member;
	private Facility facility;
	private Date startDate, endDate;
	
	public Member getMember() { return member;}
	public Facility getFacility() {	return facility;}
	public Date getStartDate() { return startDate;}
	public Date getEndDate() { return endDate;}

	// constructor throws BadBookingException
	public Booking(Member member, Facility facility, Date date, Date date2) 
			throws BadBookingException {
		if (member == null)
			throw new BadBookingException("Invalid Member");
		if (facility == null)
			throw new BadBookingException("Invalid Facility");
		if ((date == null) || (date2 == null))
			throw new BadBookingException("Invalid startDate or endDate");
		if (date.compareTo(date2) > 0)
			throw new BadBookingException("startDate later than endDate");
		this.member = member;
		this.facility = facility;
		this.startDate = date;
		this.endDate = date2;
	}
	
	public boolean overlaps(Booking other) {
		if (this.facility == other.facility)
			if ((this.startDate.compareTo(other.endDate) * other.startDate.compareTo(this.endDate)) > 0)
				return true;
		return false;
	}
	
	private static DateFormat tf = new SimpleDateFormat ("d-MMM-yyyy H:mm");
//	public static final String DATE_FORMAT = "d-MMM-yyyy";
//	public static final String TIME_FORMAT = "d-MMM-yyyy H:mm";

	public String toString() {
		return ("Booking: " + facility.getName() + " (" + member + "): "
				+ tf.format(startDate) + " to " + tf.format(endDate));
	}
	public void show() {
		System.out.println(this);
	}
}
