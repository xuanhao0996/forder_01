package com.framgia.hepler;

public enum ROLES {
	ADMIN,USER;
	@Override
	  public String toString() {
	      if (this == ADMIN) {
	          return "ROLE_ADMIN";
	      } else {
	          return "ROLE_USER";
	      }
	     
	  }
	
}
