package com.bookstore.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bookstore.domen.User;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable{
	
	private static long serialVersionUID = 890345L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long useRoleId;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	
	

	public UserRole() {
		super();
	}



	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public static void setSerialVersionUID(long serialVersionUID) {
		UserRole.serialVersionUID = serialVersionUID;
	}



	public long getUseRoleId() {
		return useRoleId;
	}



	public void setUseRoleId(long useRoleId) {
		this.useRoleId = useRoleId;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}
	
	

	
}
