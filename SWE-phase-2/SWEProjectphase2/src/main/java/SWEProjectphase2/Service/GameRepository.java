package SWEProjectphase2.Service;

import org.springframework.data.repository.CrudRepository;


import SWEProjectphase2.Model.Game;

public interface GameRepository extends CrudRepository<Game,String> {

}
