package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.entity.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer>{

//	@Query(value="SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN course_tbl ON blog_tbl.blog_id=:courseId", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId);
//	
//	@Query(value="WITH tbl AS(SELECT * FROM course_tbl WHERE course_tbl.author_name=:authorName AND course_tbl.course_id=:courseId)SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN tbl ON blog_tbl.blog_id=tbl.blog_id", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId, @Param("authorName") String authorName);
	@Query(value="SELECT drink_id FROM drink_tbl WHERE name=:drinkType", nativeQuery = true)
	public Integer retrieveDrinkId(@Param("drinkType") String drinkType);
	
	@Query(value="SELECT cost FROM drink_tbl WHERE name=:drinkType", nativeQuery = true)
	public Float retrieveCostPerDrinkType(@Param("drinkType") String drinkType);

}
