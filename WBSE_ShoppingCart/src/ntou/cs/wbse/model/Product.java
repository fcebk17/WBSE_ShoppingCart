package ntou.cs.wbse.model;

public class Product
{
	private String name;
	private int unitPrice;
	private int quantity;

	public Product (String name, int unitPrice, int quantity)
	{
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public int getUnitPrice ()
	{
		return unitPrice;
	}

	public void setUnitPrice (int unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public int getQuantity ()
	{
		return quantity;
	}

	public void setQuantity (int quantity)
	{
		this.quantity = quantity;
	}

	@Override
	public String toString ()
	{
		return "Product [name=" + name + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + "]";
	}
}
