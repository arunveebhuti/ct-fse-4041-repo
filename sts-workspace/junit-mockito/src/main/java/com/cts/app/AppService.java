package com.cts.app;

public class AppService {
	
	private AppRepo repo;

	public AppRepo getRepo() {
		return repo;
	}

	public void setRepo(AppRepo repo) {
		this.repo = repo;
	}
	
	
	public String addData() {
		
		return repo.addData();
	}
	
	

}
