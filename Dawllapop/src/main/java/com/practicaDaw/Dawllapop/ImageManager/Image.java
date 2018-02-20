package com.practicaDaw.Dawllapop.ImageManager;

public class Image {

	private String title;
	private String fileName;

	public Image(String title, String fileName) {
		super();
		this.title = title;
		this.fileName = fileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Image [title=" + title + ", fileName=" + fileName + "]";
	}

}
