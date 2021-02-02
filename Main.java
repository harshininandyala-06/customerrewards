import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

class Rewards {
    String customerName;
    int customerRewards[];
    int purchase_amount;
//    static int total;
    
    public Rewards(String customerName) {
            this.customerName = customerName;
            this.customerRewards = new int[13]; 
            this.purchase_amount=purchase_amount;
//            this.total=total;
            
    }
    
    void addReward(int month, int reward) {
            customerRewards[month] = reward;
    }
    
    
   //orerriding the toString() because it displays a hashcode value
    @Override
    public String toString() {
            String s = "Rewards earned by the Customer: " + customerName + "\n";
            for(int i=1; i<=12; i++) {
                    s += "Month " + i + ": Rewards " + customerRewards[i] +"\n";
            }
            return s;
    }
    
//    public void display()
//    {
//    	System.out.println("Rewards earned for the customer : "+name);
//    	for(int i=0;i<12;i++)
//    	{
//    		System.out.println("for the month ["+i+"] : "+"rewards :"+rewards[i]);
//    	}
//    }
}

public class Main {
        
        
        public static int earn_Rewards(int purchase_amount) {
                if(purchase_amount <= 50) {
                        return 0;
                }
                if(purchase_amount <= 100) {
                        return purchase_amount - 50;
                }
                return (purchase_amount - 100) * 2 + 50;
        }
        
//        private static int sum(int reward, int purchase_amount) {
//        	
//    		int total = reward+purchase_amount;
//    		return total;
//    	}


        public static void main(String[] args) {
        	

                
                
                 File file = new File("C:/Users/User/customer_details.txt");
                
                HashMap<String, Rewards> rewards = new HashMap<>();
                
                try {
                        Scanner reader = new Scanner(file);
                        
                               while(reader.hasNextLine()) {
                                String line = reader.nextLine();
                                
                                String tokens[] = line.split(",");
                                String customerName = tokens[0];
                                int purchase_amount = Integer.parseInt(tokens[1]);
                                int reward = earn_Rewards(purchase_amount);
                               // int total=sum(reward,purchase_amount);
                                int month = Integer.parseInt(tokens[2].split("-")[1]);
                                
                                
                                if(rewards.containsKey(customerName)) {
                                	rewards.get(customerName).addReward(month, reward);
                                } else {
                                        Rewards c = new Rewards(customerName);
                                        c.addReward(month, reward);
                                        rewards.put(customerName, c);
                                }
                        }
                        
                        reader.close();
                        for(Rewards c: rewards.values()) {
                                System.out.println(c);
                        }
                        
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                
                
                
                
        }

		
}