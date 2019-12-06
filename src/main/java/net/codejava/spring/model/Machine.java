package net.codejava.spring.model;

public class Machine {
	private int id;
	private String nr_Maszyny;
	private String kod;
	private String wydzial;
	private String gniazdo;
	private String sprawnosc;

	
	
	public Machine() {
	}

	public Machine(String nr_maszyny, String kod, String wydzial, String gniazdo,String sprawnosc) {
		this.nr_Maszyny = nr_maszyny;
		this.kod = kod;
		this.wydzial = wydzial;
		this.gniazdo = gniazdo;
		this.sprawnosc = sprawnosc;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNr_Maszyny() {
		return nr_Maszyny;
	}

	public void setNr_Maszyny(String nr_Maszyny) {
		this.nr_Maszyny = nr_Maszyny;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}

	public String getGniazdo() {
		return gniazdo;
	}

	public void setGniazdo(String gniazdo) {
		this.gniazdo = gniazdo;
	}

	public String getSprawnosc() {
		return sprawnosc;
	}

	public void setSprawnosc(String sprawnosc) {
		this.sprawnosc = sprawnosc;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", nr_Maszyny=" + nr_Maszyny + ", kod=" + kod + ", wydzial=" + wydzial
				+ ", gniazdo=" + gniazdo + ", sprawnosc=" + sprawnosc + "]";
	}



	
	



}
