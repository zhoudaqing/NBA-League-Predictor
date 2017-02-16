package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class NOP extends Team implements Roster{

	public NOP()
	{
		this.teamName = "NOP";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public NOP(int weekNumber)
	{
		this.teamName = "NOP";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public NOP(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "NOP";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("NOP", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("NOP", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("NOP",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
