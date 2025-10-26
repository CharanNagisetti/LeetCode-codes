class Bank {
    ArrayList<Long> accounts=new ArrayList<>();
    public Bank(long[] balance) {
        for(long x: balance){
            accounts.add(x);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        int x=account1-1;
        int y=account2-1;
        if(account1>accounts.size() || account2>accounts.size()) return false;
        if(accounts.get(x)<money){
            return false;
        }
        accounts.set(x,accounts.get(x)-money);
        accounts.set(y,accounts.get(y)+money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>accounts.size()) return false;
        accounts.set(account-1,accounts.get(account-1)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>accounts.size()) return false;
        if(accounts.get(account-1)<money){
            return false;
        }
        accounts.set(account-1,accounts.get(account-1)-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */