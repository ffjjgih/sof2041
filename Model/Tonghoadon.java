package Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tonghoadon database table.
 * 
 */
@Entity
@Table(name="tonghoadon")
@NamedQuery(name="Tonghoadon.findAll", query="SELECT t FROM Tonghoadon t")
public class Tonghoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int soluong;

	//bi-directional many-to-one association to Hoadon
	@ManyToOne
	@JoinColumn(name="idhoadon")
	private Hoadon hoadon;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Tonghoadon() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Hoadon getHoadon() {
		return this.hoadon;
	}

	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}