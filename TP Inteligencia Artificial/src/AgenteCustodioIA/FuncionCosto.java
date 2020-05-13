package AgenteCustodioIA;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

public class FuncionCosto implements IStepCostFunction{

	public double calculateCost(AgentState agentState) {
        return ((AgenteCustodioState) agentState).getCostoCamino();
    }
	
	@Override
	public double calculateCost(NTree node) {
		return 0;
	}

}
