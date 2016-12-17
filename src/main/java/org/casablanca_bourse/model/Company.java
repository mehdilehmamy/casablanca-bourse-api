package org.casablanca_bourse.model;

public class Company {

	private String name;
	
	private String status;
	private Double referencePrice;
	private Double open;
	private Double lastPrice;
	private Integer numberOfSharesTraded;
	private Double volume;
	private Double change;
	private Double intradayHigh;
	private Double intradayLow;
	
	public Company(String name, String status, Double referencePrice, Double open, Double lastPrice,
			Integer numberOfSharesTraded, Double volume, Double change, Double intradayHigh, Double intradayLow) {
		setName(name);
		setStatus(status);
		setReferencePrice(referencePrice);
		setOpen(open);
		setLastPrice(lastPrice);
		setNumberOfSharesTraded(numberOfSharesTraded);
		setVolume(volume);
		setChange(change);
		setIntradayHigh(intradayHigh);
		setIntradayLow(intradayLow);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getReferencePrice() {
		return referencePrice;
	}
	public void setReferencePrice(Double referencePrice) {
		this.referencePrice = referencePrice;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public Integer getNumberOfSharesTraded() {
		return numberOfSharesTraded;
	}
	public void setNumberOfSharesTraded(Integer numberOfSharesTraded) {
		this.numberOfSharesTraded = numberOfSharesTraded;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public Double getIntradayHigh() {
		return intradayHigh;
	}
	public void setIntradayHigh(Double intradayHigh) {
		this.intradayHigh = intradayHigh;
	}
	public Double getIntradayLow() {
		return intradayLow;
	}
	public void setIntradayLow(Double intradayLow) {
		this.intradayLow = intradayLow;
	}
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", status=" + status + ", referencePrice=" + referencePrice + ", open=" + open
				+ ", lastPrice=" + lastPrice + ", numberOfSharesTraded=" + numberOfSharesTraded + ", volume=" + volume
				+ ", change=" + change + ", intradayHigh=" + intradayHigh + ", intradayLow=" + intradayLow + "]";
	}

}
