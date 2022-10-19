package com.cg.pravin.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NavgationMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer navId;
	private String navName;
	private String urlName;
	private boolean loginStat;
	public NavgationMenu() {
		
	}
	public NavgationMenu(Integer navId, String navName, String urlName, boolean loginStat) {
		super();
		this.navId = navId;
		this.navName = navName;
		this.urlName = urlName;
		this.loginStat = loginStat;
	}
	public Integer getNavId() {
		return navId;
	}
	public void setNavId(Integer navId) {
		this.navId = navId;
	}
	public String getNavName() {
		return navName;
	}
	public void setNavName(String navName) {
		this.navName = navName;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public boolean isLoginStat() {
		return loginStat;
	}
	public void setLoginStat(boolean loginStat) {
		this.loginStat = loginStat;
	}
	@Override
	public String toString() {
		return "navgationMenu [navId=" + navId + ", navName=" + navName + ", urlName=" + urlName + ", loginStat="
				+ loginStat + "]";
	}
	
}
