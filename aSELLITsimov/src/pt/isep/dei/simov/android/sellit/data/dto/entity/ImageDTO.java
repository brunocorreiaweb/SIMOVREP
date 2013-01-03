package pt.isep.dei.simov.android.sellit.data.dto.entity;

import pt.isep.dei.simov.android.sellit.data.dto.SELLITDTO;

public class ImageDTO implements SELLITDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long imageId;
	private String imageLocation;
	private String imageDescription;

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
}
