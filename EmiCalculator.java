//*** Issue --- Child class instance is not able to access  Parent class method. ***


import java.util.*;
class Product
{
	public String productName, companyName;
	public Double price,downPayment,totalPrice;
	Scanner sc=new Scanner(System.in);
	public void input()
	{
		System.out.print("Enter Product Name:");
		productName=sc.nextLine();
		
		System.out.print("Enter Company Name:");
		companyName=sc.nextLine();
		
		System.out.print("Enter Total Price:");
		totalPrice=sc.nextDouble();
		
		System.out.print("Enter Down Payment(if made any):");
		downPayment=sc.nextDouble();
		
		price=totalPrice-downPayment;
	}
}
class Customer extends Product
{
	int timePeriod,ch,ch1;
	Double roi,downPayment;
	Scanner sc=new Scanner(System.in);
	public void input1()
	{
		System.out.print("Enter Time Period:");
		timePeriod=sc.nextInt();
		System.out.println("Choose? 1.Monthly  2.Yearly");
		ch=sc.nextInt();
		switch(ch)
		{
			case 1: break;
			case 2: timePeriod=timePeriod*12;
					break;
		}
		System.out.print("Enter Rate of Interest(monthly):");
		roi=sc.nextDouble(); 
		System.out.println("Choose? 1.Monthly  2.Yearly");
		ch1=sc.nextInt();
		switch(ch1)
		{
			case 1: break;
			case 2: roi=roi/12;
					break;
		}	
	}
}
class Main
{
	public static void main(String[] args)
	{
		Double emi,pow,interest,totalInterest,totalAmt;
		Product p=new Product();
		Customer obj=new Customer();
		obj.input();
		obj.input1();
		interest=obj.roi/100;
		pow=Math.pow((1+ interest),obj.timePeriod);
		System.out.println(" ");
		System.out.println("--------------------------------------------");
		System.out.println(" ");
		emi=(obj.price * interest * pow) / (pow -1);
		System.out.println("Emi for each month:"+String.format("%.2f",emi));
		totalInterest=(emi*obj.timePeriod)-obj.price;
		System.out.println("Total Interest to be paid:"+String.format("%.2f",totalInterest));
		totalAmt=emi*obj.timePeriod;
		System.out.println("Total Amount to be paid:"+String.format("%.2f",totalAmt));
	}
}
