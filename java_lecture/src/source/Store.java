
package source;

public class Store implements Comparable<Store> {

	private String addr;
	private String code;
	private String created_at;
	private double lat;
	private double lng;
	private String name;
	private String remain_stat;
	private String stock_at;
	private String type;
	private double distance;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(String createdAt) {
		this.created_at = createdAt;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemainStat() {
		return remain_stat;
	}

	public void setRemainStat(String remainStat) {
		this.remain_stat = remainStat;
	}

	public String getStockAt() {
		return stock_at;
	}

	public void setStockAt(String stockAt) {
		this.stock_at = stockAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Store [addr=" + addr + ", code=" + code + ", createdAt=" + created_at + ", lat=" + lat + ", lng=" + lng
				+ ", name=" + name + ", remainStat=" + remain_stat + ", stockAt=" + stock_at + ", type=" + type + "]";
	}

	@Override
	public int compareTo(Store o) {
		return Double.compare(this.distance, o.distance);
	}

}
