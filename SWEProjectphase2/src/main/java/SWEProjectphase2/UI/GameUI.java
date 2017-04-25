package SWEProjectphase2.UI;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SWEProjectphase2.Model.Complete;
import SWEProjectphase2.Model.Game;
import SWEProjectphase2.Model.Matching;
import SWEProjectphase2.Service.GameService;


@RestController
public class GameUI {
	
    @Autowired
	public GameService gameservice;
  
    @RequestMapping(method=RequestMethod.POST,value="/createcompletegame/{coursename}/{teacherid}")
    public void createcompletegame(@PathVariable String coursename, @PathVariable String teacherid,@RequestBody Complete cgame){
    	gameservice.AddcompleteGameinDateBase(coursename,teacherid,cgame);
    	
    }
    @RequestMapping(method=RequestMethod.POST,value="/creatematchinggame/{coursename}/{teacherid}")
    public  void creatematchinggame(@PathVariable String coursename, @PathVariable String teacherid ,@RequestBody Matching Mgame ){
    	gameservice.AddmatchingGameinDateBase(coursename,teacherid,Mgame);
    }
    @RequestMapping(method=RequestMethod.GET,value="/ShowGamesInCourse/{coursename}")
    public ArrayList<String> ShowGamesInCourse(@PathVariable String coursename){
    	return gameservice.ShowGamesInCourse(coursename);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/Playgame/{gamename}")
    public Game playgame(@PathVariable String gamename) {
    	return gameservice.playgame(gamename);
    	
    }
    @RequestMapping(method=RequestMethod.POST,value="/submitanswer/{gamename}/{Userid}")
    public  @ResponseBody int submitanswer(@PathVariable String gamename,@PathVariable String Userid,@RequestBody ArrayList<String> answers) {
    	return gameservice.Submitanwers(gamename, Userid, answers);
    	
    }
   
    
}
