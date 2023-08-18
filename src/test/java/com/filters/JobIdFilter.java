package com.filters;

import java.util.function.Predicate;

import com.ui.pojo.GlobalDetailsPojo;

public class JobIdFilter implements Predicate<GlobalDetailsPojo> {
	private String jobId;
	
	
	public JobIdFilter(String jobId) {
		super();
		this.jobId = jobId;
	}


	@Override
	public boolean test(GlobalDetailsPojo t) {
		if (t.getJobNumber().equalsIgnoreCase(jobId)) {
			return true;
		}
		else return false;
	}

}
