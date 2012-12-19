/**
 * 
 */
package pt.isep.dei.simov.android.sellit.data.dto.entity;

import pt.isep.dei.simov.android.sellit.data.dto.SELLITDTO;

/**
 * @author Utilizador
 * 
 */
public class ExternalSiteDTO implements SELLITDTO {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long externalSiteId;
	private String externalSiteName = null;
	private String externalSiteUrl = null;
	private boolean externalSiteSocialNetwork;
	private String externalSiteDescription = null;

	public long getExternalSiteId() {
		return externalSiteId;
	}

	public void setExternalSiteId(long externalSiteId) {
		this.externalSiteId = externalSiteId;
	}

	public String getExternalSiteName() {
		return externalSiteName;
	}

	public void setExternalSiteName(String externalSiteName) {
		this.externalSiteName = externalSiteName;
	}

	public String getExternalSiteUrl() {
		return externalSiteUrl;
	}

	public void setExternalSiteUrl(String externalSiteUrl) {
		this.externalSiteUrl = externalSiteUrl;
	}

	public boolean isExternalSiteSocialNetwork() {
		return externalSiteSocialNetwork;
	}

	public void setExternalSiteSocialNetwork(boolean externalSiteSocialNetwork) {
		this.externalSiteSocialNetwork = externalSiteSocialNetwork;
	}

	public String getExternalSiteDescription() {
		return externalSiteDescription;
	}

	@Override
	public String toString() {
		return null;
	}

}
