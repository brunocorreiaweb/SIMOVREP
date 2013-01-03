package pt.isep.dei.simov.android.sellit.data.dto.entity;

import pt.isep.dei.simov.android.sellit.data.dto.SELLITDTO;

public class AcountDTO implements SELLITDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long accountId;
	private long userId;
	private long externalSiteId;
	private String accountUsername;
	private String accountPassword;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getExternalSiteId() {
		return externalSiteId;
	}

	public void setExternalSiteId(long externalSiteId) {
		this.externalSiteId = externalSiteId;
	}

	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
}
