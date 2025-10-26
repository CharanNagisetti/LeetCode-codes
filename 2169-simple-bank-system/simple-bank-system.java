class Bank {
    long[] accounts;
    public Bank(long[] balance) {
        this.accounts=balance;
    }
    private boolean isValid(int account) {
        return account > 0 && account <= accounts.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(!isValid(account1) || !isValid(account2)) return false;
        int x=account1-1;
        int y=account2-1;
        if(accounts[x]<money) return false;
        accounts[x]-=money;
        accounts[y]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!isValid(account)) return false;
        accounts[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!isValid(account)) return false;
        if(accounts[account-1]<money) return false;
        accounts[account-1]-=money;
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