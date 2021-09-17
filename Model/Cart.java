package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@Table(name="cart")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartid;

	private double gia;

	private int soluong;

	private Timestamp thoigiandathang;

	//bi-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="foodid")
	private Food food;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Cart() {
	}

	public int getCartid() {
		return this.cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public double getGia() {
		return this.gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Timestamp getThoigiandathang() {
		return this.thoigiandathang;
	}

	public void setThoigiandathang(Timestamp thoigiandathang) {
		this.thoigiandathang = thoigiandathang;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}