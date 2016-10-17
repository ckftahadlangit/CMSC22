public class Date{
		private int year;
		private int month;
		private int day;

	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 1000;
	}

	public Date(int year, int month, int day){
		setDate(year, month, day);
	}
	
	public void setDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear()	{
		return this.year;
	}

	public int getMonth(){
		return this.month;
	}

	public int getDay(){
		return this.day;
	}

	public void setYear(int year){
		if(this.year < 1000 || this.year > 9999){
			throw new IllegalArgumentException("Invalid Year!");
		}
		this.year = year;
	}

	public void setMonth(int month){
		if(this.month > 12 || this.month < 1){
			throw new IllegalArgumentException("INVALID MONTH");
		}
		this.month = month;
	}

	public void setDay(int day){
		if(this.month == 2){
			 if((isLeapYear(year) == true) && (day < 1 && day > 29)){
          			throw new IllegalArgumentException("There is no date beyond 29 in February!");
        		}else if((isLeapYear(year) == false) && (day < 1 && day > 28)){
           			throw new IllegalArgumentException("This year is not a leap year!");
		}else if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
			if(day < 1 && day > 30){
				throw new IllegalArgumentException("There is no date beyond 30 in this month!");
			}
		}else if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 ||this.month == 12){
			if(day < 1 && day > 31){
				throw new IllegalArgumentException("There is no date beyond 31 in this month!");
			}
		}
		this.day = day;
	}

	public boolean isLeapYear(int year){
	
    	if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
        	return true;
    	}else {
    		return false;
    	}
	}

	public void setDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public String toString(){
		return String.format("%02d/%02d/%02d", this.day, this.month, this.year);
	}

}
