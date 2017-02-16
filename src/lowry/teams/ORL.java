package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class ORL extends Team implements Roster{

	public ORL()
	{
		this.teamName = "ORL";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public ORL(int weekNumber)
	{
		this.teamName = "ORL";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public ORL(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "ORL";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("ORL", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("ORL", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("ORL",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
