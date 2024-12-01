package interfaces;

public interface ICheckUsage {
   void checkUsage();

   default void clearCache(){
       System.out.println("Cache has been cleared");
   };
}
