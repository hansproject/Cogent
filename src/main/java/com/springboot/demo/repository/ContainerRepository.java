package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.entity.Containers;
import com.springboot.demo.model.entity.Drink;
import com.springboot.demo.model.entity.Refill;
import com.springboot.demo.model.entity.SaleList;

public interface ContainerRepository extends JpaRepository<Containers, Integer>{

//	@Query(value="SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN course_tbl ON blog_tbl.blog_id=:courseId", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId);
//	
//	@Query(value="WITH tbl AS(SELECT  FROM course_tbl WHERE course_tbl.author_name=:authorName AND course_tbl.course_id=:courseId)SELECT blog_tbl.blog_id, blog_tbl.blog_content, blog_tbl.blog_rating, blog_tbl.blog_upload_date FROM blog_tbl INNER JOIN tbl ON blog_tbl.blog_id=tbl.blog_id", nativeQuery = true)
//	public List<Object> retrieveBlogsBasedCoures(@Param("courseId") int courseId, @Param("authorName") String authorName);
	@Query(value="SELECT tea_container FROM containers_tbl", nativeQuery = true)
	public float getAvaibleTeaCapacity();
	
	@Query(value="SELECT coffee_container FROM containers_tbl", nativeQuery = true)
	public float getAvaibleCoffeeCapacity();
	
	@Query(value="SELECT milk_container FROM containers_tbl", nativeQuery = true)
	public float getAvaibleMilkCapacity();
	
	@Query(value="SELECT water_container FROM containers_tbl", nativeQuery = true)
	public float getAvaibleWaterCapacity();
	
	@Query(value="SELECT sugar_container FROM containers_tbl", nativeQuery = true)
	public float getAvaibleSugarCapacity();
}
