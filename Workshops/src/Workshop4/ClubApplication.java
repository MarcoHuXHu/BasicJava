package Workshop4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Workshop3.Member;
// 当从Workshop3 引入Club, 会覆盖本Package下的Club
// 此时Club里面没有新增的功能, 如(addFacility...) 
//import Workshop3.Club;

public class ClubApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Club club = new Club ();

        // this annotation can ban warnings
        @SuppressWarnings(value="all")
        Member member1, member2, member3, member4, member5;

        member1 = club.addMember (null, "Einstein", "Albert");
        member2 = club.addMember ("Ruiz", "Picasso", "Pablo");
        member3 = club.addMember ("Lloyd","Webber","Andrew");
        member4 = club.addMember (null, "Baggio", "Roberto");
        member5 = club.addMember (null, "Raffles", "Stamford");

        //Member Addition Testing
        System.out.println ("Current Members:");
        club.showMembers();
        System.out.println ("Deleting " + member3);
        int id = member3.getMemberNumber ();
        club.removeMember (id);
        System.out.println ("Current members:");
        club.showMembers ();

        //Facility Testing
        club.addFacility("Lab", "Einstein's Experiment Area");
        club.addFacility ("Studio", "Picasso's Work Place");
        club.addFacility ("Room1", "Conference Room on Level 2");
        club.addFacility ("Room2", "Meeting Room on Level 3");
        club.show();
        
        // Test Booking Class
        System.out.println ();
        DateFormat df = new SimpleDateFormat ("d-MMM-yyyy H:mm");
        try {
        	Booking booking1 = new Booking(member1, club.getFacility("Room1"), df.parse("1-Aug-2007 09:00"), df.parse ("1-Aug-2007 12:00"));
        	booking1.show();
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

        // Test BadBookingException
        try {
        	Booking booking2 = new Booking(member1, club.getFacility("Room1"), df.parse("1-Aug-2007 15:00"), df.parse ("1-Aug-2007 14:00"));
        	booking2.show();
        } catch (BadBookingException be) {
        	System.out.println ("Bad Booking Exception: " + be.getMessage());
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

        // Test BookingRegister
        try {
        	BookingRegister register = new BookingRegister();
        	System.out.println ("Adding bookings for Room1 2-Aug-2007 9:00 to 12:00");
        	register.addBooking(member1, club.getFacility("Room1"), df.parse("2-Aug-2007 9:00"), df.parse ("2-Aug-2007 12:00"));
        	System.out.println ("Attempting to add bookings for Room1 in same time as above");
        	register.addBooking(member2, club.getFacility("Room1"), df.parse("2-Aug-2007 10:00"), df.parse ("2-Aug-2007 11:00"));
        } catch (BadBookingException be) {
        	System.out.println ("Bad Booking Exception: " + be.getMessage());
        } catch (Exception e) {
        	System.out.println ("Booking class error: " + e.getMessage());
        }

	}

}
