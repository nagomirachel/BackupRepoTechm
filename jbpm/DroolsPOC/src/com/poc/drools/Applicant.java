package com.poc.drools;

public class Applicant {	 	

		private String name;

	    private int age;

	    private boolean valid;
	    
	    private String ageRange;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public boolean isValid() {
			return valid;
		}

		public void setValid(boolean valid) {
			this.valid = valid;
		}

		public String getAgeRange() {
			return ageRange;
		}

		public void setAgeRange(String ageRange) {
			this.ageRange = ageRange;
		}
}
