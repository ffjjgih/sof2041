package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@Table(name="store")
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstore;

	@Column(name="address_store")
	private String addressStore;

	private String namestore;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="store")
	private List<Booking> bookings;

	public Store() {
	}

	public int getIdstore() {
		return this.idstore;
	}

	public void setIdstore(int idstore) {
		this.idstore = idstore;
	}

	public String getAddressStore() {
		return this.addressStore;
	}

	public void setAddressStore(String addressStore) {
		this.addressStore = addressStore;
	}

	public String getNamestore() {
		return this.namestore;
	}

	public void setNamestore(String namestore) {
		this.namestore = namestore;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setStore(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setStore(null);

		return booking;
	}

}