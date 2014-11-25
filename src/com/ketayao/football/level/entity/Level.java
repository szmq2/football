/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.level.entity;

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
@Table(name="t_level")
public class Level implements Idable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 等级名称
	 */
    @Column(nullable=false, length=20)
    private String name;
    
	/**
	 * 等级排序
	 */
    @Column(length=10)
    private Integer sort;
    
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
	 * @param sort the sort to set
	 */
    public void setSort(Integer sort){
       this.sort = sort;
    }
    
    /**
     * @return the sort 
     */
    public Integer getSort(){
       return this.sort;
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
