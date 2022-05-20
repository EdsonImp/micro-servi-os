package projeto.hrpayroll.entities;

public class Payment {
	private String name;
	private Double dayleIncome;
	private Integer days;
	
	public Payment() {
		
	}

	public Payment(String name, Double dayleIncome, Integer days) {
		super();
		this.name = name;
		this.dayleIncome = dayleIncome;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDayleIncome() {
		return dayleIncome;
	}

	public void setDayleIncome(Double dayleIncome) {
		this.dayleIncome = dayleIncome;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	public double getTotal() {
		return days * dayleIncome;
	}

}
