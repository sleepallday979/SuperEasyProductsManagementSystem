package model;

public class Product {
	private int id;    //���
	private String name;  //��Ʒ��
	private double price;  //��Ʒ�۸�
	private int num;  //��Ʒ���
	private String size;  //��Ʒ�ߴ� С �� ��
	private String time;  //��Ʒ���ʱ�� ������  2000.03.26
	private double weight;  //��Ʒ��������
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, float price, int num, String size, String time, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
		this.size = size;
		this.time = time;
		this.weight = weight;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Product p=(Product)obj;
		if(id==p.getId()){
			return true;
		}else 
			return false;
	}
}
