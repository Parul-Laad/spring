package hexaware2;

@FunctionalInterface
interface Calculate {
    int operate(int a, int b);
}

@FunctionalInterface
interface SimBill {
	int callBill(int noOfCall); 
}

@FunctionalInterface
interface Item {
    int itemCode = 100;
    double discountTV = 0.25; 
    double discountBook = 0.05; 

    void calBill();


    default void sale() {
        System.out.println("Sale on Tv 25%");
        System.out.println("Sale on book 5%");
    }
}

 class TV implements Item {
        private double price;

        // Constructor
        TV(double price) {
            this.price = price;
        }

        @Override
        public void calBill() {
            double finalPrice = price - (price * Item.discountTV);
            System.out.println("TV Final Price " + finalPrice);
        }
    }

    class Book implements Item {
        private double price;

        Book(double price) {
            this.price = price;
        }

        @Override
        public void calBill() {
            double finalPrice = price - (price * Item.discountBook);
            System.out.println("Book Final Price " + finalPrice);
        }
    }
    
  
 interface Employee{
	 String getName();
	 Double getSal();
	 
 }

 public class LambdaExpressionExample {
	    public static void main(String[] args) {
	        Employee emp1 = new Employee() {
	            @Override
	            public String getName() {
	                return "Ajay";
	            }

	            @Override
	            public Double getSal() {
	                return 6000.0;
	            }
	        };
	        
	        System.out.println(emp1.getName());
	        System.out.println(emp1.getSal());
	    }

	
	/*
	public static void main(String[] args) {
        Item myTV = new TV(10000); 
        myTV.calBill(); 
        myTV.sale(); 

        Item myBook = new Book(500); 
        myBook.calBill(); 
        myBook.sale();  
    }
    */

	
	
	    /*
	
	   public static void main(String[] args) {
	        Calculate sum = (a, b) -> a + b;
	        System.out.println("Sum: " + sum.operate(10, 30));
	        
	        Calculate sub = (a, b) -> a - b;
	        System.out.println("Subtraction: " + sub.operate(5, 1));
	        
	        SimBill Vodafone = (noOfCall) -> noOfCall*5;
	        System.out.println("Vodafone Bill is: " + Vodafone.callBill(10));
	        
	        SimBill Jio = (noOfCall) -> noOfCall*2;
	        System.out.println("Jio Bill is: " + Jio.callBill(10));
	        
	    }
	    */
	
}

/*
 * @FuntionalInterface
Interface Calculate
{
int operate(int a,int b);
 
}
 
class sum implements Calculate
{
int operate(int a,int b)
{
int c=a+b;
return (c);
}
 
 
}
class sub implements Calculate
{
int operate(int a,int b)
{
int c=a-b;
return (c);
}
 
 
}
class mul implements Calculate
{
int operate(int a,int b)
{
int c=a*b;
return (c);
}
 
 
}
 
 
class Main
{
  void main()
{
Sum s1 = new Sum();
s1.operate(3,4)
Sub s1 = new Sub();
s1.operate(3,4)
}
 
}
 
 
 
 */


/*@functionalInterface 
sim
calBill(int noOfCall)
 
 
 
          Vodaphone                    airtel
         5     
         
         
  */


/*
 * @FunctionalInterface
Interface Item
{
 
  int itemcode;
  Double Price,dis;
 
  void calBill();
 
   default void sale()
{
    sop("Sales 20%");
 
}
 
 
}
 */

/* 
 * interface Employee

{
 
 
String getName();
Double getSal();
}
 
 
class Demo
{
 
  void main()
{
Employee software = new Employee()
{
 
String getName()
{
return "Ajay"
}
 
Double getSal();
{
return 6000.0;
}

 
 
}
 
 
sop(software.getName())
sop(software.getSalary())
 
;

 
}
}
 
 
 
 

}
 
}  */





