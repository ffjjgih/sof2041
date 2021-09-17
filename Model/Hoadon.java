package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the hoadon database table.
 * 
 */
@Entity
@Table(name="hoadon")
@NamedQuery(name="Hoadon.findAll", query="SELECT h FROM Hoadon h")
public class Hoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idhoadon;

	private double gia;

	private int soluong;

	private Timestamp thoigian;

	//bi-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="idfood")
	private Food food;

	//bi-directional many-to-one association to Tonghoadon
	@OneToMany(mappedBy="hoadon")
	private List<Tonghoadon> tonghoadons;

	public Hoadon() {
	}

	public int getIdhoadon() {
		return this.idhoadon;
	}

	public void setIdhoadon(int idhoadon) {
		this.idhoadon = idhoadon;
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

	public Timestamp getThoigian() {
		return this.thoigian;
	}

	public void setThoigian(Timestamp thoigian) {
		this.thoigian = thoigian;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public List<Tonghoadon> getTonghoadons() {
		return this.tonghoadons;
	}

	public void setTonghoadons(List<Tonghoadon> tonghoadons) {
		this.tonghoadons = tonghoadons;
	}

	public Tonghoadon addTonghoadon(Tonghoadon tonghoadon) {
		getTonghoadons().add(tonghoadon);
		tonghoadon.setHoadon(this);

		return tonghoadon;
	}

	public Tonghoadon removeTonghoadon(Tonghoadon tonghoadon) {
		getTonghoadons().remove(tonghoadon);
		tonghoadon.setHoadon(null);

		return tonghoadon;
	}

}