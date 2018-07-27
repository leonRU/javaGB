package lesson_5;

public class Worker {
	
	private String name;
	private String post;
	private String email;
	private String phone_number;
	private int salary;
	private int age;
	
	public Worker() {}
	
	public Worker(String name, String post, String email, String phone_number, int salary, int age) {
		this.name = name;
		this.post = post;
		this.email = email;
		this.phone_number = phone_number;
		this.salary = salary;
		this.age = age;
	}
	
	public void getInfo() {
		System.out.println("Name = " + name); 
		System.out.println("Post = " + post);
		System.out.println("Email = " + email);
		System.out.println("Phone number = " + phone_number);
		System.out.println("Salary = " + salary);
		System.out.println("Age = " + age);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Worker w1 = new Worker("randomName1", "randomPost1", "randomEmail1", "randomPhoneNumber1", 50000, 45);
		//w1.getInfo();
		Worker[] workerArray = new Worker[5];
		workerArray[0] = w1;
		workerArray[1] = new Worker("name2", "post2", "email2", "phone2", 40000, 23);
		workerArray[2] = new Worker("name3", "post32", "email32", "phone32", 44000, 43);
		workerArray[3] = new Worker("name42", "post42", "email42", "phone42", 44444, 40);
		workerArray[4] = new Worker("name52", "post52", "email52", "phone52", 60000, 53);
		
		
		for(int i = 0; i < workerArray.length; i++) {
			if(workerArray[i].age > 40) {
				workerArray[i].getInfo();
			}
		}
		
	}	
}
