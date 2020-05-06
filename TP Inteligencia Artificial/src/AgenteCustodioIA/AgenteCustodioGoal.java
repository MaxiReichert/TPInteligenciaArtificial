package AgenteCustodioIA;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class AgenteCustodioGoal extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {
		if(((AgenteCustodioState) agentState).getCiudadanosFugados().isEmpty()) {
			return true;
		}
		return false;
	}

}
