package pp_5_2;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	  public static void main(String[] args){
		  RandomNumberGenerator rng = new RandomNumberGenerator(1);
          MainClass outer = new MainClass();
	  }
	  
	  // === Struktura zawieraj¹ca rozwi¹zanie problemu plecakowego ===
      public class result
      {
          public int load;
          public int cost;
          public List<Integer> packed;
          public result(int x, int y)
          {
              cost = x;
              load = y;
              packed = new ArrayList<Integer>();
          }
      }
      // ==============================================================

      // === Problem plecakowy - rozwiazanie naiwne =======================================
      public static result knapsack(List<Integer> weight, List<Integer> values, int capacity)
      {
          if (capacity == 0)
          {
        	  System.out.print("Zerowa pojemnoœæ plecaka!");
              return null;
          }
          else
          {
        	  MainClass outer = new MainClass();
              result res = outer.new result(0, 0);
              for (int i = 0; i < values.size(); i++)
              {
                  if (res.load + weight.get(i) <= capacity)
                  {
                      res.load = res.load + weight.get(i);
                      res.cost = res.cost + values.get(i);
                      res.packed.add(i + 1);
                  }
              }
              if (values.size() == 0)
              {
                  return null;
              }
              else
                  return res;
          }
      }
}

