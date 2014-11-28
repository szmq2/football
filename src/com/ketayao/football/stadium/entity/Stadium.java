/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.stadium.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ketayao.ketacustom.entity.Idable;

@Entity
@Table(name="t_stadium")
public class Stadium implements Idable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 名称
	 */
    @Column(length=20)
    private String name;
    
	/**
	 * 介绍
	 */
    @Column(length=500)
    private String descs;
    
	/**
	 * 省市区
	 */
    @Column(length=10)
    private Integer area;
    
	/**
	 * 地址
	 */
    @Column(length=500)
    private String address;
    
	/**
	 * 经度
	 */
    @Column(length=12)
    private Double longitude;
    
	/**
	 * 纬度
	 */
    @Column(length=12)
    private Double latitude;
    
	/**
	 * 介绍地址
	 */
    @Column(length=500)
    private String descUrl;
    
	/**
	 * 视频地址
	 */
    @Column(length=500)
    private String videoUrl;
    
	/**
	 * 创建时间
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
	/**
	 * 更新时间
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    
	/**
	 * 状态
	 */
    @Column(length=3)
    private Integer status;
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param name the name to set
	 */
    public void setName(String name){
       this.name = name;
    }
    
    /**
     * @return the name 
     */
    public String getName(){
       return this.name;
    }
	
	/**
	 * @param descs the descs to set
	 */
    public void setDescs(String descs){
       this.descs = descs;
    }
    
    /**
     * @return the descs 
     */
    public String getDescs(){
       return this.descs;
    }
	
	/**
	 * @param area the area to set
	 */
    public void setArea(Integer area){
       this.area = area;
    }
    
    /**
     * @return the area 
     */
    public Integer getArea(){
       return this.area;
    }
	
	/**
	 * @param address the address to set
	 */
    public void setAddress(String address){
       this.address = address;
    }
    
    /**
     * @return the address 
     */
    public String getAddress(){
       return this.address;
    }
	
	/**
	 * @param longitude the longitude to set
	 */
    public void setLongitude(Double longitude){
       this.longitude = longitude;
    }
    
    /**
     * @return the longitude 
     */
    public Double getLongitude(){
       return this.longitude;
    }
	
	/**
	 * @param latitude the latitude to set
	 */
    public void setLatitude(Double latitude){
       this.latitude = latitude;
    }
    
    /**
     * @return the latitude 
     */
    public Double getLatitude(){
       return this.latitude;
    }
	
	/**
	 * @param descUrl the descUrl to set
	 */
    public void setDescUrl(String descUrl){
       this.descUrl = descUrl;
    }
    
    /**
     * @return the descUrl 
     */
    public String getDescUrl(){
       return this.descUrl;
    }
	
	/**
	 * @param videoUrl the videoUrl to set
	 */
    public void setVideoUrl(String videoUrl){
       this.videoUrl = videoUrl;
    }
    
    /**
     * @return the videoUrl 
     */
    public String getVideoUrl(){
       return this.videoUrl;
    }
	
	/**
	 * @param createTime the createTime to set
	 */
    public void setCreateTime(Date createTime){
       this.createTime = createTime;
    }
    
    /**
     * @return the createTime 
     */
    public Date getCreateTime(){
       return this.createTime;
    }
	
	/**
	 * @param updateTime the updateTime to set
	 */
    public void setUpdateTime(Date updateTime){
       this.updateTime = updateTime;
    }
    
    /**
     * @return the updateTime 
     */
    public Date getUpdateTime(){
       return this.updateTime;
    }
	
	/**
	 * @param status the status to set
	 */
    public void setStatus(Integer status){
       this.status = status;
    }
    
    /**
     * @return the status 
     */
    public Integer getStatus(){
       return this.status;
    }
}
