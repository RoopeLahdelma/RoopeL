package ds3gil.model;

public class WeaponList {
	public int id;
	public String types;
	public String buildtype;
	public String lisat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getBuildtype() {
		return buildtype;
	}
	public void setBuildtype(String buildtype) {
		this.buildtype = buildtype;
	}
	public String getLisat() {
		return lisat;
	}
	public void setLisat(String lisat) {
		this.lisat = lisat;
	}
	public WeaponList(int id, String types, String buildtype, String lisat) {
		super();
		this.id = id;
		this.types = types;
		this.buildtype = buildtype;
		this.lisat = lisat;
	}
	public WeaponList(String types, String buildtype, String lisat) {
		super();
		this.id = 0;
		this.types = types;
		this.buildtype = buildtype;
		this.lisat = lisat;
	}
	@Override
	public String toString() {
		return "WeaponList [id=" + id + ", types=" + types + ", buildtype=" + buildtype + ", lisat=" + lisat + "]";
	}
	
}
