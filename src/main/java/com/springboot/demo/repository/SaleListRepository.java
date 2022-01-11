package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.entity.Drink;
import com.springboot.demo.model.entity.SaleList;

public interface SaleListRepository extends JpaRepository<SaleList, Integer>{

//	@Query(value="SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN course_tbl ON blog_tbl.blog_id=:courseId", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId);
//	
//	@Query(value="WITH tbl AS(SELECT * FROM course_tbl WHERE course_tbl.author_name=:authorName AND course_tbl.course_id=:courseId)SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN tbl ON blog_tbl.blog_id=tbl.blog_id", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId, @Param("authorName") String authorName);
	@Query(value="WITH temp_tbl AS(SELECT drink_id FROM drink_tbl WHERE name=:drinkType) SELECT SUM(salelist_tbl.number_of_cup) FROM salelist_tbl INNER JOIN temp_tbl ON salelist_tbl.drink_id= temp_tbl.drink_id", nativeQuery = true)
	public Integer retrieveTotalNumberOfCupUsingDrinkType(@Param("drinkType") String drinkType);
	
	@Query(value="WITH temp_tbl AS(SELECT drink_id FROM drink_tbl WHERE name=:drinkType) SELECT SUM(salelist_tbl.number_of_cup) FROM salelist_tbl INNER JOIN temp_tbl ON salelist_tbl.drink_id= temp_tbl.drink_id AND salelist_tbl.date= CURRENT_DATE", nativeQuery = true )
	public Integer retrieveDailyTotalNumberOfCupUsingDrinkType(@Param("drinkType") String drinkType);
	
}
