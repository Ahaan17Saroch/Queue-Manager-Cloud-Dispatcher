package com.allen.sa;

import com.allen.template.Template;

/**
 * Class holding information on a SA.
 * 
 * @author Allen Qian
 */

public class SA extends Template implements Comparable<SA>{

	@Override
	public int compareTo(SA sa) {
		// TODO Auto-generated method stub
		if (this.getSum() < sa.getSum()) {
			return -1;
		} else if (this.getSum() > sa.getSum()) {
			return 1;
		} 
		
		if (super.getSa()==(double)0 || sa.getSa()==(double)0) {
			return 0;
		}
		double thisScore = super.getSa() * 0.80 + (super.getSum()-super.getSa())/super.getSa() * 0.20 + 10;
		double saScore = sa.getSa() * 0.80 + (sa.getSum()-sa.getSa())/sa.getSa() * 0.20 + 10;

		if (saScore > thisScore) {
			return -1;
		}
		if (saScore < thisScore) {
			return 1;
		}
		return 0;
	}
}
