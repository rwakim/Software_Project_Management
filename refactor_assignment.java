class Account {
    float principal;
    float rate;
    int daysActive;
    int accountType;

    public static final int  STANDARD = 0;
    public static final int  BUDGET = 1;
    public static final int  PREMIUM = 2;
    public static final int  PREMIUM_PLUS = 3;
   
  // over here it is easeier to define the function from the class account and then call it anywhere we want in the program
  
  float interestEarned() {
        return ( principal * (float) Math.exp( rate * (daysActive / 365.25 ) ) )
                - principal;
    }
  // this is also a method for checking if an account is premium or not. we can call it whenever we want. making use of the oop features that java gives
  
  public boolean isPremium() {
        if (accountType == Account.PREMIUM || accountType == Account.PREMIUM_PLUS)
            return true;
        else
            return false;
  }
}

float calculateFee(Account accounts[]) {
    float totalFee = 0;
    Account account;
    for (int i = 0; i < accounts.length; i++) {
        account = accounts[i];
        if ( account.isPremium() ){
            totalFee += BROKER_FEE_PERCENT * account.interestEarned(); /* on this particular line, it is better to make the 1.25% a constant such 
            that incase the value changes in the future then we can have from line 36 it changed just once in the code instead of looking under every nook 
         adn cranny for 1.25% 
         */
          
        }
    } 
    return totalFee;
}

static final double BROKER_FEE_PERCENT = 0.0125;
