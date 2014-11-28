/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.schedule.entity;

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
@Table(name="t_schedule_detail")
public class ScheduleDetail implements Idable<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 赛程
	 */
    @Column(length=10)
    private Integer idSchedule;
    
	/**
	 * 体育场
	 */
    @Column(length=10)
    private Integer idStadium;
    
	/**
	 * 分组名称
	 */
    @Column(length=20)
    private String groupName;
    
	/**
	 * 名称
	 */
    @Column(length=20)
    private String name;
    
	/**
	 * 排序
	 */
    @Column(length=10)
    private Integer sort;
    
	/**
	 * 比赛日期
	 */
    @Column(length=10)
	@Temporal(TemporalType.DATE)
    private Date date;
    
	/**
	 * 开始时间
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    
	/**
	 * 结束时间
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    
	/**
	 * 球队1
	 */
    @Column(length=10)
    private Integer idTeam1;
    
	/**
	 * 球队2
	 */
    @Column(length=10)
    private Integer idTeam2;
    
	/**
	 * 比分1
	 */
    @Column(length=10)
    private Integer score1;
    
	/**
	 * 比分2
	 */
    @Column(length=10)
    private Integer score2;
    
	/**
	 * 视频地址
	 */
    @Column(length=500)
    private String videoUrl;
    
	/**
	 * 比赛介绍地址
	 */
    @Column(length=500)
    private String descUrl;
    
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
	 * @param idSchedule the idSchedule to set
	 */
    public void setIdSchedule(Integer idSchedule){
       this.idSchedule = idSchedule;
    }
    
    /**
     * @return the idSchedule 
     */
    public Integer getIdSchedule(){
       return this.idSchedule;
    }
	
	/**
	 * @param idStadium the idStadium to set
	 */
    public void setIdStadium(Integer idStadium){
       this.idStadium = idStadium;
    }
    
    /**
     * @return the idStadium 
     */
    public Integer getIdStadium(){
       return this.idStadium;
    }
	
	/**
	 * @param groupName the groupName to set
	 */
    public void setGroupName(String groupName){
       this.groupName = groupName;
    }
    
    /**
     * @return the groupName 
     */
    public String getGroupName(){
       return this.groupName;
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
	 * @param date the date to set
	 */
    public void setDate(Date date){
       this.date = date;
    }
    
    /**
     * @return the date 
     */
    public Date getDate(){
       return this.date;
    }
	
	/**
	 * @param startTime the startTime to set
	 */
    public void setStartTime(Date startTime){
       this.startTime = startTime;
    }
    
    /**
     * @return the startTime 
     */
    public Date getStartTime(){
       return this.startTime;
    }
	
	/**
	 * @param endTime the endTime to set
	 */
    public void setEndTime(Date endTime){
       this.endTime = endTime;
    }
    
    /**
     * @return the endTime 
     */
    public Date getEndTime(){
       return this.endTime;
    }
	
	/**
	 * @param idTeam1 the idTeam1 to set
	 */
    public void setIdTeam1(Integer idTeam1){
       this.idTeam1 = idTeam1;
    }
    
    /**
     * @return the idTeam1 
     */
    public Integer getIdTeam1(){
       return this.idTeam1;
    }
	
	/**
	 * @param idTeam2 the idTeam2 to set
	 */
    public void setIdTeam2(Integer idTeam2){
       this.idTeam2 = idTeam2;
    }
    
    /**
     * @return the idTeam2 
     */
    public Integer getIdTeam2(){
       return this.idTeam2;
    }
	
	/**
	 * @param score1 the score1 to set
	 */
    public void setScore1(Integer score1){
       this.score1 = score1;
    }
    
    /**
     * @return the score1 
     */
    public Integer getScore1(){
       return this.score1;
    }
	
	/**
	 * @param score2 the score2 to set
	 */
    public void setScore2(Integer score2){
       this.score2 = score2;
    }
    
    /**
     * @return the score2 
     */
    public Integer getScore2(){
       return this.score2;
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
