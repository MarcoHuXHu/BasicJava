package Workshop4;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import Workshop2.Facility;
import Workshop3.Member;

public class BookingRegister {
	HashMap<Facility, ArrayList<Booking>> bookings;
	// constructor
	public BookingRegister() {
		bookings = new HashMap<Facility, ArrayList<Booking>>(); 
	}
	
	public Booking addBooking(Member member, Facility facility, Date startDate, Date endDate) 
			throws BadBookingException {
		// Since constructor of Booking throw BadBookingException, method which calls it should also throw same Exception
		Booking booking = new Booking(member, facility, startDate, endDate);
		// HashMap contains no key, create a new booking ArrayList for it
		if (!bookings.containsKey(facility)) {
			bookings.put(facility, new ArrayList<Booking>());
		} 
		else {
			// Check date overlap
			for (Booking bk : bookings.get(facility)) {
				if (bk.overlaps(booking))
					throw new BadBookingException("Date Overlap with " + bk.toString());
			}
		}
		// No overlap so add booking
		bookings.get(facility).add(booking);
		return booking;
	}
	public ArrayList<Booking> getBookings(Facility facility, Date startDate, Date endDate) {
		ArrayList<Booking> result = new ArrayList<Booking>();
		for (Booking booking : bookings.get(facility)) {
			if ((booking.getStartDate().after(startDate)) && (booking.getEndDate().before(endDate)))
				result.add(booking);
		}
		return result;
	}
	public void removeBooking(Booking booking) {
		ArrayList<Booking> bookingsWithSameFacility = bookings.get(booking.getFacility());
		// change bookingsWithSameFacility will affect the ArrayList which is the value of the HashMap bookings 
		// bookingsWithSameFacility的引用指向要删掉的booking的facility在HashMap中指向的ArrayList, 即指向booking所属的ArrayList
		// 对bookingsWithSameFacility进行操作, 即对HashMap索引出来的ArrayList操作
		bookingsWithSameFacility.remove(booking);
	}
}