import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class AlgoFourmisVoygComerc
{
    static Vector<Integer> villeViste = new Vector<Integer>();
    Vector<Integer> saveDistance = new Vector<Integer>();
    Vector<Vector<Integer>> saveTrajet = new Vector<Vector<Integer>>();
    static Hashtable<Integer, Vector<Integer>> sauvgardeDistanceTrajet= new Hashtable<Integer, Vector<Integer>>();
    
    static double CalculPheromone(int villeCourante)
    {
        float sommePheromone = 0;
        for (int ville = 0;
        ville<InputUser.villeNonViste.size();
        ville++)
        {
            if (villeCourante != InputUser.villeNonViste.elementAt(ville) )   sommePheromone += InputUser.matricePheromone [villeCourante][InputUser.villeNonViste.elementAt(ville)];
        }
        float foundValueRandom = (float) (Math.random()* (sommePheromone * 1000))/(1000);
        return foundValueRandom;
    }
    static void TraitementAlgoFourmis()
    {
    	InputUser.CreateListeVilleNonViste();
        villeViste.clear();
        int sommeDistance = 0;
        int villeCourante = InputUser.villeNonViste.elementAt(0);
        villeViste.add(villeCourante);
        InputUser.villeNonViste.remove(0);
        while (InputUser.nombreVille > villeViste.size() )
        {
            double X_Random = CalculPheromone(villeCourante);
            for (int ville = 0;
            ville < InputUser.villeNonViste.size();
            ville++)
            {
                if (villeCourante != InputUser.villeNonViste.elementAt(ville))
                {
                    if (InputUser.matricePheromone [villeCourante][InputUser.villeNonViste.elementAt(ville)] > X_Random)
                    {
                        sommeDistance += InputUser.matriceDistance [villeCourante][ InputUser.villeNonViste.elementAt(ville)];
                        int newville = InputUser.villeNonViste.elementAt(ville);
                        Iterator<Integer> itr = InputUser.villeNonViste.iterator() ;
                        villeViste.add(newville );
                        while( itr.hasNext() )
                        {
                            if ( itr.next().equals(newville) )   itr.remove();
                        }
                        villeCourante = newville;
                        break;
                    }
                    else if ( ville == InputUser.villeNonViste.size() - 1 )
                    {
                        int randomNum = (int)(Math.random()*InputUser.villeNonViste.size() - 1 );
                        sommeDistance += InputUser.matriceDistance [villeCourante][ InputUser.villeNonViste.elementAt(randomNum)];
                        int newville = InputUser.villeNonViste.elementAt(randomNum);
                        Iterator<Integer> itr = InputUser.villeNonViste.iterator() ;
                        villeViste.add(newville );
      
                        while( itr.hasNext() )
                        {
                            if ( itr.next().equals(newville) )  itr.remove();
                        }
                        villeCourante = newville;
                    }
                }
            }
        }
        System.out.println("- Trajet : " + villeViste + " ---> Distance : "+ sommeDistance);
    }
    static void UpdatePheromone()
    {
        for ( int indiceTrajet = 0 ;
        indiceTrajet < villeViste.size() - 1 ;
        indiceTrajet ++ )
        {
            InputUser.matricePheromone[ villeViste.elementAt(indiceTrajet)][villeViste.elementAt(indiceTrajet + 1 )] += 0.5 ;
        }
    }
    static void VaporisationPheromone()
    {
        for ( int i =0 ;
        i<InputUser.nombreVille ;
        i++)
        {
            for (int j = 0 ;
            j<InputUser.nombreVille ;
            j++)  InputUser.matricePheromone[i][j] = (float) (InputUser.matricePheromone[i][j] - (InputUser.NombrePheromones/InputUser.nombreFourmis)) ;
        }
    }
    static void AlgoFourmisVoygCommerce()
    {
        for (int indiceTrajet = 1 ;
        indiceTrajet<= InputUser.nombreFourmis ;
        indiceTrajet++)
        {
            TraitementAlgoFourmis();
            UpdatePheromone();
            if ( indiceTrajet % 2 != 0 )
            {
                VaporisationPheromone();
            }
        }
        Enumeration<Vector<Integer>> trajet = sauvgardeDistanceTrajet.elements();
        Enumeration<Integer> distance = sauvgardeDistanceTrajet.keys();
        while(trajet.hasMoreElements())   System.out.println("Tarjet : " + trajet.nextElement() + "t --- > t Distance : "+ distance.nextElement());
    }
    /**  * @param args  */  
}