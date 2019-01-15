package com.framgia.hepler;

public enum PAYMENT {
	CASH, ONLINE;
	@Override
	  public String toString() {
	      if (this == CASH) {
	          return "Payment when delivered";
	      } else {
	          return "Paymented";
	      }
	     
	  }
	
}
