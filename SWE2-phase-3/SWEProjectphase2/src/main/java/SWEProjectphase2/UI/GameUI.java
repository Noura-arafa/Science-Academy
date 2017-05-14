package SWEProjectphase2.UI;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
   @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.POST,value="/createcompletegame/{coursename}/{teacherid}")
    public void createcompletegame(@PathVariable String coursename, @PathVariable String teacherid,@RequestBody Complete cgame){
    	gameservice.AddcompleteGameinDateBase(coursename,teacherid,cgame);
    	
    }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.POST,value="/editcompletegame/{teacherid}")
    public void Editcompletegame( @PathVariable String teacherid,@RequestBody Complete cgame){
    	gameservice. EditcompleteGame(cgame,teacherid);
    	
    }
  @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.POST,value="/editmatchinggame/{teacherid}")
    public void EditmatchingGame( @PathVariable String teacherid,@RequestBody Matching mgame){
    	gameservice. EditmatchingGame(mgame,teacherid);
    	
    }
  @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.POST,value="/AddComment/{gamename}/{userid}")
    public void Addcomment( @PathVariable String gamename,@PathVariable String userid ,@RequestBody String Comment){
    	System.out.println(gamename +" " +  userid +" "+  Comment );
    	gameservice.AddComment( gamename ,  userid ,  Comment  );
    	System.out.println("f");
    }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.POST,value="/creatematchinggame/{coursename}/{teacherid}")
    public  void creatematchinggame(@PathVariable String coursename, @PathVariable String teacherid ,@RequestBody Matching Mgame ){
    	
    	gameservice.AddmatchingGameinDateBase(coursename,teacherid,Mgame);
    }
    
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/ShowGamesInCourse/{coursename}")
    public ArrayList<Game> ShowGamesInCourse(@PathVariable String coursename){
    	System.out.println("da5allll " + coursename);
    	return gameservice.ShowGamesInCourse(coursename);
    }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/Playgame/{gamename}")
    public Game playgame(@PathVariable String gamename) {
    	return gameservice.playgame(gamename);
    	
    }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/gametype/{gamename}")
    public boolean gametype(@PathVariable String gamename){
    	
    	return gameservice.gametype(gamename);
    }
    
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.POST,value="/submitanswer/{gamename}/{Userid}")
    public  @ResponseBody int submitanswer(@PathVariable String gamename,@PathVariable String Userid,@RequestBody ArrayList<String> answers) {
    	return gameservice.Submitanwers(gamename, Userid, answers);
    	
    }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/CopyGame/{techemail}/{gamename}/{newName}/{Coursename}")
  public  boolean CopyGame(@PathVariable String techemail,@PathVariable String gamename,@PathVariable String newName,@PathVariable String Coursename){
    	System.out.println("the name "+techemail);
	   return  gameservice.copyGame(techemail,gamename,newName,Coursename);
   }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/AddGameCollaborator/{gamename}/{newemail}")
   public void AddGameCollaborator(@PathVariable String gamename,@PathVariable String newemail){
    	System.out.println("the gamename "+gamename+" "+newemail);
    	gameservice.AddGameCollaborator(gamename, newemail);
	   
   }
  @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/Cancelgame/{gamename}/{email}")
    public void Cancelgame(@PathVariable String gamename,@PathVariable String email){
    	gameservice.Cancelgame(gamename, email);
    }
  @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/showcanceledgames/{teacheremail}")
    public ArrayList<String> showcanceledgames(@PathVariable String teacheremail){
    	return gameservice.showcanceledgames(teacheremail);
    }
  @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/ShowGamesForTeacher/{teacheremail}")
    public ArrayList<Game> ShowGamesForTeacher(@PathVariable String teacheremail){
    	return gameservice.ShowGamesForTeacher(teacheremail);
    }
    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(method=RequestMethod.GET,value="/unCancelgame/{gamename}/{email}")
    public void unCancelgame(@PathVariable String gamename,@PathVariable String email){
    	gameservice.unCancelgame(gamename,email);
    }
    
}
