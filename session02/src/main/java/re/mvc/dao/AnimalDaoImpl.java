package re.mvc.dao;

import org.springframework.stereotype.Repository;
import re.mvc.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalDaoImpl {
    private List<Animal> animals=new ArrayList<>();
   public AnimalDaoImpl() {
       animals.add(new Animal(1,"cho","haha"));
       animals.add(new Animal(1,"cho","haha"));
       animals.add(new Animal(1,"cho","haha"));
   }
   public List<Animal> getAnimals() {
       return animals;
   }
}

