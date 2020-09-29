package lastquestion;

public class Store implements Comparable<Store> { // 정렬 위한 Comparable<Store> 구현

	private String addr;
	private String code;
	private String created_at;
	private Double lat;
	private Double lng;
	private String name;
	private String remain_stat;
	private String stock_at;
	private String type;
	private Double distance;

	@Override
	public int compareTo(Store o) { // 오름차순 정렬을 위한
		return this.distance.compareTo(o.distance);
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

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

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
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

	@Override
	public String toString() {
		return "Store [addr=" + addr + ", code=" + code + ", created_at=" + created_at + ", lat=" + lat + ", lng=" + lng
				+ ", name=" + name + ", remain_stat=" + remain_stat + ", stock_at=" + stock_at + ", type=" + type
				+ ", distance=" + distance + "]";
	}

}