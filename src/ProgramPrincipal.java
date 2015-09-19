public class ProgramPrincipal
{
    public void ExecutionModeConsole()
    {
        // TODO Auto-generated method stub  InputUser.InputNombreVille();
    	InputUser.InputNombreVille();
        InputUser.InputNombreFourmis();
        InputUser.CreatMatriceDistance();
        InputUser.CreatMatricePheromones();
        System.out.println("- Matrice de distances :");
        InputUser.AfficherMatrice(InputUser.matriceDistance);
        System.out.println("\n \n- Matrice de Pheromones :");
        InputUser.AfficherMatrice(InputUser.matricePheromone);
        AlgoFourmisVoygComerc.AlgoFourmisVoygCommerce();
        System.out.println(" \n \n- Matrice de New Pheromones : ");
        InputUser.AfficherMatrice(InputUser.matricePheromone);
    }
    public static void main(String[] args)
    {
        ProgramPrincipal PP = new ProgramPrincipal();
        PP.ExecutionModeConsole();
    }
}