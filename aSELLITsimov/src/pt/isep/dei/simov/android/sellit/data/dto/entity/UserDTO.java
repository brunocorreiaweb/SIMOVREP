package pt.isep.dei.simov.android.sellit.data.dto.entity;

import pt.isep.dei.simov.android.sellit.data.dto.SELLITDTO;

public class UserDTO implements SELLITDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userId;
	private String name;
	private String userName;
	private String password;
	private long imageId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

}
