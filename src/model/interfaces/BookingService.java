package model.interfaces;

import java.util.Date;
public class BookingService{
    void bookTable(int tableId, int userId, Date date);
    void cancelBooking(int bookId);
}
