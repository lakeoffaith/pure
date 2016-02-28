package com.ijoy.common.domain;

/*
 * 挂号中的医院
 */
public class Hospital {
	private static final Long DEAFULT_GHTOTAL = 200L;
	private static final String  DEAFULT_PIC = "images/gh/hos1.jpg";
	private Long id;
	private String name;
	private String domain;
	private String logo;
	private String pic;
	private City city;
	private String address;
	private float x;
	private float y;
	private String tel;
	private String fax;
	private String zipcode;
	private String url;
	private String mail;
	private String gobus;
	private String level;
	private String nature;
	private String mtype;
	private int comment;
	private int count;
	private Long ghTotal;    //成功挂号的数量
	private Long ghHighScore;   //好评数量
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMail() {
		return mail;
	}
	
	public String getPic() {
		return DEAFULT_PIC;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGobus() {
		return gobus;
	}
	public void setGobus(String gobus) {
		this.gobus = gobus;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getGhTotal() {
		if(ghTotal==null || ghTotal==0){
			return DEAFULT_GHTOTAL;
		}
		return ghTotal;
	}
	public void setGhTotal(Long ghTotal) {
		this.ghTotal = ghTotal;
	}
	public Long getGhHighScore() {
		return ghHighScore;
	}
	public void setGhHighScore(Long ghHighScore) {
		this.ghHighScore = ghHighScore;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", domain=" + domain + ", logo=" + logo + ", pic=" + pic
				+ ", city=" + city + ", address=" + address + ", x=" + x + ", y=" + y + ", tel=" + tel + ", fax=" + fax
				+ ", zipcode=" + zipcode + ", url=" + url + ", mail=" + mail + ", gobus=" + gobus + ", level=" + level
				+ ", nature=" + nature + ", mtype=" + mtype + ", comment=" + comment + ", count=" + count + ", ghTotal="
				+ ghTotal + ", ghHighScore=" + ghHighScore + "]";
	}
	
	
}
