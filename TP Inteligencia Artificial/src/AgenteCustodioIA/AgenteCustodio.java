package AgenteCustodioIA;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;

public class AgenteCustodio extends SearchBasedAgent {

	private String estrategia;
	
	public AgenteCustodio(String estrategia) {
		AgenteCustodioGoal goal= new AgenteCustodioGoal();
		
		AgenteCustodioState agentState= new AgenteCustodioState();
		this.setAgentState(agentState);
		
		Vector<SearchAction> actions= new Vector<SearchAction>();
		int cantNodos= agentState.getMapaConocido().size();
		for(int i=0; i<cantNodos; i++) {
			actions.addElement(new AvanzarConCongestion(i));
			actions.addElement(new Avanzar(i));
			
		}
		actions.addElement(new Multar());
		
		Problem problem= new Problem(goal, agentState, actions);
		this.setProblem(problem);
		
		
		this.estrategia=estrategia;
	}
	
	
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
		
	}

	@Override
	public Action selectAction() {
		
		switch(this.estrategia) {
			case "Costo Uniforme":
				IStepCostFunction costo= new FuncionCosto();
				UniformCostSearch uniformCostSearch= new UniformCostSearch(costo);
				
				Search uniformCostSearchSolver= new Search(uniformCostSearch);
				uniformCostSearchSolver.setVisibleTree(Search.EFAIA_TREE);
				this.setSolver(uniformCostSearchSolver);
				break;
			
			case "Amplitud":
				BreathFirstSearch breathFirstSearch= new BreathFirstSearch();
				
				Search breathSearchSolver= new Search(breathFirstSearch);
				breathSearchSolver.setVisibleTree(Search.EFAIA_TREE);
				this.setSolver(breathSearchSolver);
				break;
				
			case "Profundidad":
				DepthFirstSearch depthFirstSearch= new DepthFirstSearch();
				
				Search depthSearchSolver= new Search(depthFirstSearch);
				depthSearchSolver.setVisibleTree(Search.EFAIA_TREE);
				this.setSolver(depthSearchSolver);
				break;
		}
		
		Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCustodio.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
	}
	
	/*AgenteCustodioState getAgenteCustodioState() {
		return (AgenteCustodioState) this.getAgentState();
	}*/

}
