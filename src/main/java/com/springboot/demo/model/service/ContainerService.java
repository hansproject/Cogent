package com.springboot.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.demo.exceptions.ContainerNotFoundException;
import com.springboot.demo.model.entity.Containers;
import com.springboot.demo.repository.ContainerRepository;

@Service
public class ContainerService {

	public ContainerService() {super();}
	
	@Autowired
	ContainerRepository containerRepo;
	
	public void addContainer(Containers c) {
		containerRepo.save(c);
	}
	
	public Containers retrieveContainerById(int containerId) {
		return containerRepo.findById(containerId).orElseThrow(()->{throw new ContainerNotFoundException();});
	}
	
//	public List<Object> retrieveBlogsBasedCoures(int courseId, String authorName){
//		if(authorName==null) {
//			return blogRepo.retrieveBlogsBasedCoures(courseId);
//		}
//		return blogRepo.retrieveBlogsBasedCoures(courseId, authorName);
//	}
	public float retrieveContainerAvailableCapacity(String containerName) throws ContainerNotFoundException{
		if(containerName.equals("Tea")) {
			return containerRepo.getAvaibleTeaCapacity();
		}
		else if(containerName.equals("Coffee")) {
			return containerRepo.getAvaibleCoffeeCapacity();
		}
		else if(containerName.equals("Milk")) {
			return containerRepo.getAvaibleMilkCapacity();
		}
		else if(containerName.equals("Sugar")) {
			return containerRepo.getAvaibleSugarCapacity();
		}
		else if(containerName.equals("Water")) {
			return containerRepo.getAvaibleWaterCapacity();
		}
		else
			throw new ContainerNotFoundException();
	}
	
	public List<Containers> retrieveAllContainers(){
		return containerRepo.findAll();
	}
	
	public void updateContainer(Containers c) {
		containerRepo.save(c);
	}
	
	public void deleteContainer(int containerId) {
		containerRepo.deleteById(containerId);;
	}
}
