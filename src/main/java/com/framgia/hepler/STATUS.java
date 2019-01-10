package com.framgia.hepler;

public enum STATUS {
	WAITING, ACCEPTED;
	@Override
	  public String toString() {
	      if (this == WAITING) {
	          return "WAITING";
	      } else {
	          return "ACCEPTED";
	      }
	     
	  }
}
