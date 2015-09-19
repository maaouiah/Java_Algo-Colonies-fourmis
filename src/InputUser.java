import java.util.Scanner;
import java.util.Vector;


public class InputUser {
	
	  static float[][] matriceDistance  ;
	  static float[][] matricePheromone  ;
	  static int nombreVille ;
	  static int nombreFourmis;
	  static float NombrePheromones;
	  static Vector<Integer> villeNonViste = new Vector<Integer>();
	  
	  static public void InputNombreVille()
	  {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Veuillez saisir le nombre de ville : ");
	      nombreVille = sc.nextInt();
	  }
	  static public void InputNombreFourmis()
	  {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Veuillez saisir le nombre de Fourmis :");
	      nombreFourmis = sc.nextInt();
	  }
	  static public void CreatMatriceDistance()
	  {
	      matriceDistance = new float[nombreVille][nombreVille];
	      Scanner distanceMinimal = new Scanner(System.in);
	      System.out.println("Veuillez saisir la distance minimale :");
	      int distanceMin = distanceMinimal.nextInt();
	      Scanner distanceMaximal = new Scanner(System.in);
	      System.out.println("Veuillez saisir la distance maximale :");
	      int distanceMax = distanceMaximal.nextInt();
	      for(int i=0;
	      i<nombreVille;
	      i++)
	      {
	          for(int j=0;
	          j<nombreVille;
	          j++)
	          {
	              if (i != j)  matriceDistance[i] [j] = (int) (Math.random() *(distanceMax-distanceMin));
	              else  matriceDistance[i] [j] = 0;
	          }
	      }
	  }
	  static public void CreatMatricePheromones()
	  {
	      matricePheromone=new float[nombreVille][nombreVille];
	      Scanner pheromones = new Scanner(System.in);
	      System.out.println("Veuillez saisir le nombre de PhŽromones Initiale:");
	      NombrePheromones = pheromones.nextInt();
	      for(int i=0;
	      i<nombreVille;
	      i++)
	      {
	          for(int j=0;
	          j<nombreVille;
	          j++)
	          {
	              matricePheromone[i] [j] = NombrePheromones;
	          }
	      }
	  }
	  static public void AfficherMatrice( float[][] matrice)
	  {
	      for(int i=0;
	      i<matrice.length;
	      i++)
	      {
	          for(int j=0;
	          j<matrice[i].length;
	          j++)
	          {
	              System.out.print("\t"+ matrice [i] [j]);
	          }
	          System.out.print("\n");
	      }
	  }
	  static public void CreateListeVilleNonViste()
	  {
	      villeNonViste.clear();
	      for(int indiceVille=0;
	      indiceVille<nombreVille;
	      indiceVille++)   villeNonViste.add(indiceVille);
	  }

	public InputUser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
