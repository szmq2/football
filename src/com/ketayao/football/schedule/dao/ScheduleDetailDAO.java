/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.ketayao.football.schedule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ketayao.football.schedule.entity.ScheduleDetail;

public interface ScheduleDetailDAO extends JpaRepository<ScheduleDetail, Long>, JpaSpecificationExecutor<ScheduleDetail> {

}