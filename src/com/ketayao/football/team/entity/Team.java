/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.team.entity;

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
@Table(name="t_team")
public class Team implements Idable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 球队名称
	 */
    @Column(nullable=false, length=20)
    private String name;
    
	/**
	 * 球队人数
	 */
    @Column(length=10)
    private Integer number;
    
	/**
	 * 队伍简介
	 */
    @Column(length=255)
    private String desc;
    
	/**
	 * 联系人
	 */
    @Column(nullable=false, length=20)
    private String contact;
    
	/**
	 * 
	 */
    @Column(nullable=false, length=20)
    private String phone;
    
	/**
	 * 创建时间
	 */
    @Column(nullable=false, length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
	/**
	 * 更新时间
	 */
    @Column(nullable=false, length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    
	/**
	 * 状态
	 */
    @Column(nullable=false, length=3)
    private Integer status;
    
	/**
	 * 球队等级
	 */
    @Column(nullable=false, length=10)
    private Integer idLevel;
    
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
	 * @param number the number to set
	 */
    public void setNumber(Integer number){
       this.number = number;
    }
    
    /**
     * @return the number 
     */
    public Integer getNumber(){
       return this.number;
    }
	
	/**
	 * @param desc the desc to set
	 */
    public void setDesc(String desc){
       this.desc = desc;
    }
    
    /**
     * @return the desc 
     */
    public String getDesc(){
       return this.desc;
    }
	
	/**
	 * @param contact the contact to set
	 */
    public void setContact(String contact){
       this.contact = contact;
    }
    
    /**
     * @return the contact 
     */
    public String getContact(){
       return this.contact;
    }
	
	/**
	 * @param phone the phone to set
	 */
    public void setPhone(String phone){
       this.phone = phone;
    }
    
    /**
     * @return the phone 
     */
    public String getPhone(){
       return this.phone;
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
	
	/**
	 * @param idLevel the idLevel to set
	 */
    public void setIdLevel(Integer idLevel){
       this.idLevel = idLevel;
    }
    
    /**
     * @return the idLevel 
     */
    public Integer getIdLevel(){
       return this.idLevel;
    }
}
