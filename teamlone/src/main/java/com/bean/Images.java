package com.bean;

public class Images {
	private int image_id;
	private String image_url;
	private String link_address;
	private String title;
	private Imges_type t_id;
	private int series_number;
	private String preview_url;
	private String color;
	private String describes;
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getLink_address() {
		return link_address;
	}
	public void setLink_address(String link_address) {
		this.link_address = link_address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSeries_number() {
		return series_number;
	}
	public void setSeries_number(int series_number) {
		this.series_number = series_number;
	}
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Imges_type getT_id() {
		return t_id;
	}
	public void setT_id(Imges_type t_id) {
		this.t_id = t_id;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	@Override
	public String toString() {
		return "Images [image_id=" + image_id + ", image_url=" + image_url + ", link_address=" + link_address
				+ ", title=" + title + ", t_id=" + t_id + ", series_number=" + series_number + ", preview_url="
				+ preview_url + ", color=" + color + ", describes=" + describes + "]";
	}
}
