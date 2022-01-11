package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.entity.Drink;
import com.springboot.demo.model.entity.Refill;
import com.springboot.demo.model.entity.SaleList;

public interface RefillRepository extends JpaRepository<Refill, Integer>{

//	@Query(value="SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN course_tbl ON blog_tbl.blog_id=:courseId", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId);
//	
//	@Query(value="WITH tbl AS(SELECT * FROM course_tbl WHERE course_tbl.author_name=:authorName AND course_tbl.course_id=:courseId)SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN tbl ON blog_tbl.blog_id=tbl.blog_id", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId, @Param("authorName") String authorName);
	@Query(value="SELECT COUNT(tea_refill) FROM refill_tbl WHERE tea_refill>0", nativeQuery = true)
	public Integer retrieveTeaTotalCount();
	
	@Query(value="SELECT COUNT(coffee_refill) FROM refill_tbl WHERE coffee_refill>0", nativeQuery = true)
	public Integer retrieveCoffeeTotalCount();

	@Query(value="SELECT COUNT(milk_refill) FROM refill_tbl WHERE milk_refill>0", nativeQuery = true)
	public Integer retrieveMilkTotalCount();
	
	@Query(value="SELECT COUNT(water_refill) FROM refill_tbl WHERE water_refill>0", nativeQuery = true)
	public Integer retrieveWaterTotalCount();
	
	@Query(value="SELECT COUNT(sugar_refill) FROM refill_tbl WHERE sugar_refill>0", nativeQuery = true)
	public Integer retrieveSugarTotalCount();
	
	//--------------------------------------------------------------------
	@Query(value="SELECT COUNT(tea_refill) FROM refill_tbl WHERE tea_refill>0 AND date= CURRENT_DATE", nativeQuery = true)
	public Integer retrieveTeaTotalDailyCount();
	
	@Query(value="SELECT COUNT(coffee_refill) FROM refill_tbl WHERE coffee_refill>0 AND date= CURRENT_DATE", nativeQuery = true)
	public Integer retrieveCoffeeTotalDailyCount();

	@Query(value="SELECT COUNT(milk_refill) FROM refill_tbl WHERE milk_refill>0 AND date= CURRENT_DATE", nativeQuery = true)
	public Integer retrieveMilkTotalDailyCount();
	
	@Query(value="SELECT COUNT(water_refill) FROM refill_tbl WHERE water_refill>0 AND date= CURRENT_DATE", nativeQuery = true)
	public Integer retrieveWaterTotalDailyCount();
	
	@Query(value="SELECT COUNT(sugar_refill) FROM refill_tbl WHERE sugar_refill>0 AND date= CURRENT_DATE", nativeQuery = true)
	public Integer retrieveSugarTotalDailyCount();
}
