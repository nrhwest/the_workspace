import java.time.LocalDateTime;

/**
 * Nathan West 
 * CSMC 256 
 * Project #2 
 * Purpose: To model an Image file 
 * Description: This class models the properties of an Image file. It inherits the name and
 * 				size attributes from the DigitalMedia class
 */

public class Image extends DigitalMedia implements Comparable<Image> {

	// private String name = null;
	// private long size = 0;
	private int width = 0, height = 0;

	public Image(String n, long s, int w, int h) {
		super(n, s); // inherits name/size from DigitalMedia
		width = w;
		height = h;
	}

	public void setWidth(int w) {
		if (w < 0)
			throw new IllegalArgumentException("Invalid width!");
		else
			width = w;
		LocalDateTime change = LocalDateTime.now();
		super.setDateModified(change);
	}

	public void setHeight(int h) {
		if (h < 0)
			throw new IllegalArgumentException("Invalid height!");
		else
			height = h;
		LocalDateTime change = LocalDateTime.now();
		super.setDateModified(change);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Image) {
			Image alt = (Image) obj;
			if (super.getName().equals(alt.getName())) {
				if (width == alt.getWidth()) {
					if (height == alt.getHeight()) {
						if (super.getSize() == alt.getSize())
							return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "\nTitle: " + super.getName() + "\nWidth: " + width + "\nHeight: " + height;
	}

	@Override
	public int compareTo(Image o) {
		return super.getName().toUpperCase().compareTo(o.getName().toUpperCase());
	}
}
