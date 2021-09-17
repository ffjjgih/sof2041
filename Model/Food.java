package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the food database table.
 * 
 */
@Entity
@Table(name="food")
@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int foodid;

	private String descriptions;

	private double gia;

	private String loai;

	private String namefood;

	private String poster;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="food")
	private List<Cart> carts;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="food")
	private List<Hoadon> hoadons;

	public Food() {
	}

	public int getFoodid() {
		return this.foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public double getGia() {
		return this.gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getLoai() {
		return this.loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getNamefood() {
		return this.namefood;
	}

	public void setNamefood(String namefood) {
		this.namefood = namefood;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setFood(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setFood(null);

		return cart;
	}

	public List<Hoadon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<Hoadon> hoadons) {
		this.hoadons = hoadons;
	}

	public Hoadon addHoadon(Hoadon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setFood(this);

		return hoadon;
	}

	public Hoadon removeHoadon(Hoadon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setFood(null);

		return hoadon;
	}

}